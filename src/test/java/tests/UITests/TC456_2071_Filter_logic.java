package tests.UITests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC456_2071_Filter_logic extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov/select-data-type");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        verifyEquals(customDataDownloadPage.title, "Custom Data Download");

        click(customDataDownloadPage.emissionsBtn);
// Navigate to the Emissions Custom Data Download page

        changeTab();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Select Emissions Subtype
        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.hourlyemissions.get(1));

        click(customDataDownloadPage.applyBtn);
        //apply filter criteria

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);


// apply date range
        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

// check Unit Type Filtering

        click(customDataDownloadPage.fuelType);

        for(WebElement webElement : customDataDownloadPage.checkbox) {
            boolean myBool=webElement.isEnabled();

            if(myBool=true){

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()",webElement);

            }
            else{

                continue;
            }

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.fuelType);

        // select fuel type
        click(customDataDownloadPage.fuelType);


        waitFor(customDataDownloadPage.fuelTypeCoal);
        click(customDataDownloadPage.fuelTypeCoal);

        waitFor(customDataDownloadPage.fuelTypeApplyFilters);
        click(customDataDownloadPage.fuelTypeApplyFilters);



//  make sure program data is filtering

        click(customDataDownloadPage.program);

        for(WebElement webElement : customDataDownloadPage.checkbox) {
            boolean myBool=webElement.isEnabled();

            if(myBool=true){

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()",webElement);

            }
            else{

                continue;
            }

        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        click(customDataDownloadPage.program);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.program);

// check Unit Type Filtering

        click(customDataDownloadPage.unitType);

        for(WebElement webElement : customDataDownloadPage.checkbox) {
            boolean myBool=webElement.isEnabled();

            if(myBool=true){

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()",webElement);

            }
            else{

                continue;
            }

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.unitType);

// check Control Tech Filtering

        click(customDataDownloadPage.controlTech);

        for(WebElement webElement : customDataDownloadPage.checkbox) {
            boolean myBool=webElement.isEnabled();

            if(myBool=true){

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click()",webElement);

            }
            else{

                continue;
            }

        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.controlTech);

// Remove Program Filter

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.fuelType);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        verifyTrue(customDataDownloadPage.fuelTypeCoal.isEnabled());
        click(customDataDownloadPage.fuelTypeCoal);


        waitFor(customDataDownloadPage.fuelTypeApplyFilters);
        click(customDataDownloadPage.fuelTypeApplyFilters);





    }
}


