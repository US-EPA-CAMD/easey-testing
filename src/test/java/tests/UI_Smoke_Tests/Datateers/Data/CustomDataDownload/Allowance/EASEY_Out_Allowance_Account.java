package tests.UI_Smoke_Tests.Datateers.Data.CustomDataDownload.Allowance;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Allowance_Account extends UITestBase {
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

        // Select Allowance Data Type

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        // Select Account Info Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        //Apply Account Info  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        // Apply Program Filter Logic
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

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Account Name/Number Filter

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

        // Preview Data

        waitFor(campdElements.previewdata);
        click(campdElements.previewdata);

        // Download as csv

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);


        // test for JSON

        changeTab();

        // Navigate to CAMPD
        goTo("https://campd-perf.app.cloud.gov/data/custom-data-download");

        // Select Allowance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        // Select Account Info Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        //Apply Account Info  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        // Apply Program Filter Logic

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

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Account Name/Number Filter

        waitFor(campdElements.previewdata);
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(5));
        click(campdElements.filtercriteria.get(5));

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


        waitFor(campdElements.json);
        click(campdElements.json);
        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);
        // Download as json

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);

//

    }
}