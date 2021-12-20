package tests.UITests.EASEYOut_Datateers.FilterLogic.Compliance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC_475_Compliance_Program extends UITestBase {
    @Test
    public void test() {

        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(3));
        click(customDataDownloadPage.dataoption.get(3));


//Apply Allowance  Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);
//Select and Apply Filter Critetia for Program

        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
// Check Program Filtering

        click(customDataDownloadPage.filtercriteria.get(0));

        for (WebElement ele : customDataDownloadPage.label) {
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


    }

}