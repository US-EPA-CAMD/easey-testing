package tests.APITests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class API_TC89_747_endpoint_for_control_technologies extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @Test
    public void test() {
        String url = "api/master-data-mgmt/control-technologies";

//        Perform a GET request for the control technologies endpoint
//        https://easey-dev.app.cloud.gov/api/master-data-mgmt/control-technologies
        JSONArray res = getJSONArray(url);
//        API returns results containing all valid control technologies
//        And for each record will display:

//        Control Code
//        Control Description
//        Control Equip Param Code
        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("controlCode"));
                verifyTrue(response.has("controlDescription"));
                verifyTrue(response.has("controlEquipParamCode"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
    }
}
