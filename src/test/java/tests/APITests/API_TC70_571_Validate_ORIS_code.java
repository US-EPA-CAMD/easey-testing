package tests.APITests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.utils.APITestBase;
import tests.utils.CSVParser;

import java.util.List;
import java.util.Map;

public class API_TC70_571_Validate_ORIS_code extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "APITestData/TS35_Validate_filter_criteria.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

    @Test(dataProvider = "csv")
    public void test(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&orisCode=%s";
        JSONArray resJSONArray;
        System.out.println(map.get("facilityName"));
//        Perform a GET request for ORIS Code = 612
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=612
        String url1 = formatURL(map, url, "orisCode");
        resJSONArray = getJSONArray(url1);
//        API returns results for Fort Myers
        System.out.println(resJSONArray.toString(4));
        for (Object r : resJSONArray) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                verifyEquals(res.getString("facilityName"), map.get("facilityName"),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
//        Perform a GET request for an invalid ORIS Code (such as -58 or 12345678 or ABC)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=ABC
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "ABC");
        Response response = getResponse(url2);
//        Status code 400
//
//        API returns a validation error collection containing the message
        String expectedResult = "ORIS code not valid. Refer to the list of available ORIS for valid values [placeholder for link to Facilities endpoint]";

        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult), "Error message does not contain error: " + expectedResult + "\n" + printResponseBody(response));

//        Testing #618
//        Perform a GET request with leading zeros for a valid ORIS code = 000612
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=000612

        String url3 = formatURL(map, url, "orisCodeZeros");
        String responseString = getString(url3);
//        API returns results for Fort Myers
        try {
            resJSONArray = new JSONArray(responseString);
//            System.out.println(resJSONArray.toString(4));
            for (Object r : resJSONArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    verifyEquals(res.getString("facilityName"), map.get("facilityName"),
                            "Response was not from the correct ORIS Code\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } catch (JSONException e) {
            verifyFail("Response in the wrong format:\n" + responseString);
        }
    }

    private String formatURL(Map<String, String> map, String url, String var) {
        return String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), map.get(var));
    }
}
