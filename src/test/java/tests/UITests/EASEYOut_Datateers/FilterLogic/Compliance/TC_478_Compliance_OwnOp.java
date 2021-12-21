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


public class TC_478_Compliance_OwnOp extends UITestBase {
    @Test
    public void test() {

//Navigate to Easey In

        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(3));
        click(customDataDownloadPage.dataoption.get(3));

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        jse.executeScript("scroll(0, 500)");

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);
//Select and Owner Operator


        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(2));
        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.accountNameSearch);
        click(customDataDownloadPage.accountNameSearch);

        waitFor(customDataDownloadPage.namenumber.get(0));
        click(customDataDownloadPage.namenumber.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// Check Program Filtering
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Change to Allowance Holdings Subtype
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);
//Select and Owner Operator


        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(2));
        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.accountNameSearch);
        click(customDataDownloadPage.accountNameSearch);

        waitFor(customDataDownloadPage.namenumber.get(0));
        click(customDataDownloadPage.namenumber.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// Check Program Filtering
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
    }

}