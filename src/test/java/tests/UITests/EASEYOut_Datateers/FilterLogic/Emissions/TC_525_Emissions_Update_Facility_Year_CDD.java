package tests.UITests.EASEYOut_Datateers.FilterLogic.Emissions;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class TC_525_Emissions_Update_Facility_Year_CDD extends UITestBase {

    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(6));
        click(campdElements.subtypeoption.get(6));
//Select HourlyEmissions Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// apply Incorrect Date Range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "1981");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.warningmessage);
        verifyEquals(campdElements.warningmessage.getText(), "Enter year(s) 1980, 1985, 1990, or a year between 1995 and the quarter ending on 12/31/2021");
// apply Correct date range:1980


        waitFor(campdElements.yearinput);
        campdElements.yearinput.clear();
        input(campdElements.yearinput, "1980");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);
    }
}
