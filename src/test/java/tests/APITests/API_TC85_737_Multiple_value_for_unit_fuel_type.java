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

public class API_TC85_737_Multiple_value_for_unit_fuel_type extends APITestBase {

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
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&unitFuelType=%s|%s";
        String unitFT1 = "Coal";
        String unitFT2 = "Wood";
//        Perform a GET request for unit fuel types of Coal and Wood
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&unitFuelType=Coal|Wood
//        Response rRes = getResponse(String.format(url, "1", 5, map.get("beginDate"), map.get("endDate"), unitFT1, unitFT2));
        JSONArray response = getJSONArray(String.format(url, "1", map.get("perPage"), map.get("beginDate"), map.get("endDate"), unitFT1, unitFT2));
//        API returns results for any fuel type containing Coal and Wood
        for (Object r : response) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                String unitFT = res.getString("primaryFuelInfo");
                verifyTrue(unitFT.equals(unitFT1) || unitFT.equals(unitFT2),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

//        Perform a GET request to test case insensitivity and allowing white space
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&unitFuelType=coal|%20wood
        response = getJSONArray(String.format(url, "1", 5, map.get("beginDate"), map.get("endDate"), unitFT1 + " ", unitFT2 + " "));
//        API returns results for Coal and Wood
        for (Object r : response) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                String unitFT = res.getString("primaryFuelInfo");
                verifyTrue(unitFT.equals(unitFT1) || unitFT.equals(unitFT2),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
    }
}
