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

public class API_TC_565_Allowance_Compliance_Streaming extends APITestBase {
    String apikey = System.getenv("campdAPI");

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
        String url = "/account-mgmt/allowance-compliance/stream?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res = getJSONArray(url);

        for (Object r : res) {
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
                verifyTrue(response.has("deductOneToOne"));
                verifyTrue(response.has("deductTwoToOne"));
                verifyTrue(response.has("totalAllowancesDeducted"));
                verifyTrue(response.has("carriedOver"));
                verifyTrue(response.has("excessEmissions"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("stateCode"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

    }
    @Test(dataProvider = "csv")
    public void test2(Map<String, String> map) {

        String url2 = "/account-mgmt/allowance-compliance/stream?api_key=" + apikey +"&programCodeInfo=ARP";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

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
                verifyTrue(response.has("totalAllowancesHeld"));
                verifyTrue(response.has("complianceYearEmissions"));
                verifyTrue(response.has("otherDeductions"));
                verifyTrue(response.has("totalAllowancesDeducted"));
                verifyTrue(response.has("carriedOver"));
                verifyTrue(response.has("excessEmissions"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("stateCode"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    @Test(dataProvider = "csv")
    public void test3(Map<String, String> map) {

        String url3 = "/account-mgmt/allowance-compliance/stream?api_key=" + apikey +"&programCodeInfo=OTC";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url3);
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
                verifyTrue(response.has("totalAllowancesHeld"));
                verifyTrue(response.has("complianceYearEmissions"));
                verifyTrue(response.has("otherDeductions"));
                verifyTrue(response.has("totalAllowancesDeducted"));
                verifyTrue(response.has("carriedOver"));
                verifyTrue(response.has("excessEmissions"));
                verifyTrue(response.has("ownerOperator"));
                verifyTrue(response.has("stateCode"));

            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    @Test(dataProvider = "csv")
    public void test4(Map<String, String> map) {

        String url4 = "/account-mgmt/allowance-compliance?api_key=" + apikey +"&programCodeInfo=NBP&page=1&perPage=1";


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
                verifyTrue(response.has("totalAllowancesHeld"));
                verifyTrue(response.has("complianceYearEmissions"));
                verifyTrue(response.has("otherDeductions"));
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







