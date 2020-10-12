package tests.temp;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactAppHomePage;
import tests.utils.UITestBase;

public class SampleStarterUITestCase extends UITestBase {

    @Test
    public void test() {
        goTo("https://react-app-boisterous-wolf-vb.app.cloud.gov/");

        ReactAppHomePage homepage = new ReactAppHomePage(driver);

        waitFor(homepage.table);

        Assert.assertTrue(isDisplayed(homepage.table));

//        sleep(100000);
    }
}
