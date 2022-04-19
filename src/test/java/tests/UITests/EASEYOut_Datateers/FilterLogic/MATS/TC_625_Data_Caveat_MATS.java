package tests.UITests.EASEYOut_Datateers.FilterLogic.MATS;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_625_Data_Caveat_MATS extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(5));
        click(campdElements.dataoption.get(5));

 // Verify Alert is there

        waitFor(campdElements.alert);
        verifyEquals(campdElements.alert.getText(),"MATS required that coal-fired electricity generating units (EGUs) start reporting hourly MATS emissions and operations data as early as April 2015, but provided extensions for many EGUs until April 2016 or 2017. Therefore, complete MATS data are not available until calendar year 2018.");


//Select HourlyEmissions Subtype
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.subtypeDropdown);
        verifyFalse(campdElements.subtypeDropdown.isEnabled());








    }
}

