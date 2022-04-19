package tests.UI_Smoke_Tests.Datateers.HelpSupport;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Tutorials extends UITestBase {
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
// click tutorials
        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");

        waitFor(campdElements.pagetitle);

// Test First Paragraph Links

// Test FAQS Link
        waitFor(campdElements.firstparalinks.get(0));
        click(campdElements.firstparalinks.get(0));

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/faqs");
// Test Contact Us Link
        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.firstparalinks.get(1));
        click(campdElements.firstparalinks.get(1));
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");

 // Test PDF's
        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.pagetitle);

 // CDD PDF
        jse.executeScript("scroll(0, 600);");
        waitFor(campdElements.tutorialspdfs.get(0));
        click(campdElements.tutorialspdfs.get(0));
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://api.epa.gov/easey/dev/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf");
//Allowance PDF
        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.pagetitle);

        jse.executeScript("scroll(0, 800);");
        waitFor(campdElements.tutorialspdfs.get(1));
        click(campdElements.tutorialspdfs.get(1));
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/allowance-data");
// Emissions PDF
        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.pagetitle);

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.tutorialspdfs.get(2));
        click(campdElements.tutorialspdfs.get(2));
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/power-sector-emissions-data");

// substitute data
        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.pagetitle);

        jse.executeScript("scroll(0, 1200);");
        waitFor(campdElements.tutorialspdfs.get(3));
        click(campdElements.tutorialspdfs.get(3));
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/monitoring-insights");

// Data Crosswalk

        goTo("https://campd-dev.app.cloud.gov/help-support/tutorials");
        waitFor(campdElements.pagetitle);

        jse.executeScript("scroll(0, 1400);");
        waitFor(campdElements.tutorialspdfs.get(4));
        click(campdElements.tutorialspdfs.get(4));
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/power-sector-data-crosswalk");



    }
}

