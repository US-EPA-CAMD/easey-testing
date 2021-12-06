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


public class TC457_Facility_Filter_logic extends UITestBase {
    @Test
    public void test() {

 // Navigate to EASEY IN

        goTo("https://campd-dev.app.cloud.gov/select-data-type");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
        waitFor(customDataDownloadPage.emissionsBtn);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");
        click(customDataDownloadPage.emissionsBtn.get(0));

// Navigate to the Emissions Custom Data Download page
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Select HourlyEmissions Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);

// apply date range

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

 // Apply Facility Logic

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(3));
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.facilitiesSearch);
        click(customDataDownloadPage.facilitiesSearch);

        waitFor(customDataDownloadPage.searchoptions.get(0));
        click(customDataDownloadPage.searchoptions.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(3));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// SELECT DAILY SUBTYPE
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
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

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

        // APPLY MONTHLY EMISSIONS SUBTYPE

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
        // Apply Facility Logic

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(3));
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.facilitiesSearch);
        click(customDataDownloadPage.facilitiesSearch);

        waitFor(customDataDownloadPage.searchoptions.get(0));
        click(customDataDownloadPage.searchoptions.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(3));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// SELECT Quarterly  SUBTYPE
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(4));


        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
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

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//Select Ozone Emissions Syubtype

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(5));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
        // Apply Facility Logic

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(3));
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.facilitiesSearch);
        click(customDataDownloadPage.facilitiesSearch);

        waitFor(customDataDownloadPage.searchoptions.get(0));
        click(customDataDownloadPage.searchoptions.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(3));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// SELECT Annual SUBTYPE
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(6));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));


        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
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

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// Select Unit/Fuel SUBTYPE


        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(7));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

        // Apply Facility Logic

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(3));
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.facilitiesSearch);
        click(customDataDownloadPage.facilitiesSearch);

        waitFor(customDataDownloadPage.searchoptions.get(0));
        click(customDataDownloadPage.searchoptions.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(3));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));




    }
}

