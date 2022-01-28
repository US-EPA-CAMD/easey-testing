package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_526_Allowance_Filter_Material_UI extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(2));
        click(customDataDownloadPage.dataoption.get(2));

//Select Account Info Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));
        jse.executeScript("scroll(0, 400);");
        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }

//Select Account Holdings  Subtype
        click(customDataDownloadPage.changebutton);


        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(2));
        click(customDataDownloadPage.subtypeoption.get(2));
        jse.executeScript("scroll(0, 400);");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }
//Select Account Transactions Subtype
        click(customDataDownloadPage.changebutton);
        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(3));
        click(customDataDownloadPage.subtypeoption.get(3));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// Verify Material UI Presence

        waitFor(customDataDownloadPage.previewdata);
        for (WebElement ele : customDataDownloadPage.filtercriteria) {

            verifyTrue(customDataDownloadPage.materialui.isDisplayed());
        }


    }

}