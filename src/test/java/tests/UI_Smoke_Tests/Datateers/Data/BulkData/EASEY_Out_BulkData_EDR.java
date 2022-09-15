package tests.UI_Smoke_Tests.Datateers.Data.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;

public class EASEY_Out_BulkData_EDR extends UITestBase {

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

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));



        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

//Select Year
        waitFor(campdElements.yearBDD);
        click(campdElements.yearBDD);

        waitFor(campdElements.yearoption.get(13));
        click(campdElements.yearoption.get(13));

//Select Quarter
        waitFor(campdElements.quarterbdd);
        click(campdElements.quarterbdd);

        waitFor(campdElements.quarteroption.get(1));
        click(campdElements.quarteroption.get(1));

        //Select State
        waitFor(campdElements.statesbdd);
        click(campdElements.statesbdd);
        {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(campdElements.stateoption.get(1));
        click(campdElements.stateoption.get(1));


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