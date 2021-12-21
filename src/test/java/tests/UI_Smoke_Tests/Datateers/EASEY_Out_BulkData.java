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

public class EASEY_Out_BulkData extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        waitFor(customDataDownloadPage.hometitle);
// Click data menu
        waitFor(customDataDownloadPage.datamenu);
        click(customDataDownloadPage.datamenu);

// Click Bulk Data
        waitFor(customDataDownloadPage.bulkdata);
        click(customDataDownloadPage.bulkdata);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

        waitFor(customDataDownloadPage.pagetitle);

// Select Allowance Button
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.allowance);
        click(customDataDownloadPage.allowance);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/allowances/");
// Return to bulk data page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/data/bulk-data-files");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

        waitFor(customDataDownloadPage.pagetitle);

// Select Allowance Button
        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.compliance);
        click(customDataDownloadPage.compliance);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/compliance/");
// Return to bulk data page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/data/bulk-data-files");
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

        waitFor(customDataDownloadPage.pagetitle);

// Select emissions Button
        jse.executeScript("scroll(0, 1000);");

        waitFor(customDataDownloadPage.emissions);
        click(customDataDownloadPage.emissions);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/emissions/");

// Return to bulk data page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/data/bulk-data-files");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

        waitFor(customDataDownloadPage.pagetitle);

// Select Allowance Button
        jse.executeScript("scroll(0, 1000);");

        waitFor(customDataDownloadPage.rawemissions);
        click(customDataDownloadPage.rawemissions);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/xml/");

    }
}
