package tests.UITests.CAMPD.datateersSmokeTests.Data;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class EASEY_Out_DataHome extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd.epa.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Data Home Page
        waitFor(campdElements.datahome);
        click(campdElements.datahome);

// Change to  Data Page

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data");
        waitFor(campdElements.pagetitle);

// Select CDD
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.datahomebutton.get(0));
        click(campdElements.datahomebutton.get(0));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/custom-data-download");

// Bulk Data Test

       goTo("https://campd.epa.gov/data/");

        waitFor(campdElements.hometitle);

// Click Bulk Data
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.datahomebutton.get(1));
        click(campdElements.datahomebutton.get(1));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/bulk-data-files");

// Test for CAM API

        goTo("https://campd.epa.gov/data/");

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.datahomebutton.get(2));
        click(campdElements.datahomebutton.get(2));
//Check tab Is correct
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/cam-api-portal");


    }
}

