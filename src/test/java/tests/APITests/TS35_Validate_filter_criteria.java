package tests.APITests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
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

public class TS35_Validate_filter_criteria extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "APITestData/TS35_Validate_filter_criteria.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

//    @Test(dataProvider = "csv")
    public void TC68_302_Validate_state(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&state=%s";
        Response response;
//        Step 1: Perform a GET request for PA
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            state=PA
//        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), map.get("state"));
        String url1 = formatURL(map, url, "state");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    verifyEquals(res.getString("state"), map.get("state"),
                            "Response was not from the correct state\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else
            verifyFail("did not get 200 response");

//        Step 2: Perform a GET request for an invalid state abbreviation (such as ZZ or 123)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            state=ZZ123
//        String url2 = String.format(url, map.get("page"), map.get("perPage"), "2019-01-01", "2019-01-31", map.get("stateBad"));
        String url2 = formatURL(map, url, "stateBad");
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String expectedResponse = "The state or territory is not valid. Please enter a valid state or territory using the two letter postal abbreviation (use TX, not Texas).";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        verifyEquals(resJsonObject.getString("message"), expectedResponse,"Error response incorrect");
    }

//     Failing due to invalid error messages
//    @Test(dataProvider = "csv")
    public void TC69_570_Validate_date_range(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s";
        Response response;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Step 1: Perform a GET request for a valid date range (01/01/2019 - 01/31/2019) in the format YYYY-MM-DD
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-01-01&endDate=2019-01-31
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"));
        response = getResponse(url1);
//        Expected Result 1: API returns results for 1/1/2019 - 1/31/2019
//        System.out.println(response.getStatusLine());
//        System.out.println(printResponseBody(response));
        try {
            Date beginDate = format.parse(map.get("beginDate"));
            Date endDate = format.parse(map.get("endDate"));
            for (Object r : new JSONArray(response.getBody().asString())) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    try {
                        Date date = format.parse(res.getString("opDate"));
                        verifyTrue(date.after(beginDate) && date.before(endDate),
                                String.format("Date not within date range of: %s - %s\n%s", beginDate, endDate, res.toString(4)));
                    } catch (ParseException e) {
                        verifyFail(res.getString("opDate") + " failed to parse, invalid date format\n" + res.toString(4));
                    }
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } catch (ParseException e) {
            Assert.fail("TC69_570: beginDate/endDate failed to parse, please check test data for valid yyy-MM-dd format or fix test to new format");
        }


//        Step 2: Perform a GET request for an invalid start and end date format (such as 13/45/0 or ABC)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019
        String url2 = String.format(url, map.get("page"), map.get("perPage"), "01-01-2019", "01-31-2019");
        response = getResponse(url2);

//        Status code 400
//        API returns a validation error collection containing the message
        String expectedResult2 = "Please enter the date in the YYYY-MM-DD format";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message does not contain error: " + expectedResult2 + "\n" + printResponseBody(response));


//        Step 3: Perform a GET request for the date range 01/01/1995 to 01/02/1995
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=1995-01-01&endDate=1995-01-02
        String url3 = String.format(url, map.get("page"), map.get("perPage"), "1995-01-01", "1995-01-02");
        response = getResponse(url3);
//        200 code
//        API returns results for 1/1 to 1/2/1995
//        (No results found but NOT a validation error message)
        verifyEquals(response.getStatusCode(), 200, "Status code not correct");
//        System.out.println(printResponseBody(response));

//        Step 4: Perform a GET request for the start date 12/31/1994 and the end date 12/31/1994
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=1994-12-31&endDate=1994-12-31
        String url4 = String.format(url, map.get("page"), map.get("perPage"), "1994-12-31", "1994-12-31");
        response = getResponse(url4);
//        400 code
//        API returns a validation error collection containing the message
        String expectedResult3a = "Please enter a beginDate year between 1995 and this year";
        String expectedResult3b = "Please enter a endDate year between 1995 and this year";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult3a), "Error message does not contain error: " + expectedResult3a + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3b), "Error message does not contain error: " + expectedResult3b + "\n" + printResponseBody(response));


