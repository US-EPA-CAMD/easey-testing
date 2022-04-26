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

public class API_TC_599_MATS_Data_Filter extends APITestBase {
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
    public void test2(Map<String, String> map) {

        String url2 = "/emissions-mgmt/apportioned/mats/hourly/stream?api_key=" + apikey + "&beginDate=2020-01-01&endDate=2020-01-01";

//      Step 1: Perform a Request on streaming Endpoint with no criteria

        JSONArray res2 = getJSONArray(url2);

        for (Object r : res2) {
            if (r instanceof JSONObject) {
                JSONObject response = (JSONObject) r;
                verifyTrue(response.has("stateCode"));
                verifyTrue(response.has("facilityName"));
                verifyTrue(response.has("facilityId"));
                verifyTrue(response.has("unitId"));
                verifyTrue(response.has("date"));
                verifyTrue(response.has("hour"));
                verifyTrue(response.has("opTime"));
                verifyTrue(response.has("matsGrossLoad"));
                verifyTrue(response.has("matsHeatInput"));
                verifyTrue(response.has("hgOutputRate"));
                verifyTrue(response.has("hgInputRate"));
                verifyTrue(response.has("hgMass"));
                verifyTrue(response.has("hgMassMeasureFlg"));
                verifyTrue(response.has("hclOutputRate"));
                verifyTrue(response.has("hclInputRate"));
                verifyTrue(response.has("hclMass"));
                verifyTrue(response.has("hclMassMeasureFlg"));
                verifyTrue(response.has("hfOutputRate"));
                verifyTrue(response.has("hfInputRate"));
                verifyTrue(response.has("hfMass"));
                verifyTrue(response.has("hfMassMeasureFlg"));
                verifyTrue(response.has("associatedStacks"));
                verifyTrue(response.has("steamLoad"));
                verifyTrue(response.has("primaryFuelInfo"));
                verifyTrue(response.has("secondaryFuelInfo"));
                verifyTrue(response.has("unitType"));
                verifyTrue(response.has("so2ControlInfo"));
                verifyTrue(response.has("noxControlInfo"));
                verifyTrue(response.has("pmControlInfo"));
                verifyTrue(response.has("hgControlInfo"));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }


    }
    @Test(dataProvider = "csv")
    public void test3(Map<String, String> map) {
        String url3 = "/emissions-mgmt/apportioned/mats/hourly/stream?api_key="+ apikey + "&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
//      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url3);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));

    }



}







