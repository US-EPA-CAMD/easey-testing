package tests.temp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class SampleAPITestCase extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("http://ergast.com/api/f1/2017");
    }

    @Test
    public void GetWeatherDetails()
    {
        JSONObject response = getJSON("/circuits.json");

//        System.out.println("Response Body is: ");

//        System.out.println(response.toString(4));

//        System.out.println("\n===================================\n");

        JSONArray circuits = response.getJSONObject("MRData").getJSONObject("CircuitTable").getJSONArray("Circuits");

        JSONObject monaco = null;

        for(Object obj : circuits) {
            if (obj instanceof JSONObject) {
                JSONObject circuit = (JSONObject) obj;
                if (circuit.getString("circuitId").equals("monaco")) {
                    monaco = circuit;
                }
            }
        }

        System.out.println(monaco != null ? monaco.toString(4) : "{}");

        getLine();

        verifyTrue(monaco != null, "response is null");

    }

}