//        Step 5: Perform a GET request for the start date 12/31/2022 and the end date 12/31/2022
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2022-12-31&endDate=2022-12-31
        String url5 = String.format(url, map.get("page"), map.get("perPage"), "2022-12-31", "2022-12-31");
        response = getResponse(url5);
//        400 code
//        API returns a validation error collection containing the message
//        "Please enter a beginDate year between 1995 and this year"
//        "Please enter a endDate year between 1995 and this year"
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult3a), "Error message does not contain error: " + expectedResult3a + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3b), "Error message does not contain error: " + expectedResult3b + "\n" + printResponseBody(response));


//        Step 6: Perform a GET request for the date range 02/01/2019 to 01/01/2019
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=2019-02-01&endDate=2019-01-01
        String url6 = String.format(url, map.get("page"), map.get("perPage"), "2019-02-01", "2019-01-01");
        response = getResponse(url6);
//        400 code
//        API returns a validation error collection containing the message
        String expectedResult6 = "Please enter an endDate that is greater than or equal to the beginDate";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message does not contain error: " + expectedResult6 + "\n" + printResponseBody(response));


//        Testing #621
//        Step 7: Perform a GET request without entering beginDate or endDate
        String url7 = String.format("/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s", map.get("page"), map.get("perPage"));
        response = getResponse(url7);
//        400 code
//        API returns a validation error collection containing error messages for beginDate AND endDate.
//
//                No other date validation error messages (for the null value) are displayed if EITHER beginDate OR endDate is null.
//                  Validation error messages for other filter criteria will still display.
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult2), "Error message does not contain error: " + expectedResult2 + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3a), "Error message does not contain error: " + expectedResult3a + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult3b), "Error message does not contain error: " + expectedResult3b + "\n" + printResponseBody(response));
        verifyTrue(response.getBody().asString().contains(expectedResult6), "Error message does not contain error: " + expectedResult6 + "\n" + printResponseBody(response));

    }

//    @Test(dataProvider = "csv")
    public void TC70_571_Validate_ORIS_code(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&orisCode=%s";
        JSONArray resJSONArray;
        System.out.println(map.get("facilityName"));
//        Perform a GET request for ORIS Code = 612
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=612
        String url1 = formatURL(map, url, "orisCode");
        resJSONArray = getJSONArray(url1);
//        API returns results for Fort Myers
        System.out.println(resJSONArray.toString(4));
        for (Object r : resJSONArray) {
            if (r instanceof JSONObject) {
                JSONObject res = (JSONObject) r;
                verifyEquals(res.getString("facilityName"), map.get("facilityName"),
                        "Response was not from the correct ORIS Code\n" + res.toString(4));
            } else
                verifyFail("Response returned non JSONObject\n" + r.toString());
        }
//        Perform a GET request for an invalid ORIS Code (such as -58 or 12345678 or ABC)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=ABC
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "ABC");
        Response response = getResponse(url2);
//        Status code 400
//
//        API returns a validation error collection containing the message
        String expectedResult = "ORIS code not valid. Refer to the list of available ORIS for valid values [placeholder for link to Facilities endpoint]";

        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        verifyTrue(response.getBody().asString().contains(expectedResult), "Error message does not contain error: " + expectedResult + "\n" + printResponseBody(response));

//        Testing #618
//        Perform a GET request with leading zeros for a valid ORIS code = 000612
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?page=1&perPage=3000&beginDate=01-01-2019&endDate=01-31-2019&orisCode=000612

        String url3 = formatURL(map, url, "orisCodeZeros");
        System.out.println(url3);
        String responseString = getString(url3);
