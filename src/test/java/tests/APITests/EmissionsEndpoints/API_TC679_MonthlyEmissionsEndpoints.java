package tests.APITests.EmissionsEndpoints;

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

public class API_TC679_MonthlyEmissionsEndpoints extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://api.epa.gov/easey/dev/");

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
    public void monthlyEmissionsFacility(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/monthly/by-facility?api_key="+apikey+"&year=2019&month=1|2|3|4&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("year"));
                verifyTrue(response.has("month"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
        }
    }
    @Test(dataProvider = "csv")
    public void monthlyFacilityStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/monthly/by-facility/?api_key="+apikey+"&year=2019&month=1|2|3|4";
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void monthlyEmissionsState(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/monthly/by-state?api_key="+apikey+"&year=2019&month=1|2|3|4&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("year"));
                verifyTrue(response.has("month"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
        }
    }
    @Test(dataProvider = "csv")
    public void monthlyStateStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/monthly/by-state/?api_key="+apikey+"&year=2019&month=1|2|3|4";;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void monthlyEmissionsNationally(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/monthly/nationally?api_key="+apikey+"&year=2019&month=1|2|3|4&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("year"));
                verifyTrue(response.has("month"));
                verifyTrue(response.has("grossLoad"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("so2Mass"));
                verifyTrue(response.has("co2Mass"));
                verifyTrue(response.has("noxMass"));
                verifyTrue(response.has("heatInput"));

            }
        }
    }
    @Test(dataProvider = "csv")
    public void monthlyNationallyStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/monthly/nationally/?api_key="+apikey+"&year=2019&month=1|2|3|4";
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }


    }








