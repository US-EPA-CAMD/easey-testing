package tests.temp;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SamplePage;
import tests.utils.UITestBase;

public class SampleUITestCase extends UITestBase {

    @Test
    public void test() {
        // navigate to the web site
        goTo("https://www.google.com");
        // Validate page title
        SamplePage google = new SamplePage(driver);
        waitFor(google.searchBar);
        Assert.assertTrue(isDisplayed(google.searchBar));
        search(google.searchBar, "CVP");
        waitFor(driver -> google.results.size() > 0);
        System.out.println(google.results.size());
        for (WebElement result : google.results) {
            System.out.println(result.getText());
            if (result.getText().equals("CVP | Navigating Continuous Change.")){
                click(result);
                break;
            }
        }
//        sleep(10000);
    }
}