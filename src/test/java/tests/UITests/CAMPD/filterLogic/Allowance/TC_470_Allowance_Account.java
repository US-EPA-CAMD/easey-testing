package tests.UITests.CAMPD.filterLogic.Allowance;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_470_Allowance_Account extends UITestBase {
    @Test
    public void test() {

        // Navigate to CAMPD

        goTo("https://campd-dev.app.cloud.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Navigate to Custom Data Download
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

        waitFor(campdElements.datadownload);
        click(campdElements.datadownload);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/data/custom-data-download");

        // Select Allowance Data Type
        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(2));
        click(campdElements.dataoption.get(2));

        // Select Account Info Subtype
        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
        //Apply Account Info  Subtype

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        // Apply Account Type Logic

        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Check Program Filtering

        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allowance Holdings
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        waitFor(campdElements.subtypeoption.get(2));
        click(campdElements.subtypeoption.get(2));
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);
        // Apply Account Type Logic

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(campdElements.filtercriteria.get(1));
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Check Program Filtering

        click(campdElements.filtercriteria.get(0));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allowance Transactions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        waitFor(campdElements.subtypeoption.get(3));
        click(campdElements.subtypeoption.get(3));
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);




        // Apply date

        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datestart);
        click(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        waitFor(campdElements.dateend);
        click(campdElements.dateend);
        input(campdElements.dateend, "01/01/2020");

        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        {
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        // Apply Account Filter
        waitFor(campdElements.filtercriteria.get(2));
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.label.get(0));
        click(campdElements.label.get(0));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(1));
        click(campdElements.cancelApply.get(1));

        // Check Program Filtering

        click(campdElements.filtercriteria.get(1));

        for (WebElement ele : campdElements.label) {
            verifyTrue(ele.isEnabled());
            if (ele.isEnabled())
                click(ele);
        }        jse.executeScript("scroll(0, 1000);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));




    }
}