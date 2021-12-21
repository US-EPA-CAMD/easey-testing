package tests.UITests.EASEYOut_Datateers.FilterLogic.Allowance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC_474_Allowance_Date extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(2));
        click(customDataDownloadPage.dataoption.get(2));

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));
//Apply Transactions Subtype



        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);

// Apply Date Range


        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        click(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        waitFor(customDataDownloadPage.dateend);
        click(customDataDownloadPage.dateend);
        input(customDataDownloadPage.dateend, "01/01/2020");

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

// Check Program Type Filtering
        waitFor(customDataDownloadPage.previewdata);
        waitFor(customDataDownloadPage.filtercriteria.get(1));
        click(customDataDownloadPage.filtercriteria.get(1));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Check Account Type Filtering

        click(customDataDownloadPage.filtercriteria.get(2));

        for (WebElement ele : customDataDownloadPage.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Check Vintage Year
        jse.executeScript("scroll(0, 1000);");
        click(customDataDownloadPage.filtercriteria.get(7));

        waitFor(customDataDownloadPage.accountNameSearch);
        click(customDataDownloadPage.accountNameSearch);

        waitFor(customDataDownloadPage.namenumber.get(0));
        click(customDataDownloadPage.namenumber.get(0));

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

// Change Date Range and cancel
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        click(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        waitFor(customDataDownloadPage.dateend);
        click(customDataDownloadPage.dateend);
        input(customDataDownloadPage.dateend, "01/01/2021");

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));


// Apply cancelled range
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        driver.switchTo().alert().accept();
// Remove from Pill adn then cancel
        waitFor(customDataDownloadPage.modify.get(0));
        waitFor(customDataDownloadPage.remove.get(0));
        click(customDataDownloadPage.remove.get(0));

        driver.switchTo().alert().dismiss();

// Cancel from Pill
        waitFor(customDataDownloadPage.remove.get(0));
        click(customDataDownloadPage.remove.get(0));
        driver.switchTo().alert().accept();
// Apply out of date range
        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        click(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/1985");

        waitFor(customDataDownloadPage.dateend);
        click(customDataDownloadPage.dateend);
        input(customDataDownloadPage.dateend, "01/01/2020");

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));


        waitFor(customDataDownloadPage.alert);
        verifyTrue(customDataDownloadPage.alert.isDisplayed());




    }

}
