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

public class API_TC_566_Allowance_Transactions_Streaming extends APITestBase {

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
    public void test(Map<String, String> map) {
        String url = "/account-mgmt/allowance-transactions/stream?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-31";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res = getJSONArray(url);

        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("transactionId"));
                verifyTrue(response.has("transactionTotal"));
                verifyTrue(response.has("transactionType"));
                verifyTrue(response.has("sellAccountNumber"));
                verifyTrue(response.has("sellAccountName"));
                verifyTrue(response.has("sellAccountType"));
                verifyTrue(response.has("sellFacilityName"));
                verifyTrue(response.has("sellFacilityId"));
                verifyTrue(response.has("sellState"));
                verifyTrue(response.has("sellEpaRegion"));
                verifyTrue(response.has("sellSourceCategory"));
                verifyTrue(response.has("sellOwner"));
                verifyTrue(response.has("buyAccountNumber"));
                verifyTrue(response.has("buyAccountName"));
                verifyTrue(response.has("buyAccountType"));
                verifyTrue(response.has("buyFacilityName"));
                verifyTrue(response.has("buyFacilityId"));
                verifyTrue(response.has("buyState"));
                verifyTrue(response.has("buyEpaRegion"));
                verifyTrue(response.has("buySourceCategory"));
                verifyTrue(response.has("buyOwner"));
                verifyTrue(response.has("transactionDate"));
                verifyTrue(response.has("vintageYear"));
                verifyTrue(response.has("startBlock"));
                verifyTrue(response.has("endBlock"));
                verifyTrue(response.has("totalBlock"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

    }
    @Test(dataProvider = "csv")
    public void test2(Map<String, String> map) {

        String url2 = "/account-mgmt/allowance-transactions/stream?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&stateCode=GA&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-31";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("transactionId"));
                verifyTrue(response.has("transactionTotal"));
                verifyTrue(response.has("transactionType"));
                verifyTrue(response.has("sellAccountNumber"));
                verifyTrue(response.has("sellAccountName"));
                verifyTrue(response.has("sellAccountType"));
                verifyTrue(response.has("sellFacilityName"));
                verifyTrue(response.has("sellFacilityId"));
                verifyTrue(response.has("sellState"));
                verifyTrue(response.has("sellEpaRegion"));
                verifyTrue(response.has("sellSourceCategory"));
                verifyTrue(response.has("sellOwner"));
                verifyTrue(response.has("buyAccountNumber"));
                verifyTrue(response.has("buyAccountName"));
                verifyTrue(response.has("buyAccountType"));
                verifyTrue(response.has("buyFacilityName"));
                verifyTrue(response.has("buyFacilityId"));
                verifyTrue(response.has("buyState"));
                verifyTrue(response.has("buyEpaRegion"));
                verifyTrue(response.has("buySourceCategory"));
                verifyTrue(response.has("buyOwner"));
                verifyTrue(response.has("transactionDate"));
                verifyTrue(response.has("vintageYear"));
                verifyTrue(response.has("startBlock"));
                verifyTrue(response.has("endBlock"));
                verifyTrue(response.has("totalBlock"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    @Test(dataProvider = "csv")
    public void test3(Map<String, String> map) {

        String url3 = "/account-mgmt/allowance-transactions?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&stateCode=GA&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-31&page=1&perPage=1";

        JSONArray res3 = getJSONArray(url3);

        for (Object r : res3) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("programCodeInfo"));
                verifyTrue(response.has("transactionId"));
                verifyTrue(response.has("transactionTotal"));
                verifyTrue(response.has("transactionType"));
                verifyTrue(response.has("sellAccountNumber"));
                verifyTrue(response.has("sellAccountName"));
                verifyTrue(response.has("sellAccountType"));
                verifyTrue(response.has("sellFacilityName"));
                verifyTrue(response.has("sellFacilityId"));
                verifyTrue(response.has("sellState"));
                verifyTrue(response.has("sellEpaRegion"));
                verifyTrue(response.has("sellSourceCategory"));
                verifyTrue(response.has("sellOwner"));
                verifyTrue(response.has("buyAccountNumber"));
                verifyTrue(response.has("buyAccountName"));
                verifyTrue(response.has("buyAccountType"));
                verifyTrue(response.has("buyFacilityName"));
                verifyTrue(response.has("buyFacilityId"));
                verifyTrue(response.has("buyState"));
                verifyTrue(response.has("buyEpaRegion"));
                verifyTrue(response.has("buySourceCategory"));
                verifyTrue(response.has("buyOwner"));
                verifyTrue(response.has("transactionDate"));
                verifyTrue(response.has("vintageYear"));
                verifyTrue(response.has("startBlock"));
                verifyTrue(response.has("endBlock"));
                verifyTrue(response.has("totalBlock"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

}







