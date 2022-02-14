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

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

// Click Resources
        waitFor(campdElements.resources);
        click(campdElements.resources);
        // click tutorials
        waitFor(campdElements.glossary);
        click(campdElements.glossary);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/glossary");
 //Click Resources
        waitFor(campdElements.resources);
        click(campdElements.resources);
        // click tutorials
        waitFor(campdElements.resourceslinks);
        click(campdElements.resourceslinks);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");
// Click Help/support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click tutorials
        waitFor(campdElements.aboutlink);
        click(campdElements.aboutlink);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/about");
// Click Help/support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click tutorials
        waitFor(campdElements.contactuslink);
        click(campdElements.contactuslink);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");
// Click Help/support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click tutorials
        waitFor(campdElements.faqlink);
        click(campdElements.faqlink);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/faqs");
// Click Help/support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click tutorials
        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");
// Click data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        // click tutorials
        waitFor(campdElements.datahome);
        click(campdElements.datahome);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");
// Click data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        // click tutorials
        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

// Click data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        // click tutorials
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

// Click data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        // click tutorials
        waitFor(campdElements.camapi);
        click(campdElements.camapi);
        // verify page location
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/cam-api-portal");
    }

}