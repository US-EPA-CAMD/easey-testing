package tests.UITests.CAMPD.filterLogic.Compliance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_478_Compliance_OwnOp extends UITestBase {
    @Test
    public void test() {

//Navigate to Easey In

        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        jse.executeScript("scroll(0, 500)");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);
//Select and Owner Operator


        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Check Program Filtering
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allowance Holdings Subtype
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);
//Select and Owner Operator


        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.searchbox);
        click(campdElements.searchbox);

        waitFor(campdElements.searchitem.get(0));
        click(campdElements.searchitem.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Check Program Filtering
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
    }

}