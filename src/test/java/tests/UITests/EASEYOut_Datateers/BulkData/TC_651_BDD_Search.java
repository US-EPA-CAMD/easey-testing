package tests.UITests.EASEYOut_Datateers.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import pages.campdElements;
import tests.utils.UITestBase;

public class TC_651_BDD_Search extends UITestBase  {
    @Test
    public void test() {


// Navigate to CAMPD homepage

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click Bulk Data
        waitFor(campdElements.bulkdata);
        click(campdElements.bulkdata);

// Change to Bulk Data Page

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/bulk-data-files");

// Search for files

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.bddsearch);
        input(campdElements.bddsearch,"allowance");

//   Search for unmatching string

        campdElements.bddsearch.clear();
        input(campdElements.bddsearch,"ijockmjfwjoie%^&*(");
        click(campdElements.bddsearchsubmit);

        waitFor(campdElements.bddalert);
        campdElements.bddalert.getText().contains("No results match that search criteria");



    }
}


