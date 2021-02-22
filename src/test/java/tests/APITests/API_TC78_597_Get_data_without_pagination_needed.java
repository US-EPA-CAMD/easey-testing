package tests.APITests;

import org.json.JSONArray;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.utils.APITestBase;

public class API_TC78_597_Get_data_without_pagination_needed extends APITestBase {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        super.setup("https://easey-dev.app.cloud.gov");
    }

    @Test
    public void test() {
//        Get data without pagination
//        https://easey-dev.app.cloud.gov/api/emissions-mgmt/apportioned/hourly/?beginDate=2019-01-01&endDate=2019-01-31
        JSONArray result = getJSONArray("/api/emissions-mgmt/apportioned/hourly/?beginDate=2019-01-01&endDate=2019-01-31");

//        API returns 4,464 results
        verifyEquals(result.length(), 4464, "results not not equal");
    }
}
