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


public class TC_475_Compliance_Program extends UITestBase {
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
        click(customDataDownloadPage.emissionsBtn.get(2));
// Navigate to the Emissions Custom Data Download page
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Apply Allowance  Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

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