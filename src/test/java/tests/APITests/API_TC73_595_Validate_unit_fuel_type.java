package tests.APITests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.utils.APITestBase;
import tests.utils.CSVParser;

import java.util.List;
import java.util.Map;

public class API_TC73_595_Validate_unit_fuel_type extends APITestBase {

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
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&unitFuelType=%s";
        Response response;
//        Step 1: Perform a GET request for Combined cycle
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitFuelType=Wood
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Wood");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
//                    System.out.println(res.toString(4));
                    verifyEquals(res.getString("primaryFuelInfo"), "Wood",
                            "Response was not from the correct unit fuel type\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else
            verifyFail("did not get 200 response");

//        Step 2: Perform a GET request for an invalid unit type (such as ABC123 or anything not included in the list of acceptable values)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitFuelType=Invalid123
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Invalid123");
//        System.out.println(url2);
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String expectedResponse = "Unit fuel type is not valid. Refer to the list of available unit fuel types for valid values [placeholder for link to endpoint]";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        verifyTrue(resJsonObject.getJSONArray("message").toString().contains(expectedResponse),
                "Error response does not contain: \n" + expectedResponse +
                        "\n" + resJsonObject.toString(4));
    }
}
