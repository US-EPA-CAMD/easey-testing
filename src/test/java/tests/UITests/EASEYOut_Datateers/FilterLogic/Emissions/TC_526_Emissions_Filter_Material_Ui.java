package tests.UITests.EASEYOut_Datateers.FilterLogic.Emissions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_526_Emissions_Filter_Material_Ui extends UITestBase {
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


//Select HourlyEmissions Subtype

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

// Change to Daily Emissions

        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);

// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }

// Change to Monthly Emissions
        waitFor(campdElements.changebutton);
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(3));

        click(campdElements.applyBtn);

// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }

// Change to Quarterly Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(4));

        click(campdElements.applyBtn);

// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }
// Change to Ozone Season  Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(5));

        click(campdElements.applyBtn);

// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }
// Change to Annual Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(6));

        click(campdElements.applyBtn);

// Verify Material UI Presence

        waitFor(campdElements.previewdata);
        for (WebElement ele : campdElements.filtercriteria) {

            verifyTrue(campdElements.materialui.isDisplayed());
        }

    }


}


