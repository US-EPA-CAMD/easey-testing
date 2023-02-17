package tests.UITests.CAMPD.filterLogic;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_542_Limit_CDD extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

//Select HourlyEmissions Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


        {
            try
            {
                Thread.sleep(100000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
// apply date range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2020");

        input(campdElements.dateend, "03/01/2020");
        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));


        {
            try
            {
                Thread.sleep(100000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }


        waitFor(campdElements.previewdata);

// Click preview data
        click(campdElements.previewdata);

        {
            try
            {
                Thread.sleep(100000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
// Verify Message and go to bulk data download

        waitFor(campdElements.downloaddata);
        verifyFalse(campdElements.downloaddata.isEnabled());

        waitFor(campdElements.alert);
        verifyEquals(campdElements.alert.getText(),"Your query exceeds the record limit of 1,000,000. Refine your query to further limit the number of records returned or visit the Bulk Data Files.");

        waitFor(campdElements.alertlink);
        click(campdElements.alertlink);
// go to Bulk Data

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");



    }
}