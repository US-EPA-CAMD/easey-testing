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

public class API_TC76_586_Cumulative_validation extends APITestBase {

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
        String url = "/api/emissions-mgmt/apportioned/hourly/" +
                "?page=%s" +
                "&perPage=%s" +
                "&beginDate=%s" +
                "&endDate=%s" +
                "&state=%s" +
                "&orisCode=%s" +
                "&unitType=%s" +
                "&unitFuelType=%s" +
                "&controlTechnologies=%s";
        Response response;
//        Step 1: Perform a GET request for Combined cycle
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//		      state=TX&
//			  orisCode=127&
//			  unitType=Dry%20bottom%20wall-fired%20boiler&
//			  unitFuelType=Coal&
//			  controlTechnologies=Halogenated%20PAC%20Sorbent%20Injection
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"),
                "TX", "127", "Dry bottom wall-fired boiler", "Coal", "Halogenated PAC Sorbent Injection");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
//                    System.out.println(res.toString(4));
                    verifyEquals(res.getString("state"), "TX",
                            "Response was not from the correct state\n" + res.toString(4));
                    verifyEquals(res.getString("facilityName"), "Oklaunion Power Station",
                            "Response was not from the correct ORIS Code\n" + res.toString(4));
                    verifyEquals(res.getString("unitTypeInfo"), "Dry bottom wall-fired boiler",
                            "Response was not from the correct unit type\n" + res.toString(4));
                    verifyEquals(res.getString("primaryFuelInfo"), "Coal",
                            "Response was not from the correct unit fuel type\n" + res.toString(4));
                    verifyEquals(res.getString("hgControlInfo"), "Halogenated PAC Sorbent Injection",
                            "Response was not from the correct control technology\n" + res.toString(4));

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
//		      state=123&
//			  orisCode=None&
//			  unitType=invalid
//			  unitFuelType=Notvalid&
//			  controlTechnologies=Nope
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"),
                "123", "None", "invalid", "Notvalid", "Nope");
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String[] expectedResponses = {
                "The state or territory is not valid. Please enter a valid state or territory using the two letter postal abbreviation (use TX, not Texas).",
                "ORIS code not valid. Refer to the list of available ORIS for valid values [placeholder for link to Facilities endpoint]",
                "Unit type is not valid. Refer to the list of available unit types for valid values [placeholder for link to endpoint]",
                "Unit fuel type is not valid. Refer to the list of available unit fuel types for valid values [placeholder for link to endpoint]",
                "Control technologies are not valid. Refer to the list of available control technologies for valid values [placeholder for link to endpoint]"
        };
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        for(String expectedResponse : expectedResponses)
            try {
                verifyTrue(resJsonObject.getJSONArray("message").toString().contains(expectedResponse),
                        "Error response does not contain: \n" + expectedResponse +
                                "\n" + resJsonObject.toString(4));
            } catch (JSONException e) {
                verifyFail("invalid response format, expected JSONArray");
            }
    }
}
