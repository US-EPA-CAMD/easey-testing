package tests.UI_Smoke_Tests.Datateers.Data;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class EASEY_Out_DataHome extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // Navigate to Data Home Page
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Change to  Data Page
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.cdd);
        click(campdElements.cdd);
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

// Bulk Data Test

       goTo("https://campd-dev.app.cloud.gov/data");
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");


// Test for CAM API
        goTo("https://campd-dev.app.cloud.gov/data");
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        jse.executeScript("scroll(0, 700);");

        waitFor(campdElements.apis);
        click(campdElements.apis);
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/cam-api-portal");



    }
}

