package tests.APITests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class API_TC87_745_endpoint_for_unit_type extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @Test
    public void test() {
        String url = "api/master-data-mgmt/unit-types";

//    Perform a GET request for the unit type endpoint
//    https://easey-dev.app.cloud.gov/api/master-data-mgmt/unit-types
        JSONArray res = getJSONArray(url);
//    API returns results containing all valid unit types
//    And for each record will display:
//
//    Unit Type Code
//    Unit Type Description
//    Sort Order (values may be blank)
        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("unitTypeCode"));
                verifyTrue(response.has("unitTypeDescription"));
                verifyTrue(response.has("sortOrder"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
    }
}
