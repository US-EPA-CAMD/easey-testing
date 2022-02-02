package tests.UITests.EASEYOut_Datateers.FilterLogic.Emissions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_526_Emissions_Filter_Material_Ui extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(1));
        click(customDataDownloadPage.dataoption.get(1));


//Select HourlyEmissions Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }

// Change to Daily Emissions

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }

// Change to Monthly Emissions
        waitFor(customDataDownloadPage.changebutton);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);

// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }

// Change to Quarterly Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(4));

        click(customDataDownloadPage.applyBtn);

// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }
// Change to Ozone Season  Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(5));

        click(customDataDownloadPage.applyBtn);

// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }
// Change to Annual Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(6));

        click(customDataDownloadPage.applyBtn);

// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }

    }


}


