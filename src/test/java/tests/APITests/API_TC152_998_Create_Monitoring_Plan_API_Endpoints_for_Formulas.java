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

public class API_TC152_998_Create_Monitoring_Plan_API_Endpoints_for_Formulas extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
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
    public void test(Map<String, String> map)  {

        String url = "api/monitor-plan-mgmt/monitor-locations/%s/formulas";

//        Perform a GET request for the control technologies endpoint
//        https://easey-dev.app.cloud.gov/api/monitor-plan-mgmt/monitor-locations/%s/formulas

        String url1 = formatURL(map, url, "idFormulas");

        // Checking response code
        Response response = getResponse(url1);
        verifyEquals(response.getStatusCode(), 200, "Status code not correct");

        JSONArray res = getJSONArray(url1);
        // "api/monitor-plan-mgmt/monitor-locations/%s/formulas"
        // Validating Response body fields
        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject resp = (JSONObject) r;
                verifyTrue(resp.has("id"));
                verifyTrue(resp.has("parameter"));
                verifyTrue(resp.has("formulaID"));
                verifyTrue(resp.has("formula"));
                verifyTrue(resp.has("formulaEquation"));
                verifyTrue(resp.has("beginDate"));
                verifyTrue(resp.has("endDate"));
                verifyTrue(resp.has("beginHour"));
                verifyTrue(resp.has("endHour"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
    }
    private String formatURL(Map<String, String> map, String url, String var) {
        return String.format(url, map.get(var));

    }
}