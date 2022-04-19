package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_473_Allowance_State extends UITestBase {
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


//Apply Account Info  Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

// Apply State Filter Logic

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(5));
        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Check Program Type Filtering

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

// Change to Allowance Holdings Subtype
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);

// Apply State Filter Logic

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(5));
        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Check Program Type Filtering

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