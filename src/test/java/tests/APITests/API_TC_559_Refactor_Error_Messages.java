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

public class API_TC_559_Refactor_Error_Messages extends APITestBase {

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
    public void test (Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/emissions-mgmt/emissions/apportioned/mats/hourly?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        System.out.println("yes");

    }

    @Test(dataProvider = "csv")
    public void test2 (Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/emissions-mgmt/emissions/apportioned/mats/daily?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";
        String expectedResult8 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult8), "Error message contains error: " + expectedResult8 + "\n" + printResponseBody(response));
        System.out.println("yes");

    }

    @Test(dataProvider = "csv")
    public void test3(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");

        String url = "/emissions-mgmt/emissions/apportioned/mats/monthly?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";
        String expectedResult8 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult8), "Error message contains error: " + expectedResult8 + "\n" + printResponseBody(response));

    }

    @Test(dataProvider = "csv")
    public void test4(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/emissions-mgmt/emissions/apportioned/mats/quarterly?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";
        String expectedResult8 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult8), "Error message contains error: " + expectedResult8 + "\n" + printResponseBody(response));

    }

    @Test(dataProvider = "csv")
    public void test5(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");

        String url = "/emissions-mgmt/emissions/apportioned/mats/annual?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";
        String expectedResult8 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult8), "Error message contains error: " + expectedResult8 + "\n" + printResponseBody(response));

    }

    @Test(dataProvider = "csv")
    public void test6(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");

        String url = "/emissions-mgmt/emissions/apportioned/mats/ozone?api_key="+apikey+"&facilityId=invalid&unitType=invalid&unitFuelType=invalid&controlTechnologies=invalid&stateCode=texas&beginDate=2019-01-01&endDate=2019-01-01";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "page should not be null, undefined, or empty";
        String expectedResult7 =  "perPage should not be null, undefined, or empty";
        String expectedResult8 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult8), "Error message contains error: " + expectedResult8 + "\n" + printResponseBody(response));

    }

    @Test(dataProvider = "csv")
    public void test7(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/account-mgmt/emissions/allowance-holdings?api_key="+apikey+"&page=1&perPage=1&accountType=&accountNumber=0&facilityId=0&stateCode=&vintageYear=0&ownerOperator=0&programCodeInfo=";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more accountTypes are not valid. Refer to the list of available accountTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/account-types";
        String expectedResult4 = "One or more accountNumbers are not valid. Refer to the list of available accountNumbers for valid values https://api.epa.gov/easey/dev/account-mgmt/accounts";
        String expectedResult5 =  "Update one or more vintageYears to a year greater than or equal to 1995";
        String expectedResult6 =  "One or more vintageYears are not in the YYYY. Ensure all vintageYears are in the YYYY";
        String expectedResult7 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));

    }

    @Test(dataProvider = "csv")
    public void test8(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/account-mgmt/allowance-transactions?api_key="+apikey+"&page=1&perPage=1&accountType=&accountNumber=0&facilityId=0&stateCode=&programCodeInfo=&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-01&transactionType=";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more accountTypes are not valid. Refer to the list of available accountTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/account-types";
        String expectedResult4 = "One or more accountNumbers are not valid. Refer to the list of available accountNumbers for valid values https://api.epa.gov/easey/dev/account-mgmt/accounts";;
        String expectedResult5 =  "One or more transactionTypes are not valid. Refer to the list of available transactionTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/transaction-types";
        String expectedResult6 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?allowanceUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6+"\n" + printResponseBody(response));

    }
    @Test(dataProvider = "csv")
    public void test9(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");

        String url = "/account-mgmt/accounts/attributes?api_key="+apikey+"&page=1&perPage=1&accountType=&accountNumber=0&facilityId=0&stateCode=&programCodeInfo=&transactionBeginDate=2019-01-01&transactionEndDate=2019-01-01&transactionType=";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more accountTypes are not valid. Refer to the list of available accountTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/account-types";
        String expectedResult4 = "One or more accountNumbers are not valid. Refer to the list of available accountNumbers for valid values https://api.epa.gov/easey/dev/account-mgmt/accounts";;
        String expectedResult5 =  "One or more transactionTypes are not valid. Refer to the list of available transactionTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/transaction-types";
        String expectedResult6 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6+ "\n" + printResponseBody(response));

    }
    @Test(dataProvider = "csv")
    public void test10(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/account-mgmt/allowance-compliance?api_key="+apikey+"&page=1&perPage=1&stateCode=&facilityId=0&ownerOperator=0&programCodeInfo=";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?allowanceUIFilter=true\"";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));

    }
    @Test(dataProvider = "csv")
    public void test11(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/account-mgmt/emissions-compliance?api_key="+apikey+"&page=1&perPage=1&stateCode=&facilityId=0&ownerOperator=0";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));

    }
    @Test(dataProvider = "csv")
    public void test12(Map<String, String> map) {
        String apikey = System.getenv("campdAPI");
        String url = "/facilities-mgmt/facilities/attributes?api_key="+apikey+"&year=2020&facilityId=&stateCode=&unitType=&unitFuelType=&controlTechnologies=&sourceCategory=&programCodeInfo=&page=1&perPage=1";
        Response response;
        String expectedResult1 = "One or more stateCodes are not valid. Use the two letter postal abbreviation (use TX, not Texas)";
        String expectedResult2 = "One or more facilityIds are not valid. Refer to the list of available facilityIds for valid values https://api.epa.gov/easey/dev/facilities-mgmt/facilities";
        String expectedResult3 = "One or more unitTypes are not valid. Refer to the list of available unitTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/unit-types";
        String expectedResult4 = "One or more unitFuelTypes are not valid. Refer to the list of available unitFuelTypes for valid values https://api.epa.gov/easey/dev/master-data-mgmt/fuel-types";;
        String expectedResult5 =  "One or more controlTechnologies are not valid. Refer to the list of available controlTechnologies for valid values https://api.epa.gov/easey/dev/master-data-mgmt/control-technologies";
        String expectedResult6 =  "One or more programCodeInfos are not valid. Refer to the list of available programCodeInfos for valid values https://api.epa.gov/easey/dev/master-data-mgmt/programs?emissionsUIFilter=true";
        String expectedResult7 =  "One or more sourceCategoriess are not valid. Refer to the list of available sourceCategoriess for valid values https://api.epa.gov/easey/dev/master-data-mgmt/source-categories";

        //      Step 1: Perform a Request on streaming Endpoint with no criteria
        response = getResponse(url);
        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult5), "Error message contains error: " + expectedResult5 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message contains error: " + expectedResult6 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult7), "Error message contains error: " + expectedResult7 + "\n" + printResponseBody(response));
        System.out.println("yes");
    }



}







