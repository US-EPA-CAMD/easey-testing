package tests.UITests.EASEYOut_Datateers.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;

public class TC_650_Filters_BulkData extends UITestBase  {
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

// Select Allowance as Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

 // Check Description to see Filtering
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");
        waitFor((campdElements.BDDdescription.get(0)));
        campdElements.BDDdescription.get(0).getText().contains("allowance");

// Select Clear ALl
        waitFor(campdElements.clearAll);
        click(campdElements.clearAll);

// Select MATs Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(5));
        click(campdElements.dataoption.get(5));

// Select Quarterly

        waitFor(campdElements.grouping);
        click(campdElements.grouping);
        click(campdElements.groupingoption.get(1));

// Select State

        waitFor(campdElements.grouping);
        click(campdElements.grouping);
        click(campdElements.groupingoption.get(2));

        waitFor(campdElements.states);
        click(campdElements.states);
        click(campdElements.statesoption.get(1));

// Select Emissions

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));
        // Select Hourly

        waitFor(campdElements.bddsubtype);
        click(campdElements.bddsubtype);
        click(campdElements.suboption.get(1));

        // Select quarterly
        waitFor(campdElements.grouping);
        click(campdElements.grouping);
        click(campdElements.groupingoption.get(1));

        //select state

        waitFor(campdElements.grouping);
        click(campdElements.grouping);
        click(campdElements.groupingoption.get(2));
        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.states);
        click(campdElements.states);
        click(campdElements.statesoption.get(1));

// clear all
        waitFor(campdElements.clearAll);
        click(campdElements.clearAll);

    }
}

