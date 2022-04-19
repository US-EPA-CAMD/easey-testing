package tests.UITests.EASEYOut_Datateers.FilterLogic.MATS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_600_MATS extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(5));
        click(campdElements.dataoption.get(5));

//Select HourlyEmissions Subtype
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// apply date range and test error messages

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
// Wrong Format Error
        waitFor(campdElements.datestart);
        input(campdElements.datestart, "2019/01/01");

        input(campdElements.dateend, "2020/01/02");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.alert);
        verifyEquals(campdElements.alert.getText(),"Requirements\n" +  "Enter the Start Date in the MM/DD/YYYY format\n" +
                "Enter the End Date in the MM/DD/YYYY format\n" +
                "Enter an end date that is greater than or equal to the begin date\n" +
                "Enter dates between 01/01/2015 and the quarter ending on 12/31/2021");
//out of range error message
        click(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        input(campdElements.datestart, "01/01/1960");
        input(campdElements.dateend, "01/02/1969");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.alert);
        verifyEquals(campdElements.alert.getText(),"Requirements\n" + "Enter dates between 01/01/2015 and the quarter ending on 12/31/2021");

 // Apply valid range

        click(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        input(campdElements.datestart, "01/01/2020");
        input(campdElements.dateend, "01/02/2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        waitFor(campdElements.previewdata);

//Select State
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

//Select facility
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(3));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



    }
}

