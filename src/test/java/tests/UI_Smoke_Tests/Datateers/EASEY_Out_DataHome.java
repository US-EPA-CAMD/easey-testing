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

public class EASEY_Out_DataHome extends UITestBase  {
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
        waitFor(customDataDownloadPage.datahome);
        click(customDataDownloadPage.datahome);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");

        waitFor(customDataDownloadPage.pagetitle);

// Select data query Button
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.datahomebutton.get(0));
        click(customDataDownloadPage.datahomebutton.get(0));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");
// Return to Data Home page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/data");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");

        waitFor(customDataDownloadPage.pagetitle);

// Select Data Download Button
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.datahomebutton.get(1));
        click(customDataDownloadPage.datahomebutton.get(1));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");
// Return to bulk data page
        changeTab();
        goTo("https://campd-dev.app.cloud.gov/data");

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");

        waitFor(customDataDownloadPage.pagetitle);



    }
}
