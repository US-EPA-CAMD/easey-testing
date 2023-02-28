package tests.UITests.CAMPD.datateersSmokeTests.Data;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class EASEY_Out_BulkData extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/bulk-data-files");

        waitFor(campdElements.pagetitle);

// Select Allowance Data
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.allowance);
        click(campdElements.allowance);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/allowances/");

// Test from another CAMPD Page

        goTo("https://campd.epa.gov/resources/related-resources");

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/bulk-data-files");

        waitFor(campdElements.pagetitle);

// Select Compliance Data

        jse.executeScript("scroll(0, 400);");
        waitFor(campdElements.compliance);
        click(campdElements.compliance);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/compliance/");
// Test from another CAMPD Page

        goTo("https://campd.epa.gov/");

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/bulk-data-files");

        waitFor(campdElements.pagetitle);

// Select Emissions Data

        jse.executeScript("scroll(0, 700);");
        waitFor(campdElements.emissions);
        click(campdElements.emissions);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/emissions/");

// Test from another CAMPD Page

        goTo("https://campd.epa.gov/resources/glossary");

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/bulk-data-files");

        waitFor(campdElements.pagetitle);

// Select Compliance Data

        jse.executeScript("scroll(0, 700);");
        waitFor(campdElements.rawemissions);
        click(campdElements.rawemissions);
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://gaftp.epa.gov/DMDnLoad/xml/");


    }
}

