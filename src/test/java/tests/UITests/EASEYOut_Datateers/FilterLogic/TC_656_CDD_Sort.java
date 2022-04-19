package tests.UITests.EASEYOut_Datateers.FilterLogic;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_656_CDD_Sort extends UITestBase  {

    @Test
    public void test() {

        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

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
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

// apply date range


        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2020");

        input(campdElements.dateend, "01/02/2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));
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
        waitFor(campdElements.previewdata);
        click(campdElements.previewdata);

// CLick on sort options
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

        waitFor(campdElements.columnheaders.get(0));
        action.moveToElement(campdElements.columnheaderssort.get(0));
        click(campdElements.ellipsis.get(0));

// Get text of sort options
        verifyEquals(campdElements.ellipsisModal.get(0).getText() ,"Unsort");
        verifyEquals(campdElements.ellipsisModal.get(1).getText() ,"Sort by ASC");
        verifyEquals(campdElements.ellipsisModal.get(2).getText() ,"Sort by DESC");
        verifyEquals(campdElements.ellipsisModal.get(3).getText() ,"Customize Columns");



    }
}
