package tests.APITests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.utils.APITestBase;
import tests.utils.CSVParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class API_TC428_2167_Create_Allowance_Transactions_Endpoint_for_filter_logic extends APITestBase {
    String apikey = System.getenv("campdAPI");

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://api.epa.gov/easey/dev");
    }

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "APITestData/TC428_2167_Tests.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

    @Test(dataProvider = "csv")
    public void test(Map<String, String> map) {

        String url = "/account-mgmt/allowance-transactions/attributes/applicable/?api_key=" + apikey + "&transactionBeginDate=2020-09-30&transactionEndDate=2021-09-30";
        Response response;

//      Step 1: Perform a GET request without entering beginDate or endDate
        String url1 = String.format(url);
        response = getResponse(url1);
        String expectedResult1= "transactionBeginDate should not be null or undefined";
        String expectedResult2= "transactionEndDate should not be null or undefined";
        JSONArray res = getJSONArray(url1);
        System.out.println(res);
//        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult1 + "\n" + printResponseBody(response));
//        verifyTrue(response.getBody().asString().contains(expectedResult1), "Error message contains error: " + expectedResult2 + "\n" + printResponseBody(response));
        System.out.println(response.getStatusLine());

// //     New URL
//        String urlnew = "/api/account-mgmt/allowance-transactions/attributes/applicable?transactionBeginDate=%s&transactionEndDate=%s";
//
////      Step 2: Make a GET request with transactions end date and begin date in the improper format (ex. 2019)
//        String url2 = String.format(urlnew,"2020","2019");
//        response = getResponse(url2);
//        String expectedResult3= "Ensure that transactionBeginDate is in the YYYY-MM-DD format";
//        verifyEquals(response.getStatusCode(), 400);
//        verifyTrue(response.getBody().asString().contains(expectedResult3), "Error message contains error: " + expectedResult3 + "\n" + printResponseBody(response));
//        System.out.println(response.getStatusLine());
//
// //       Step 3: Make a get request with an out of range date for transaction begin date and end date ex( 1970-01-01))
//        String url3 = String.format(urlnew,"1970-01-01","1970-01-02");
//        response = getResponse(url3);
//        String expectedResult4= "Update the transactionBeginDate to a date between 03/23/1993 and the current date";
//        verifyEquals(response.getStatusCode(), 400);
//        verifyTrue(response.getBody().asString().contains(expectedResult4), "Error message contains error: " + expectedResult4 + "\n" + printResponseBody(response));
//        System.out.println(response.getStatusLine());
////       Step 4: Make a GET request with an invalid date for transactions begin date and end date
//        String url4 = String.format(urlnew,"13-45-0","13-45-1");
//        response = getResponse(url4);
//        verifyEquals(response.getStatusCode(), 400);
//        System.out.println(response.getBody());
//
////       Step 5: ****Make a GET request with valid filter for transactions begin date and end
//        String url5 = String.format(urlnew,"2012-01-01","2012-01-02");
//        response = getResponse(url5);
//        System.out.println(response.getStatusLine());



    }
}
