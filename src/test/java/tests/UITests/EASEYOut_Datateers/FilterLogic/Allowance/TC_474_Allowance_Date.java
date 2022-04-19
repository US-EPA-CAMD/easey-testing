package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_474_Allowance_Date extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
//Apply Transactions Subtype



        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

// Apply Date Range


        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        click(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        waitFor(campdElements.dateend);
        click(campdElements.dateend);
        input(campdElements.dateend, "01/01/2020");

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

// Check Program Type Filtering
        waitFor(campdElements.previewdata);
        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Check Account Type Filtering

        click(campdElements.filtercriteria.get(2));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Check Vintage Year
        jse.executeScript("scroll(0, 1000);");
        click(campdElements.filtercriteria.get(7));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Change Date Range and cancel
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        click(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        waitFor(campdElements.dateend);
        click(campdElements.dateend);
        input(campdElements.dateend, "01/01/2021");

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));


// Apply cancelled range
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        driver.switchTo().alert().accept();
// Remove from Pill adn then cancel
        waitFor(campdElements.modify.get(0));
        waitFor(campdElements.remove.get(0));
        click(campdElements.remove.get(0));

        driver.switchTo().alert().dismiss();

// Cancel from Pill
        waitFor(campdElements.remove.get(0));
        click(campdElements.remove.get(0));
        driver.switchTo().alert().accept();
// Apply out of date range
        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        click(campdElements.datestart);
        input(campdElements.datestart, "01/01/1985");

        waitFor(campdElements.dateend);
        click(campdElements.dateend);
        input(campdElements.dateend, "01/01/2020");

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));


        waitFor(campdElements.alert);
        verifyTrue(campdElements.alert.isDisplayed());




    }

}
