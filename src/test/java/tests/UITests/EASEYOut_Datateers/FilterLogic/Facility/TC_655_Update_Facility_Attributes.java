package tests.UITests.EASEYOut_Datateers.FilterLogic.Facility;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_655_Update_Facility_Attributes extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(4));
        click(campdElements.dataoption.get(4));

        jse.executeScript("scroll(0, 250);");
 ;

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        waitFor(campdElements.previewdata);


    }

}
