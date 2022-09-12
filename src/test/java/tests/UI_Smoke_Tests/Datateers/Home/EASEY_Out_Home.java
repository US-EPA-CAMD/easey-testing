package tests.UI_Smoke_Tests.Datateers.Home;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Home extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 1000);");
        // Click Data Button

        waitFor(campdElements.homepageHeader.get(0));
        click(campdElements.homepageHeader.get(0));



        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");

        goTo("https://campd-dev.app.cloud.gov");
        jse.executeScript("scroll(0, 1000);");

        // Click Viz  Button

        waitFor(campdElements.homepageHeader.get(1));
        click(campdElements.homepageHeader.get(1));

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/visualization-gallery");
        goTo("https://campd-dev.app.cloud.gov");
        jse.executeScript("scroll(0, 1000);");
        // Click Data Query Button

        waitFor(campdElements.dataQuery);
        click(campdElements.dataQuery);

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

        // Test what's new links
        goTo("https://campd-dev.app.cloud.gov");
        jse.executeScript("scroll(0, 1000);");

        // Tutorials
        waitFor(campdElements.whatsnewlink.get(0));
        click(campdElements.whatsnewlink.get(0));

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");

        // Quick Start Guides
        goTo("https://campd-dev.app.cloud.gov");
        jse.executeScript("scroll(0, 1000);");

        // Quick Start Guides
        waitFor(campdElements.whatsnewlink.get(1));
        click(campdElements.whatsnewlink.get(1));

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://api.epa.gov/easey/dev/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf");

        goTo("https://campd-dev.app.cloud.gov");
        jse.executeScript("scroll(0, 1400);");

        // Contact Us
        waitFor(campdElements.whatsnewlink.get(2));
        click(campdElements.whatsnewlink.get(2));

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");



    }
}

