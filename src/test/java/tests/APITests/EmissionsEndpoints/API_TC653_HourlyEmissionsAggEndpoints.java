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

public class API_TC653_HourlyEmissionsAggEndpoints extends APITestBase {

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
    public void hourlyEmissionsFacility(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/hourly/by-facility?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
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
        }
    }
    @Test(dataProvider = "csv")
    public void hourlyFacilityStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/hourly/by-facility/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void hourlyEmissionsState(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/hourly/by-state?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
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
        }
    }
    @Test(dataProvider = "csv")
    public void hourlyStateStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/hourly/by-state/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }
    @Test(dataProvider = "csv")
    public void hourlyEmissionsNationally(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "emissions-mgmt/emissions/apportioned/hourly/nationally?api_key="+apikey+"&beginDate=2019-01-01&endDate=2019-01-01&page=1&perPage=1";
        JSONArray res1 = getJSONArray(url);
        for (Object r : res1) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
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
    public void hourlyNationallyStream(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/streaming-services/emissions/apportioned/hourly/nationally/?api_key="+apikey+"&beginDate=2020-01-01&endDate=2020-01-01";;
        Response response;
        response = getResponse(url);
        verifyTrue(response.getStatusCode()==200);


    }



}








