package tests.APITests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.utils.APITestBase;
import tests.utils.CSVParser;

import java.util.List;
import java.util.Map;

public class API_TC567_AllowanceHoldingsEndpoints extends APITestBase {

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
// Allowance Holdings Streaming Endpoint
    @Test(dataProvider = "csv")
    public void allowHoldingsStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/allowance-holdings/?api_key="+apikey+"&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-31";

        JSONArray res = getJSONArray(url);

        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("accountNumber"));
                verifyTrue(response.has("accountName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("vintageYear"));
                verifyTrue(response.has("totalBlock"));
                verifyTrue(response.has("endBlock"));
                verifyTrue(response.has("statdeCode"));
                verifyTrue(response.has("epaRegion"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("accountType"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

    }
    //

    @Test(dataProvider = "csv")
    public void allowanceOwnOp(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url3 = "/account-mgmt/allowance-holdings/owner-operators?api_key="+apikey;

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
    public void allowanceHoldings(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url4 = "/account-mgmt/allowance-holdings?api_key="+apikey+"&page=1&perPage=1&transactionBeginDate=2020-01-01&transactionEndDate=2020-01-02";

        JSONArray res2 = getJSONArray(url4);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("accountNumber"));
                verifyTrue(response.has("accountName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("vintageYear"));
                verifyTrue(response.has("totalBlock"));
                verifyTrue(response.has("endBlock"));
                verifyTrue(response.has("statdeCode"));
                verifyTrue(response.has("epaRegion"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("accountType"));


            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

    }


}







