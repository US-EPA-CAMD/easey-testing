package tests.UITests.CAMPD.filterLogic.Compliance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_475_Compliance_Program extends UITestBase {
    @Test
    public void test() {

        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(3));
        click(campdElements.dataoption.get(3));


//Apply Allowance  Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);
//Select and Apply Filter Critetia for Program

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

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


    }

}