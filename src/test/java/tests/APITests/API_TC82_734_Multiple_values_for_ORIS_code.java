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

public class API_TC82_734_Multiple_values_for_ORIS_code extends APITestBase {

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
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&orisCode=%s|%s";
        String oris1 = "127";
        String oris2 = "612";
//        Perform a GET request for ORIS = 127 and 612
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&orisCode=127|612
        JSONArray response = getJSONArray(String.format(url, "1", map.get("perPage"), map.get("beginDate"), map.get("endDate"), oris1, oris2));
//        API returns results for both ORIS 127 and 612
        for (Object r : response) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                String oris = res.getString("orisCode");
                verifyTrue(oris.equals(oris1) || oris.equals(oris2),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }

//        Perform a GET request to test allowing white space
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31&orisCode=127%20|%20612
        Response rRes = getResponse(String.format(url, "1", map.get("perPage"), map.get("beginDate"), map.get("endDate"), oris1 + " ", oris2 + " "));
//        API returns results for both ORIS 127 and 612
        if (rRes.getStatusCode() == 200) {
            response = new JSONArray(rRes.getBody().asString());
            for (Object r : response) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    String oris = res.getString("orisCode");
                    verifyTrue(oris.equals(oris1) || oris.equals(oris2),
                            "Response was not from the correct ORIS Code\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else {
            verifyFail("Invalid Response Code: " + rRes.getStatusCode());
        }
    }
}
