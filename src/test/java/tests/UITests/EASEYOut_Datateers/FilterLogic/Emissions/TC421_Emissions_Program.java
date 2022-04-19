package tests.UITests.EASEYOut_Datateers.FilterLogic.Emissions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC421_Emissions_Program extends UITestBase {
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

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

//Select HourlyEmissions Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// apply date range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));


// SELECT DAILY SUBTYPE
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

 // APPLY MONTHLY EMISSIONS SUBTYPE

        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(3));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        ;

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

//Select Quartetly Emissions Syubtype

        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(4));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        ;

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));



//Select Ozone Season Emissions Syubtype

        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(5));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        ;

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");


        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// Select Annual Emmisions

        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(6));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        ;

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));


// Select Unit/Fuel SUBTYPE


        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(7));

        click(campdElements.applyBtn);

// apply date range

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));
        ;

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");


        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Filtering

        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(1));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//Select Program

        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

// check Unit Type Filtering

        click(campdElements.filtercriteria.get(4));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  make sure Fuel Type data is filtering

        click(campdElements.filtercriteria.get(5));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Control Tech Filtering

        click(campdElements.filtercriteria.get(6));


        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Remove Program Type Filter

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));


        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

    }
}

