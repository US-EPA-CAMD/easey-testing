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


        waitFor(customDataDownloadPage.emissionsBtn);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");
        click(customDataDownloadPage.emissionsBtn.get(0));
// Navigate to the Emissions Custom Data Download page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/manage-data-download");
//Select HourlyEmissions Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// apply date range

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));


 //SELECT DAILY  SUBTYPE

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);
// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
 // APPLY MONTHLY EMISSIONS SUBTYPE

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
//Select Quartetly Emissions Syubtype

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(4));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//Select Ozone Season Emissions Syubtype

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(5));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
// Select Annual Emmisions

        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(6));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
// Select Unit/Fuel Type


        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(7));

        click(customDataDownloadPage.applyBtn);

// apply date range

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));
        ;

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check fuel Type Filtering

        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(5));


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

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

        // select fuel type

        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));


        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));

//  make sure program data is filtering

        click(customDataDownloadPage.filtercriteria.get(1));

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
        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Unit Type Filtering

        click(customDataDownloadPage.filtercriteria.get(4));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Filtering

        click(customDataDownloadPage.filtercriteria.get(6));

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

        jse.executeScript("scroll(0, 1000);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Remove Fuel Type Filter

        waitFor(customDataDownloadPage.filtercriteria.get(5));
        click(customDataDownloadPage.filtercriteria.get(5));


        waitFor(customDataDownloadPage.label.get(0));
        click(customDataDownloadPage.label.get(0));

        waitFor(customDataDownloadPage.cancelApply.get(1));
        click(customDataDownloadPage.cancelApply.get(1));
        }
     }

