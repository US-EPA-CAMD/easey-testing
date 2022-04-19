package tests.UITests.EASEYOut_Datateers.BulkData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.io.File;
import pages.campdElements;
import tests.utils.UITestBase;

public class TC_649_FileSelection_BulkData extends UITestBase  {
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


// Ensure Download Is disabled with no selections
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");

        waitFor(campdElements.bulkDataDownload);
        verifyFalse(campdElements.bulkDataDownload.isEnabled());


// Click three Files

        for (int i = 1 ; i < 4; i++) {
            WebElement ele = campdElements.checkbox.get(i);
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
             }

        waitFor(campdElements.bulkDataDownload);
        click(campdElements.bulkDataDownload);



}
}


