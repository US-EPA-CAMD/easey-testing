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
import java.util.concurrent.TimeUnit;

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

        String [] Urls  = {"/account-mgmt/allowance-holdings?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&page=1&perPage=1", "/account-mgmt/allowance-holdings?api_key=PXPWlQGB3wKXotkWN1PbSwbSoM7CoWW0ZMPWYtfc&page=1&perPage=1", "account-mgmt/accounts/attributes?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&page=1&perPage=1", "/account-mgmt/emissions-compliance?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&page=1&perPage=1","/account-mgmt/allowance-compliance?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&page=1&perPage=1"};


        Response response;
//     Step 1: Perform a GET request to Allowance Holdings
        int i = 0;
        for (String url : Urls) {
            System.out.println(i);
            String url1 = String.format(url);
            System.out.println(url1);
            response = getResponse(url1);
            String res = response.getBody().asString();
            String stateC = "stateCode";
            verifyTrue(res.contains(stateC));
            System.out.println(res);
            i++;

            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }


            }



        }



    }



