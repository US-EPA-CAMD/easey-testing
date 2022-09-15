package tests.UI_Smoke_Tests.Datateers.Data.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;

public class EASEY_Out_BulkData_Emissions extends UITestBase {

    @Test
    public void test() {


        goTo("https://campd-perf.app.cloud.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Navigate to Data Home Page
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        //Click CDD
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/data");
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);
        verifyEquals(driver.getCurrentUrl(), "https://campd-perf.app.cloud.gov/data/bulk-data-files");

//Select Emissions
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(4));
        click(campdElements.dataoption.get(4));



        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

//Select Hourly
        waitFor(campdElements.subtypeBDD);
        click(campdElements.subtypeBDD);

// Select Quarterly
        waitFor(campdElements.bddSubtype.get(1));
        click(campdElements.bddSubtype.get(1));
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(campdElements.grouping);
        click(campdElements.grouping);

        waitFor(campdElements.groupingoption.get(1));
        click(campdElements.groupingoption.get(1));



        jse.executeScript("scroll(0, 400);");
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        jse.executeScript("arguments[0].click();", campdElements.bddCheckbox.get(0));

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);
        jse.executeScript("scroll(0, -400);");

//Select Hourly
        waitFor(campdElements.subtypeBDD);
        click(campdElements.subtypeBDD);

// Select Quarterly
        waitFor(campdElements.bddSubtype.get(2));
        click(campdElements.bddSubtype.get(2));

        waitFor(campdElements.grouping);
        click(campdElements.grouping);

        waitFor(campdElements.groupingoption.get(2));
        click(campdElements.groupingoption.get(2));

        jse.executeScript("scroll(0, 400);");
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        jse.executeScript("arguments[0].click();", campdElements.bddCheckbox.get(0));

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);


    }

}