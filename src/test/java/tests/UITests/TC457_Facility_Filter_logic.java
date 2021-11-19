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


public class TC457_Facility_Filter_logic extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov/select-data-type");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitFor(customDataDownloadPage.emissionsBtn);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");
        click(customDataDownloadPage.emissionsBtn);
// Navigate to the Emissions Custom Data Download page

        changeTab();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Select HourlyEmissions Subtype
        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(1));

        click(customDataDownloadPage.applyBtn);


// apply date range


        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

// check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

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

// check Fuel Type Filtering

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

//SELECT DAILY  SUBTYPE
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

        // check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

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

// check Fuel Type Filtering

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

// APPLY MONTHLY EMISSIONS SUBTYPE

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.january);
        click(customDataDownloadPage.january);

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

        // check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

// check Fuel Type Filtering

        jse.executeScript("scroll(0, 250);");
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
        jse.executeScript("scroll(0, 400);");
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
//Select Quartetly Emissions Syubtype

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(4));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.q1);
        click(customDataDownloadPage.q1);

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

        // check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

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

// check Fuel Type Filtering

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

// Select Annual Emmisions

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(6));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

        // check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

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

// check Fuel Type Filtering

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


        // Select Unit/Fuel Type

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(7));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.timeperiod);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.timeperiod);

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.applyfilter);
        click(customDataDownloadPage.applyfilter);

        waitFor(customDataDownloadPage.previewdata);

        // check Facility Filtering


        jse.executeScript("scroll(0, 300);");
        click(customDataDownloadPage.facility);


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        click(customDataDownloadPage.facilityInput);

        // select fuel type
        waitFor(customDataDownloadPage.greencounty);
        click(customDataDownloadPage.greencounty);


        waitFor(customDataDownloadPage.facilityapplyfilters);
        click(customDataDownloadPage.facilityapplyfilters);

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

// check Fuel Type Filtering

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

    }
}


