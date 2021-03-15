package tests.APITests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class API_TC88_746_endpoint_for_unit_fuel_type extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @Test
    public void test() {
        String url = "api/master-data-mgmt/fuel-types";

//        Perform a GET request for the unit fuel type endpoint
//        https://easey-dev.app.cloud.gov/api/master-data-mgmt/fuel-types
        JSONArray res = getJSONArray(url);
//        API returns results containing all valid unit fuel types
//        And for each record will display:
//
//        Fuel Type Code
//        Fuel Group Code
//        Fuel Type Description
        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("fuelTypeCode"));
                verifyTrue(response.has("fuelGroupCode"));
                verifyTrue(response.has("fuelTypeDescription"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
    }
}
