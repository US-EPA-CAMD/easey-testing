package tests.UI_Smoke_Tests.Datateers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class EASEY_Out_RelatedResources extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        waitFor(customDataDownloadPage.hometitle);
// Click data menu
        waitFor(customDataDownloadPage.resources);
        click(customDataDownloadPage.resources);

// Click Bulk Data
        waitFor(customDataDownloadPage.resourceslinks);
        click(customDataDownloadPage.resourceslinks);

// Change to Related Resources Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);

// Select AirData Resource
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.rrlink.get(0));
        click(customDataDownloadPage.rrlink.get(0));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/outdoor-air-quality-data");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
// Select Castnet Resource

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.rrlink.get(1));
        click(customDataDownloadPage.rrlink.get(1));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/castnet");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
// Select eGrid Resource

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.rrlink.get(2));
        click(customDataDownloadPage.rrlink.get(2));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/egrid");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
// Select Energy Info Administration Resource

        jse.executeScript("scroll(0,1000);");

        waitFor(customDataDownloadPage.rrlink.get(3));
        click(customDataDownloadPage.rrlink.get(3));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.eia.gov/environment/");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
// Select National Pollution Air Trends

        jse.executeScript("scroll(0,1000);");

        waitFor(customDataDownloadPage.rrlink.get(4));
        click(customDataDownloadPage.rrlink.get(4));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/air-trends");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
//Select National Atmosphere Deposition Program
        jse.executeScript("scroll(0,1000);");

        waitFor(customDataDownloadPage.rrlink.get(5));
        click(customDataDownloadPage.rrlink.get(5));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://nadp.slh.wisc.edu/");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
        waitFor(customDataDownloadPage.pagetitle);
//Select National Emissions Inventory
        jse.executeScript("scroll(0,1500);");

        waitFor(customDataDownloadPage.rrlink.get(6));
        click(customDataDownloadPage.rrlink.get(6));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/air-emissions-inventories");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
//Select Progress Reports
        jse.executeScript("scroll(0,1500);");

        waitFor(customDataDownloadPage.rrlink.get(7));
        click(customDataDownloadPage.rrlink.get(7));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www3.epa.gov/airmarkets/progress/reports/index.html");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
//Select US Greenhouse Gas Inventory
        jse.executeScript("scroll(0,1500);");

        waitFor(customDataDownloadPage.rrlink.get(8));
        click(customDataDownloadPage.rrlink.get(8));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/ghgemissions");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/resources/related-resources");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/related-resources");

        waitFor(customDataDownloadPage.pagetitle);
    }
}

