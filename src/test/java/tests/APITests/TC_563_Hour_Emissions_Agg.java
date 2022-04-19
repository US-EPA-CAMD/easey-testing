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

public class TC_563_Hour_Emissions_Agg extends APITestBase {

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

        String url = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=10";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res = getJSONArray(url);

        for (Object r : res) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url2 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&facilityId=000003|000612&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=75";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url3 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&stateCode=AL|TX&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=75";
//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res3 = getJSONArray(url3);

        for (Object r : res3) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url4 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&unitType=Tangentially-fired&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=75";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res4 = getJSONArray(url4);

        for (Object r : res4) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url5 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&unitFuelType=Coal&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=75";
//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res5 = getJSONArray(url5);

        for (Object r : res5) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url6 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&controlTechnologies=Other&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=75";
        //      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res6 = getJSONArray(url6);

        for (Object r : res6) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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

        String url7 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&programCodeInfo=ARP|CAIROS&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=50";
        //      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res7 = getJSONArray(url7);

        for (Object r : res7) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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
    public void test8(Map<String, String> map) {

        String url8 = "emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&beginDate=2019-01-01&endDate=2019-01-01&operatingHoursOnly=true&page=1&perPage=10";
        //      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res8 = getJSONArray(url8);

        for (Object r : res8) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
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
    public void test9(Map<String, String> map) {


        String url9 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&stateCode=&facilityId=0000000&unitType=&unitFuelType=&controlTechnologies=&programCodeInfo=&beginDate=1994-01-01&endDate=2023-01-01&page=&perPage=";

    Response response;
    response = getResponse(url9);
    verifyTrue((response.getStatusCode() == 400));


}

    @Test(dataProvider = "csv")
    public void test10(Map<String, String> map) {


        String url10 = "/emissions-mgmt/apportioned/hourly/facility?api_key=T8r7OW4f12XtWKLY7CPgKmKu1WoP3TVG0x4eqmlB&stateCode=&facilityId=0000000&unitType=&unitFuelType=&controlTechnologies=&programCodeInfo=&beginDate=1994-01-01&endDate=2023-01-01&page=&perPage=";
        Response response;
        response = getResponse(url10);
        verifyTrue((response.getStatusCode() == 400));


    }

}