//        API returns results for Fort Myers
        try {
            resJSONArray = new JSONArray(responseString);
            System.out.println(resJSONArray.toString(4));
            for (Object r : resJSONArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
                    verifyEquals(res.getString("facilityName"), map.get("facilityName"),
                            "Response was not from the correct ORIS Code\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } catch (JSONException e) {
            verifyFail("Response in the wrong format:\n" + responseString);
        }
    }

//    @Test(dataProvider = "csv")
    public void TC71_572_Validate_control_technologies(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&controlTechnologies=%s";
        Response response;
//        Step 1: Perform a GET request for Combined cycle
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            controlTechnologies=Wet%20Limestone
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Wet Limestone");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
//                    System.out.println(res.toString(4));
                    verifyEquals(res.getString("so2ControlInfo"), "Wet Limestone",
                            "Response was not from the correct control technology\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else
            verifyFail("did not get 200 response");

//        Step 2: Perform a GET request for an invalid unit type (such as ABC123 or anything not included in the list of acceptable values)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            controlTechnologies=Invalid123
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Invalid123");
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String expectedResponse = "Control technologies are not valid. Refer to the list of available control technologies for valid values [placeholder for link to endpoint]";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        verifyTrue(resJsonObject.getJSONArray("message").toString().contains(expectedResponse),
                "Error response does not contain: \n" + expectedResponse +
                        "\n" + resJsonObject.toString(4));
    }

//    @Test(dataProvider = "csv")
    public void TC72_594_Validate_unit_type(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&unitType=%s";
        Response response;
//        Step 1: Perform a GET request for Combined cycle
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitType=Combined%20cycle
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Combined cycle");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
//                    System.out.println(res.toString(4));
                    verifyEquals(res.getString("unitTypeInfo"), "Combined cycle",
                            "Response was not from the correct unit type\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else
            verifyFail("did not get 200 response");

//        Step 2: Perform a GET request for an invalid unit type (such as ABC123 or anything not included in the list of acceptable values)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitType=Invalid123
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Invalid123");
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String expectedResponse = "Unit type is not valid. Refer to the list of available unit types for valid values [placeholder for link to endpoint]";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        verifyEquals(resJsonObject.getString("message"), expectedResponse, "Error response incorrect");
    }

//    @Test(dataProvider = "csv")
    public void TC73_595_Validate_unit_fuel_type(Map<String, String> map) {
        System.out.println(num);
        String url = "/api/emissions-mgmt/apportioned/hourly/?page=%s&perPage=%s&beginDate=%s&endDate=%s&unitFuelType=%s";
        Response response;
//        Step 1: Perform a GET request for Combined cycle
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitFuelType=Wood
        String url1 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Wood");

        response = getResponse(url1);

//         Expected Result 1: API returns results for PA
        if (response.getStatusCode() == 200) {
            JSONArray resJsonArray = new JSONArray(response.getBody().asString());
            for (Object r : resJsonArray) {
                if (r instanceof JSONObject) {
                    JSONObject res = (JSONObject) r;
//                    System.out.println(res.toString(4));
                    verifyEquals(res.getString("primaryFuelInfo"), "Wood",
                            "Response was not from the correct unit fuel type\n" + res.toString(4));
                } else
                    verifyFail("Response returned non JSONObject\n" + r.toString());
            }
        } else
            verifyFail("did not get 200 response");

//        Step 2: Perform a GET request for an invalid unit type (such as ABC123 or anything not included in the list of acceptable values)
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?
//            page=1&
//            perPage=3000&
//            beginDate=01-01-2019&
//            endDate=01-31-2019&
//            unitFuelType=Invalid123
        String url2 = String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), "Invalid123");
        System.out.println(url2);
        response = getResponse(url2);

//         Expected Result 2: Status code 400
//          API returns a validation error collection containing the message
        String expectedResponse = "Unit fuel type is not valid. Refer to the list of available unit fuel types for valid values [placeholder for link to endpoint]";
        verifyEquals(response.getStatusCode(), 400, "Status code not correct");
        JSONObject resJsonObject = new JSONObject(printResponseBody(response));
        verifyTrue(resJsonObject.getJSONArray("message").toString().contains(expectedResponse),
                "Error response does not contain: \n" + expectedResponse +
                        "\n" + resJsonObject.toString(4));
    }

//    @Test(dataProvider = "csv")
    public void TC76_586_Cumulative_validation(Map<String, String> map) {
    }

    private String formatURL(Map<String, String> map, String url, String var) {
        return String.format(url, map.get("page"), map.get("perPage"), map.get("beginDate"), map.get("endDate"), map.get(var));
    }
}