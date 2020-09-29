package tests.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestBase {

    private RequestSpecification httpRequest;

    protected void setup(String URI) {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = URI;

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        httpRequest = RestAssured.given();
    }

    protected Response get(String s) {
        return httpRequest.request(Method.GET, s);
    }

}
