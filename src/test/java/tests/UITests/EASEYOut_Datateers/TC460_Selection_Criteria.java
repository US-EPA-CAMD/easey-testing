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


public class TC460_Selection_Criteria extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov/select-data-type");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
        waitFor(customDataDownloadPage.emissionsBtn);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);");
        click(customDataDownloadPage.emissionsBtn.get(0));
// Navigate to the Emissions Custom Data Download page
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Select  Facility/Unit Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(7));
        click(customDataDownloadPage.subtypeoption.get(7));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// apply date range

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

        // Apply Facility Logic

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(7));
        click(customDataDownloadPage.filtercriteria.get(7));

        waitFor(customDataDownloadPage.sourcesearch);
        click(customDataDownloadPage.sourcesearch);

        waitFor(customDataDownloadPage.searchoptions.get(0));
        click(customDataDownloadPage.searchoptions.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// Check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(7));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(1));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Type Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(customDataDownloadPage.filtercriteria.get(5));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


    }

}