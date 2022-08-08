package tests.APITests.AccountMgmtEndpoints;

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
public class API_TC568_EmissionsComplianceEndpoints extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://api.epa.gov/easey/dev");
    }

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "APITestData/TS47_API_Tests.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

    @Test(dataProvider = "csv")
    public void emissionsComplianceStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions-compliance/?api_key="+apikey;

        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);

    }
    @Test(dataProvider = "csv")
    public void emissionsComplianceOwnOp(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url2 = "/account-mgmt/emissions-compliance/owner-operators?api_key="+apikey;

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("ownType"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    @Test(dataProvider = "csv")
    public void emissionsCompliance(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url3 = "/account-mgmt/emissions-compliance/?api_key="+apikey+"&page=1&perPage=1";

        JSONArray res3 = getJSONArray(url3);

        for (Object r : res3) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("year"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("unitId"));
                verifyTrue(response.has("complianceApproach"));
                verifyTrue(response.has("avgPlanId"));
                verifyTrue(response.has("emissionsLimitDisplay"));
                verifyTrue(response.has("actualEmissionsRate"));
                verifyTrue(response.has("avgPlanActual"));
                verifyTrue(response.has("inCompliance"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("stateCode"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

}









