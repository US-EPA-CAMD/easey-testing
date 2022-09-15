package tests.UI_Smoke_Tests.Datateers.Data.CustomDataDownload.Compliance;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Compliance_Emissions extends UITestBase {
    @Test
    public void test() {

        // Navigate to CAMPD

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

        // Select Compliance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));

        jse.executeScript("scroll(0, 250);");
        // Select Emissions Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(2));
        click(campdElements.subtypeoption.get(2));
        //Apply  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        // Apply Program Filter Logic

        {
            try
            {
                Thread.sleep(15000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }


        // Apply State

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Year

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(3));
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Preview Data

        waitFor(campdElements.previewdata);
        click(campdElements.previewdata);

        // Download as csv


        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);
        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }




        // test for JSON

        // Navigate to CAMPD

        changeTab();

        // Navigate to CAMPD
        goTo("https://campd-perf.app.cloud.gov/data/custom-data-download");

        // Select Allowance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));

        jse.executeScript("scroll(0, 250);");
        // Select Allowance Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(2));
        click(campdElements.subtypeoption.get(2));
        //Apply  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        // Apply Program Filter Logic

        {
            try
            {
                Thread.sleep(15000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }


        // Apply State

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Year

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(3));
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Preview Data

        waitFor(campdElements.previewdata);
        click(campdElements.previewdata);

        // Download as JSON

        waitFor(campdElements.json);
        jse.executeScript("arguments[0].click();", campdElements.json);
        waitFor(campdElements.downloaddata);
        // Download as JSON

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);

        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        waitFor(campdElements.json);
        click(campdElements.json);
        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);





    }
}

