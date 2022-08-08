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

public class API_TC565_AllowanceComplianceEndpoints extends APITestBase {

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

    //Streaming Allowance Compliance Endpoint
    @Test(dataProvider = "csv")
    public void allowanceStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/allowance-compliance/?api_key="+apikey;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    //Allowance Owner Operator
    @Test(dataProvider = "csv")
    public void allowanceOwnOp(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url3 = "/account-mgmt/allowance-compliance/owner-operators?api_key="+apikey;

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url3);
        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("ownType"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    // Root Endpoint
    @Test(dataProvider = "csv")
    public void allowanceCompliance(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url4 = "/account-mgmt/allowance-compliance?api_key="+apikey+"&page=1&perPage=1";

        JSONArray res2 = getJSONArray(url4);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("year"));
                verifyTrue(response.has("accountNumber"));
                verifyTrue(response.has("accountName"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("unitsAffected"));
                verifyTrue(response.has("allocated"));
                verifyTrue(response.has("bankedHeld"));
                verifyTrue(response.has("currentHeld"));
                verifyTrue(response.has("totalAllowancesHeld"));
                verifyTrue(response.has("complianceYearEmissions"));
                verifyTrue(response.has("otherDeductions"));
                verifyTrue(response.has("totalRequiredDeductions"));
                verifyTrue(response.has("currentDeductions"));
                verifyTrue(response.has("totalAllowancesDeducted"));
                verifyTrue(response.has("carriedOver"));
                verifyTrue(response.has("excessEmissions"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("stateCode"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

    }

}







