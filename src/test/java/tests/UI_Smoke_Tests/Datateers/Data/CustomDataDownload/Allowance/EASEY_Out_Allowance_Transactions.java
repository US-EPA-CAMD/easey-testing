package tests.UI_Smoke_Tests.Datateers.Data.CustomDataDownload.Allowance;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;

public class EASEY_Out_Allowance_Transactions extends UITestBase {

    @Test
    public void test() {
// Test for CSV
        // Navigate to CAMPD

        goTo("https://campd-dev.app.cloud.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        // Navigate to Data Home Page
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        //Click CDD
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data");
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

        // Select Transactions Subtype
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(3));
        click(campdElements.subtypeoption.get(3));


        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


        // Apply Date Range
        {
            try
            {
                Thread.sleep(20000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }


        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/10/2019");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
        // Apply Program Filter Logic

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

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply State Filter
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(6));
        click(campdElements.filtercriteria.get(6));

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

        JavascriptExecutor js1 = (JavascriptExecutor)driver;


// Test for JSON

        changeTab();

        // Navigate to CAMPD
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");


        // Select Allowance Data Type

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        // Select Transactions Subtype
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(3));
        click(campdElements.subtypeoption.get(3));


        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


        // Apply Date Range
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


        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/10/2019");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
        // Apply Program Filter Logic

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

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply State Filter
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(6));
        click(campdElements.filtercriteria.get(6));

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

