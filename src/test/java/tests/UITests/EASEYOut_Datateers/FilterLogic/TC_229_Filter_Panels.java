package tests.UITests.EASEYOut_Datateers.FilterLogic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;


public class TC_229_Filter_Panels extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
        Dimension dimension = new Dimension(480, 1080);

        driver.manage().window().setSize(dimension);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // apply data type
        waitFor(customDataDownloadPage.mobilefilterbuttons.get(0));
        click(customDataDownloadPage.mobilefilterbuttons.get(0));

        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(1));
        click(customDataDownloadPage.dataoption.get(1));


        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));


        assertFalse(customDataDownloadPage.subtypeDropdown.isSelected());

        jse.executeScript("scroll(0, 350);");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);

        waitFor(customDataDownloadPage.mobilepreviewdata);


        // Apply Filters
        waitFor(customDataDownloadPage.mobilepanelbuttons.get(0));
        click(customDataDownloadPage.mobilepanelbuttons.get(0));

        waitFor(customDataDownloadPage.mobilefilterbuttons.get(1));
        click(customDataDownloadPage.mobilefilterbuttons.get(1));

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

// apply date range

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
 // X out filter with X button

        waitFor(customDataDownloadPage.filtercriteriax);
        click(customDataDownloadPage.filtercriteriax.get(0));

// 640 p
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");

        Dimension dimensions = new Dimension(640, 1080);

        driver.manage().window().setSize(dimensions);


        // apply data type
        waitFor(customDataDownloadPage.mobilefilterbuttons.get(0));
        click(customDataDownloadPage.mobilefilterbuttons.get(0));

        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(1));
        click(customDataDownloadPage.dataoption.get(1));


        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));


        assertFalse(customDataDownloadPage.subtypeDropdown.isSelected());

        jse.executeScript("scroll(0, 350);");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);

        waitFor(customDataDownloadPage.mobilepreviewdata);


        // Apply Filters
        waitFor(customDataDownloadPage.mobilepanelbuttons.get(0));
        click(customDataDownloadPage.mobilepanelbuttons.get(0));

        waitFor(customDataDownloadPage.mobilefilterbuttons.get(1));
        click(customDataDownloadPage.mobilefilterbuttons.get(1));

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

// apply date range

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
        // X out filter with X button
        waitFor(customDataDownloadPage.filtercriteriax);




    }

}