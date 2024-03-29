package tests.UITests.CAMPD.datateersSmokeTests.Data.CustomDataDownload.Compliance;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Compliance_Emissions extends UITestBase {
    @Test
    public void test() {

        // Navigate to CAMPD

        goTo("https://campd-dev.app.cloud.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

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

        driver.get("chrome://downloads");

        JavascriptExecutor js1 = (JavascriptExecutor)driver;

        // get the latest downloaded file name
        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(fileName);

        String fileconfirm = "compliance-emissions";

        verifyTrue(fileName.contains(fileconfirm));
//

        // test for JSON

        // Navigate to CAMPD

        goTo("https://campd-dev.app.cloud.gov/");

        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

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
        js1.executeScript("arguments[0].click();", campdElements.json);
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

        String Jfileconfirm = "compliance-emissions";

        verifyTrue(JfileName.contains(Jfileconfirm));

    }
}

