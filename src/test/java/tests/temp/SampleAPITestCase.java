package tests.temp;

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
        String response = getString("/circuits.json");

        System.out.println("Response Body is =>  " + response);

        Assert.assertTrue(response.contains("\"circuitId\":\"monaco\""));

    }

}
