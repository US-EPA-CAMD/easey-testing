package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC_469_Vintage_Year_filter_logic extends UITestBase {
    @Test
    public void test() {

//Navigate to Easey In

        goTo("https://campd-dev.app.cloud.gov/select-data-type");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
        waitFor(customDataDownloadPage.emissionsBtn);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);");
        //Select data type
        click(customDataDownloadPage.emissionsBtn.get(1));
// Navigate to the Emissions Custom Data Download page
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Apply Allowance Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(2));
        click(customDataDownloadPage.subtypeoption.get(2));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);
//Select and Apply Filter Criteria for Vintage Year


        waitFor(customDataDownloadPage.previewdata);
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.filtercriteria.get(6));
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.vintageyearssearch);
        click(customDataDownloadPage.vintageyearssearch);

        waitFor(customDataDownloadPage.namenumber.get(0));
        click(customDataDownloadPage.namenumber.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
// Check Program Filtering

        click(customDataDownloadPage.filtercriteria.get(0));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Check Account Type Filtering

        click(customDataDownloadPage.filtercriteria.get(1));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

    }

}