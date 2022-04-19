package tests.UI_Smoke_Tests.Datateers.Data.CustomDataDownload.Emissions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;

public class EASEY_Out_Emissions_Quarterly extends UITestBase {

    @Test
    public void test() {
// Test for CSV
        // Navigate to CAMPD

        goTo("https://campd-dev.app.cloud.gov/");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

        // Select Emmissions Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

        // Select Quarterly  Subtype
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(4));
        click(campdElements.subtypeoption.get(4));


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

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

        // Apply unit fuel type Filter Logic

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
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.filtercriteria.get(5));
        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Facility Filter

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


        //navigate to chrome downloads

        driver.get("chrome://downloads");

        JavascriptExecutor js1 = (JavascriptExecutor)driver;

        // get the latest downloaded file name
        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(fileName);

        String fileconfirm = "quarterly-emissions";

        verifyTrue(fileName.contains(fileconfirm));

// Test for JSON
        goTo("https://campd-dev.app.cloud.gov/");


        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

        // Select Emmissions Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

        // Select Quarterly  Subtype
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(4));
        click(campdElements.subtypeoption.get(4));


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

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

        // Apply unit fuel type Filter Logic

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
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.filtercriteria.get(5));
        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Facility Filter

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

        // Download as json

        waitFor(campdElements.json);
        js1.executeScript("arguments[0].click();", campdElements.json);
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


        //navigate to chrome downloads

        driver.get("chrome://downloads");



        // get the latest downloaded file name
        String JfileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(JfileName);

        String Jfileconfirm = "quarterly-emissions";

        verifyTrue(JfileName.contains(Jfileconfirm));


    }
}

