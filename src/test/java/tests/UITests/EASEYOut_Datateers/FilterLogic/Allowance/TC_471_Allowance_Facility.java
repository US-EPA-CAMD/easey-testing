package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_471_Allowance_Facility extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
//Apply Account Info  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);
//Select and Apply Filter Critetia for Facility


        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(3));
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));
// Check Program Filtering

        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Check Account Type Filtering

        click(campdElements.filtercriteria.get(1));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allowance Holdings Subtype
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);
//Select and Apply Filter Critetia for Facility


        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(3));
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));


// Check Program Filtering

        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// Check Account Type Filtering

        click(campdElements.filtercriteria.get(1));

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