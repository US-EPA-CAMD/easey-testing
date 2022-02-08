package tests.UITests.EASEYOut_Datateers.FilterLogic.Facility;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_541_Facility_DataType extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(4));
        click(campdElements.dataoption.get(4));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);

        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        int filters = campdElements.filtercriteria.size();

        System.out.println(filters);


    }

}
