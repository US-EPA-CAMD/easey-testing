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

public class TC_654_HourEmissions_State_Agg extends APITestBase {

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
    public void test1(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");

    //      Step 1: Perform a Request on streaming Endpoint with no criteria
        String url = "/emissions-mgmt/apportioned/hourly/state/?api_key=" + apikey + "&stateCode=TX&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res = getJSONArray(url);

        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test2(Map<String, String> map) {

        String url2 = "/emissions-mgmt/apportioned/hourly/state/?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&facilityId=000612&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test3(Map<String, String> map) {

    //      Step 1: Perform a Request on streaming Endpoint with no criteria
        String url3 = "/emissions-mgmt/apportioned/hourly/state/?api_key="+ apikey +"&stateCode=AL&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res3 = getJSONArray(url3);

        for (Object r : res3) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test4(Map<String, String> map) {


//      Step 1: Perform a Request on streaming Endpoint with no criteria

        String url4 = "/emissions-mgmt/apportioned/hourly/state/?api_key="+ apikey +"&unitType=Stoker&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res4 = getJSONArray(url4);

        for (Object r : res4) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));


            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test5(Map<String, String> map) {

    //      Step 1: Perform a Request on streaming Endpoint with no criteria
        String url5  = "/emissions-mgmt/apportioned/hourly/state/?api_key="+ apikey +"&unitFuelType=coal&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res5 = getJSONArray(url5);

        for (Object r : res5) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));


            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test6(Map<String, String> map) {

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        String url6 = "/emissions-mgmt/apportioned/hourly/state/?api_key="+ apikey +"&controlTechnologies=Other&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res6 = getJSONArray(url6);

        for (Object r : res6) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));


            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }

    @Test(dataProvider = "csv")
    public void test7(Map<String, String> map) {

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        String url7 = "/emissions-mgmt/apportioned/hourly/state/?api_key=" + apikey + "&programCodeInfo=ARP&beginDate=2020-01-01&endDate=2020-01-01&page=1&perPage=100";
        JSONArray res7 = getJSONArray(url7);

        for (Object r : res7) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));


            }
            else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }


    // Test errors


    @Test(dataProvider = "csv")
    public void test8(Map<String, String> map) {


        String url8 = "/emissions-mgmt/apportioned/hourly/state/?api_key="+ apikey +"&stateCode=Texas&facilityId=h&unitType=j&unitFuelType=k&controlTechnologies=l&programCodeInfo=m&beginDate=01/01/0128&endDate=2023-01-01";
        Response response;
        response = getResponse(url8);
        verifyTrue((response.getStatusCode() == 400));


    }


    @Test(dataProvider = "csv")
    public void test9(Map<String, String> map) {


        String url9 = "/emissions-mgmt/apportioned/hourly/state/stream/?api_key=" + apikey + "&stateCode=invalid&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&programCodeInfo=invalid&beginDate=01/01/2020&endDate=01/01/2020";
        Response response;
        response = getResponse(url9);
        verifyTrue((response.getStatusCode() == 400));


    }



}







