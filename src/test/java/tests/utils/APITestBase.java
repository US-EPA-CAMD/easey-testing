package tests.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;

public class APITestBase {

    private RequestSpecification httpRequest;
    protected String osHome;

    @BeforeSuite
    public void beforeSuite() {
        osHome = System.getProperty("user.home");
        if (osHome.contains("runner"))
            osHome += "/work/Testing/Testing";
    }

    protected void setup(String URI) {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = URI;

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        httpRequest = RestAssured.given();

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json");

    }

    protected String getString(String URI) {

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.get(URI);

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        return response.getBody().asString();
    }

    protected JSONObject getJSON(String URI) {

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.get(URI);

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        return new JSONObject(response.getBody().asString());
    }

    protected JSONArray getJSONArray(String URI) {

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.get(URI);

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        return new JSONArray(response.getBody().asString());
    }

    protected String postString(String body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body);

        // Post the request and check the response
        Response response = httpRequest.post(URI);

        return response.getBody().asString();
    }

    protected String postString(JSONObject body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body.toString());

        // Post the request and check the response
        Response response = httpRequest.post(URI);

        return response.getBody().asString();
    }

    protected JSONObject postJSON(String body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body);

        // Post the request and check the response
        Response response = httpRequest.post(URI);

        return new JSONObject(response.getBody().asString());
    }

    protected JSONObject postJSON(JSONObject body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body.toString());

        // Post the request and check the response
        Response response = httpRequest.post(URI);

        return new JSONObject(response.getBody().asString());
    }

    protected String putString(String body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body);

        Response response = httpRequest.put(URI);

        return response.getBody().asString();
    }

    protected String putString(JSONObject body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body.toString());

        Response response = httpRequest.put(URI);

        return response.getBody().asString();
    }

    protected JSONObject putJSON(String body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body);

        Response response = httpRequest.put(URI);

        return new JSONObject(response.getBody().asString());
    }

    protected JSONObject putJSON(JSONObject body, String URI) {
        // Add the Json to the body of the request
        httpRequest.body(body.toString());

        Response response = httpRequest.put(URI);

        return new JSONObject(response.getBody().asString());
    }

    protected String deleteString(String URI) {

        Response response = httpRequest.delete(URI);

        return response.getBody().asString();
    }

    protected JSONObject deleteJSON(String URI) {

        Response response = httpRequest.delete(URI);

        return new JSONObject(response.getBody().asString());
    }

}
