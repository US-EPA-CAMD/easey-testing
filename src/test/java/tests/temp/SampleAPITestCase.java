package tests.temp;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class SampleAPITestCase extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {

        super.setup("http://ergast.com/api/f1/2017");
    }

    @Test
    public void GetWeatherDetails()
    {

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = get("/circuits.json");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);

        Assert.assertTrue(responseBody.contains("\"circuitId\":\"monaco\""));

    }

}
