package tests.UITests.EASEYOut_Datateers.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;

public class TC_632_Bulk_Data_Table extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");
        waitFor(campdElements.pagetitle);

// Verify Table Is loaded and sort works
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 1000);");

        waitFor(campdElements.columnheaders.get(0));
        verifyEquals(campdElements.columnheaders.get(0).getText(),"File Name");
        verifyTrue(campdElements.columnheaderssort.get(0).isEnabled());
        verifyEquals(campdElements.columnheaders.get(1).getText(),"Date Updated");
        verifyEquals(campdElements.columnheaders.get(2).getText(),"Description");
        verifyEquals(campdElements.columnheaders.get(3).getText(),"File Size");

// Verify Pagination
        verifyTrue(campdElements.columnheaderssort.get(0).isEnabled());



    }
}

