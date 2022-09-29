package tests.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class TestBase {
    protected String className = this.getClass().getSimpleName();
    private SoftAssert softAssert;
    protected final String osHome = System.getProperty("user.home");
    protected final String filePathBase = osHome + (osHome.contains("runner") ?
            //           "/work/easey-testing/easey-testing" : "/EPACAMD/Testing") +
            "/work/easey-testing/easey-testing" : "\\IdeaProjects\\easey-testing") +
            "/src/main/resources/";
    protected double num;

    protected String env = System.getProperty("env", "dev");

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
        num = Math.random();
    }
    
    @AfterMethod
    public void afterMethod() {
        endTest();
    }

    protected int getLine() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
//        System.out.println(className);
        String line = Arrays.asList(stack).toString();
        line = line.substring(line.indexOf(className));
//        System.out.println(line);
        line = line.substring(line.indexOf(":") + 1, line.indexOf(")"));
        try {
            return Integer.parseInt(line);
        } catch (Exception e) {
            System.err.println("Method failed, please debug");
            return 0;
        }
    }

    public void assertTrue(boolean assertion, String message) {
        Assert.assertTrue(assertion, String.format("%s:%d - %s", className, getLine(), message));
    }
    
    public void assertTrue(boolean assertion) {
        assertTrue(assertion, "failed");
    }

    public void assertFalse(boolean assertion, String message) {
        Assert.assertFalse(assertion, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void assertFalse(boolean assertion) {
        assertFalse(assertion, "failed");

    }

    public void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void assertEquals(Object actual, Object expected) {
        assertEquals(actual, expected, "failed");

    }

    public void assertNotEquals(Object actual, Object expected, String message) {
        Assert.assertNotEquals(actual, expected, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void assertNotEquals(Object actual, Object expected) {
        assertNotEquals(actual, expected, "failed");

    }

    public void fail( String message) {
        Assert.fail(String.format("%s:%d - %s", className, getLine(), message));
    }
    
    public void verifyTrue( boolean assertion, String message) {
        softAssert.assertTrue(assertion, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void verifyTrue( boolean assertion) {
        verifyTrue(assertion, "failed");
    }

    public void verifyFalse( boolean assertion, String message) {
        softAssert.assertFalse(assertion, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void verifyFalse( boolean assertion) {
        verifyFalse(assertion, "failed");
    }

    public void verifyNotDisplayed(WebElement ele) {
        try {
            softAssert.assertFalse(ele.isDisplayed(), String.format("%s:%d - %s", className, getLine(), "Element is displayed"));
        } catch (NoSuchElementException e) {
            // an element not found is an element not displayed
        }
    }

    public void verifyEquals( Object actual, Object expected, String message) {
        if (actual instanceof WebElement && expected instanceof String) {
            actual = ((WebElement) actual).getText();
        }
        softAssert.assertEquals(actual, expected, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void verifyEquals( Object actual, Object expected) {
        verifyEquals(actual, expected, "failed");
    }

    public void verifyNotEquals( Object actual, Object expected, String message) {
        if (actual instanceof WebElement && expected instanceof String) {
            actual = ((WebElement) actual).getText();
        }
        softAssert.assertNotEquals(actual, expected, String.format("%s:%d - %s", className, getLine(), message));
    }

    public void verifyNotEquals( Object actual, Object expected) {
        if (actual instanceof WebElement && expected instanceof String) {
            actual = ((WebElement) actual).getText();
        }
        verifyNotEquals(actual, expected, "failed");
    }

    public void verifyFail (String message) {
        softAssert.fail(String.format("%s:%d - %s", className, getLine(), message));
    }

    public void endTest() {
        System.out.printf("[TEST] All Steps were executed for: %s\n", className);
        softAssert.assertAll();
    }

//    public static void main(String[] args) {
//        RestAssured.baseURI = "https://api.testquality.com/api";
//        RequestSpecification httpRequest = RestAssured.given();
//        httpRequest.header("Content-Type", "application/json");
//        httpRequest.header("Accept", "application/vnd.testquality.v1+json");
//        JSONObject body = new JSONObject();
//        body.put("client_id", "8");
//        body.put("client_secret", "bfnafK7hfFOTVk0Q8oaZQz9mCvR0w1id9ESjRnub");
//        body.put("grant_type", "password");
//        body.put("username", "yefimabramson@cvpcorp.com");
//        body.put("password", "*************");
//        httpRequest.body(body.toString());
//        JSONObject authResponse = new JSONObject(httpRequest.post("/oauth/access_token").getBody().asString());
//        System.out.println(authResponse.toString(4));
//
//        httpRequest = RestAssured.given();
//        httpRequest.header("Content-Type", "application/json");
//        httpRequest.header("Accept", "application/vnd.testquality.v1+json");
//        httpRequest.header("Authorization", authResponse.getString("token_type")
//                + " " + authResponse.getString("access_token"));
//
//        JSONObject idResponse = new JSONObject(
//                httpRequest.get("/plan?name=My_Test_Plan").getBody().asString());
//        System.out.println(idResponse.toString(4));
//        int id = idResponse.getJSONArray("data").getJSONObject(0).getInt("id");
//
//        httpRequest = RestAssured.given().log().all();
//
//        httpRequest.multiPart("file", new File(System.getProperty("user.dir") + "/target/surefire-reports/junitreports/TEST-tests.temp.SampleStarterUITestCase3.xml"));
//        httpRequest.header("Authorization", authResponse.getString("token_type")
//                + " " + authResponse.getString("access_token"));
//        httpRequest.header("Accept", "application/vnd.testquality.v1+json");
//        String fileResponse = httpRequest.when().post("/plan/" + id + "/junit_xml").asString();
//        System.out.println("/plan/" + id + "/junit_xml");
//        System.out.println(fileResponse);
//    }

}
