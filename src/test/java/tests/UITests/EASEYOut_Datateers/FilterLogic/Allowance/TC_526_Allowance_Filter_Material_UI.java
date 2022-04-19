package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_526_Allowance_Filter_Material_UI extends UITestBase {
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

//Select Account Info Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        jse.executeScript("scroll(0, 400);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }

//Select Account Holdings  Subtype
        click(campdElements.changebutton);


        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(2));
        click(campdElements.subtypeoption.get(2));
        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }
//Select Account Transactions Subtype
        click(campdElements.changebutton);
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(3));
        click(campdElements.subtypeoption.get(3));

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }


    }

}