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

public class API_TC_521_MDD_Acc_Compliance extends APITestBase {

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
        String url = "/account-mgmt/allowance-holdings?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&page=1&perPage=1";
        Response response;
//      Step 1: Perform a GET request with API key
        String url1 = String.format(url);
        response = getResponse(url1);
        System.out.print(response.getBody());
        JSONArray res = getJSONArray(url1);
        System.out.println(res);
    }

    }

