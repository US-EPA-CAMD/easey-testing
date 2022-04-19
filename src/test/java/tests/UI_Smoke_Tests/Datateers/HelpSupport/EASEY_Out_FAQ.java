package tests.UI_Smoke_Tests.Datateers.HelpSupport;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_FAQ extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.hometitle);
// Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
// click contact us
        waitFor(campdElements.faqlink);
        click(campdElements.faqlink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/faqs");

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
// Test Accordions

        jse.executeScript("scroll(0, 600);");

        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"true");
        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"false");
// test links
        jse.executeScript("scroll(0, -600);");
// Test Tutorials Link
        waitFor(campdElements.firstparalinks.get(0));
        click(campdElements.firstparalinks.get(0));

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");
// Test Contact Us Link
        goTo("https://campd-dev.app.cloud.gov/help-support/faqs");
// Test Contact Us Link
        waitFor(campdElements.firstparalinks.get(1));
        click(campdElements.firstparalinks.get(1));

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");
    }
}

