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

public class API_TC84_736_Multiple_values_for_unit_type extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "APITestData/TS36_Allow_multiple_values.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

    @Test(dataProvider = "csv")
    public void test(Map<String, String> map) {
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&unitType=%s|%s";
        String unitType1 = "Combined cycle";
        String unitType2 = "Dry bottom wall-fired boiler";
//    Perform a GET request for unit type = Combined cycle and Dry bottom wall-fired boiler
//    https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&unitType=Dry%20bottom%20wall-fired%20boiler|Combined%20cycle
        JSONArray response = getJSONArray(String.format(url, "1", map.get("perPage"), map.get("beginDate"), map.get("endDate"), unitType1, unitType2));
//    API returns results for both unit types
        for (Object r : response) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                String unitType = res.getString("unitTypeInfo");
                verifyTrue(unitType.equals(unitType1) || unitType.equals(unitType2),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

//    Perform a GET request to test case insensitivity and allowing white space
//    https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&unitType=dry%20bottom%20wall-fired%20boiler|%20combined%20cycle
        Response rRes = getResponse(String.format(url, "1", map.get("perPage"), map.get("beginDate"), map.get("endDate"), unitType1 + " ", unitType2 + " "));
//    API returns results for both unit types
        if (rRes.getStatusCode() == 200) {
            response = new JSONArray(rRes.getBody().asString());
            for (Object r : response) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    String unitType = res.getString("unitTypeInfo");
                    verifyTrue(unitType.equals(unitType1) || unitType.equals(unitType2),
                            "Response was not from the correct ORIS Code\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else {
            verifyFail("Invalid Response Code: " + rRes.getStatusCode());
        }
    }
    
}
