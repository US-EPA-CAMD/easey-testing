package tests.UI_Smoke_Tests.Datateers.HelpSupport;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_About extends UITestBase {
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
        waitFor(campdElements.aboutlink);
        click(campdElements.aboutlink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/about");

        waitFor(campdElements.pagetitle);

// Test Accordions

        jse.executeScript("scroll(0, 1000);");

        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"true");
        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"false");
    }

}