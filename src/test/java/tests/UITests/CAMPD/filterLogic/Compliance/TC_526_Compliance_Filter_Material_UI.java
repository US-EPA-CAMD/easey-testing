package tests.UITests.CAMPD.filterLogic.Compliance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_526_Compliance_Filter_Material_UI extends UITestBase {
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

//Select Allowance Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }

//Select Emissions Subtype
        click(campdElements.changebutton);
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(2));
        click(campdElements.subtypeoption.get(2));

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }
    }

}