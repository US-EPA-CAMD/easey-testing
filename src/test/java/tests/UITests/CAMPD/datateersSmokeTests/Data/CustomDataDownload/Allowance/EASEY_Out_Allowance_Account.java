package tests.UITests.CAMPD.datateersSmokeTests.Data.CustomDataDownload.Allowance;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Allowance_Account extends UITestBase {
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


//        // navigate to chrome downloads
//
        driver.get("chrome://downloads");
//
        JavascriptExecutor js1 = (JavascriptExecutor)driver;

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


        // get the latest downloaded file name
        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(fileName);

        String fileconfirm = "allowance-account";

        verifyTrue(fileName.contains(fileconfirm));


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


        waitFor(campdElements.json);
        js1.executeScript("arguments[0].click();", campdElements.json);
        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);
        // Download as json

        waitFor(campdElements.downloaddata);
        click(campdElements.downloaddata);
//        // navigate to chrome downloads
//
        driver.get("chrome://downloads");

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


        // get the latest downloaded file name
        String fileName1 = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(fileName1);

        String fileconfirm1 = "allowance-account";

        verifyTrue(fileName.contains(fileconfirm));
//

    }
}