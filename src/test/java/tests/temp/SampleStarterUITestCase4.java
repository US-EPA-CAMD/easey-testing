package tests.temp;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactAppHomePage;
import tests.utils.UITestBase;

public class SampleStarterUITestCase4 extends UITestBase {

    private final String url = "https://easey-tst.app.cloud.gov/";

    @Test
    public void test1() {
        goTo(url);

        ReactAppHomePage homepage = new ReactAppHomePage(driver);

        waitFor(homepage.table);

        Assert.assertTrue(isDisplayed(homepage.table));

//        sleep(100000);
    }
}
