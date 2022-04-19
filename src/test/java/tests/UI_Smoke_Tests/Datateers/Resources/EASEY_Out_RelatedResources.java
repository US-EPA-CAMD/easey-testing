package tests.UI_Smoke_Tests.Datateers.Resources;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class EASEY_Out_RelatedResources extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.resources);
        click(campdElements.resources);

// Click Bulk Data
        waitFor(campdElements.resourceslinks);
        click(campdElements.resourceslinks);

// Change to Related Resources Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);

// Select AirData Resource
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.rrlink.get(0));
        click(campdElements.rrlink.get(0));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/outdoor-air-quality-data");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
// Select Castnet Resource

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.rrlink.get(1));
        click(campdElements.rrlink.get(1));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/castnet");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
// Select eGrid Resource

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.rrlink.get(2));
        click(campdElements.rrlink.get(2));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/egrid");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
// Select Energy Info Administration Resource

        jse.executeScript("scroll(0,1000);");

        waitFor(campdElements.rrlink.get(3));
        click(campdElements.rrlink.get(3));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.eia.gov/environment/");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
// Select National Pollution Air Trends

        jse.executeScript("scroll(0,1000);");

        waitFor(campdElements.rrlink.get(4));
        click(campdElements.rrlink.get(4));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/air-trends");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
//Select National Atmosphere Deposition Program
        jse.executeScript("scroll(0,1000);");

        waitFor(campdElements.rrlink.get(5));
        click(campdElements.rrlink.get(5));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://nadp.slh.wisc.edu/");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
        waitFor(campdElements.pagetitle);
//Select National Emissions Inventory
        jse.executeScript("scroll(0,1500);");

        waitFor(campdElements.rrlink.get(6));
        click(campdElements.rrlink.get(6));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/air-emissions-inventories");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
//Select Progress Reports
        jse.executeScript("scroll(0,1500);");

        waitFor(campdElements.rrlink.get(7));
        click(campdElements.rrlink.get(7));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www3.epa.gov/airmarkets/progress/reports/index.html");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
//Select US Greenhouse Gas Inventory
        jse.executeScript("scroll(0,1500);");

        waitFor(campdElements.rrlink.get(8));
        click(campdElements.rrlink.get(8));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/ghgemissions");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);
    }
}

