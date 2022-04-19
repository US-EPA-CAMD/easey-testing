package tests.UITests.EASEYOut_Datateers.FilterLogic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;


public class TC_229_Filter_Panels extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);
        Dimension dimension = new Dimension(480, 1080);

        driver.manage().window().setSize(dimension);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // apply data type
        waitFor(campdElements.mobilefilterbuttons.get(0));
        click(campdElements.mobilefilterbuttons.get(0));

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));


        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));


        assertFalse(campdElements.subtypeDropdown.isSelected());

        jse.executeScript("scroll(0, 350);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        waitFor(campdElements.mobilepreviewdata);


        // Apply Filters
        waitFor(campdElements.mobilepanelbuttons.get(0));
        click(campdElements.mobilepanelbuttons.get(0));

        waitFor(campdElements.mobilefilterbuttons.get(1));
        click(campdElements.mobilefilterbuttons.get(1));

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

// apply date range

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
 // X out filter with X button

        waitFor(campdElements.filtercriteriax);
        click(campdElements.filtercriteriax.get(0));

// 640 p
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");

        Dimension dimensions = new Dimension(640, 1080);

        driver.manage().window().setSize(dimensions);


        // apply data type
        waitFor(campdElements.mobilefilterbuttons.get(0));
        click(campdElements.mobilefilterbuttons.get(0));

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));


        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));


        assertFalse(campdElements.subtypeDropdown.isSelected());

        jse.executeScript("scroll(0, 350);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        waitFor(campdElements.mobilepreviewdata);


        // Apply Filters
        waitFor(campdElements.mobilepanelbuttons.get(0));
        click(campdElements.mobilepanelbuttons.get(0));

        waitFor(campdElements.mobilefilterbuttons.get(1));
        click(campdElements.mobilefilterbuttons.get(1));

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

// apply date range

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
        // X out filter with X button
        waitFor(campdElements.filtercriteriax);




    }

}