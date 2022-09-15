package tests.UI_Smoke_Tests.Datateers.Home;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Navigation extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-perf.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

// Click Data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/data");
// Click Vizualizations
        waitFor(campdElements.viznav);
        click(campdElements.viznav);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/visualization-gallery");

 // Click About
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.aboutlink);
        click(campdElements.aboutlink);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/about");

        // Click Tutorials
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/tutorials");

        // Click FAQS
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.faqlink);
        click(campdElements.faqlink);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/faqs");

        // Click Glossary
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.glossary);
        click(campdElements.glossary);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/glossary");

        // Click Related Resources
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.resourceslinks);
        click(campdElements.resourceslinks);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/related-resources");

        // Click Contact-Us
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        waitFor(campdElements.contactuslink);
        click(campdElements.contactuslink);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/help-support/contact-us");

    }

}