package tests.UITests.EASEYOut_Datateers.FilterLogic.Emissions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC460_Emissions_Select extends UITestBase {
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

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);


        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));
//Select  Facility/Unit Subtype

        jse.executeScript("scroll(0, 250);");

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
            verifyTrue(ele.isEnabled());
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
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Type Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(customDataDownloadPage.filtercriteria.get(5));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


    }

}