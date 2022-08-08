package tests.UI_Smoke_Tests.Datateers.Data.CustomDataDownload;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Facility_Unit extends UITestBase {
    @Test
    public void test() {

        // Navigate to CAMPD

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.hometitle);

        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/custom-data-download");

        // Select Allowance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(4));
        click(campdElements.dataoption.get(4));

        jse.executeScript("scroll(0, 250);");
        // Select Allowance Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        //Apply  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

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

        // Apply date range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

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

        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Facility

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchitem);
        click(campdElements.searchitem.get(0));

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
//        click(customDataDownloadPage.downloaddata);


//        // navigate to chrome downloads
//
//        driver.get("chrome://downloads");
//
        JavascriptExecutor js1 = (JavascriptExecutor)driver;

//            {
//                try
//                {
//                    Thread.sleep(1000);
//                }
//                catch(InterruptedException ex)
//                {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }

//        // get the latest downloaded file name
//        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
//
//        System.out.println(fileName);
//
//        String fileconfirm = "compliance-allowance";
//
//        verifyTrue(fileName.contains(fileconfirm));
//

        // test for JSON

        // Navigate to CAMPD

        goTo("https://campd.epa.gov/");


        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/custom-data-download");

        // Select Allowance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(4));
        click(campdElements.dataoption.get(4));

        jse.executeScript("scroll(0, 250);");
        // Select Allowance Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        //Apply  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

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

        // Apply date range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

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

        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Apply Facility

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchitem);
        click(campdElements.searchitem.get(0));

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
//        click(customDataDownloadPage.downloaddata);

//        // navigate to chrome downloads
//
//        driver.get("chrome://downloads");
//
//            {
//                try
//                {
//                    Thread.sleep(1000);
//                }
//                catch(InterruptedException ex)
//                {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }

//        // get the latest downloaded file name
//        String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
//
//        System.out.println(fileName);
//
//        String fileconfirm = "compliance-allowance";
//
//        verifyTrue(fileName.contains(fileconfirm));
//

    }
}
