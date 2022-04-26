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
import java.util.Timer;

public class TC_522_MDM_Labels extends APITestBase {
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

        String [] Urls  = {"/master-data-mgmt/control-technologies?api_key="+ apikey};


        Response response;
//     Step 1: Perform a GET request to Allowance Holdings

        for (String url : Urls) {
            String resp = getString(url);
            System.out.println(resp);

        }


    }


}
