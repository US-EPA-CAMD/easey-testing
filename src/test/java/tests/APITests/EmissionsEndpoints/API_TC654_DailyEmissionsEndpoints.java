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

public class API_TC654_DailyEmissionsEndpoints extends APITestBase {

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
    public void dailyEmissionsFacility(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/daily/by-facility?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("date"));
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
    public void dailyFacilityStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/daily/by-facility/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void dailyEmissionsState(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/daily/by-state?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("date"));
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
    public void dailyStateStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/daily/by-state/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void dailyEmissionsNationally(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/daily/nationally?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("date"));
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
    public void dailyNationallyStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/daily/nationally/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }

    }








