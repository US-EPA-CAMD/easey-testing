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
public class TC_525_Emissions_Update_Facility_Year_CDD extends UITestBase {

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

        waitFor(customDataDownloadPage.subtypeoption.get(6));
        click(customDataDownloadPage.subtypeoption.get(6));
//Select HourlyEmissions Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// apply Incorrect Date Range

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "1981");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.warningmessage);
        verifyEquals(customDataDownloadPage.warningmessage.getText(), "Enter year(s) 1980, 1985, 1990, or a year between 1995 and the quarter ending on 12/31/2021");
// apply Correct date range:1980


        waitFor(customDataDownloadPage.yearinput);
        customDataDownloadPage.yearinput.clear();
        input(customDataDownloadPage.yearinput, "1980");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
    }
}
