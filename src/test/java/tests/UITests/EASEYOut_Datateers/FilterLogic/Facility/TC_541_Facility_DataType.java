package tests.UITests.EASEYOut_Datateers.FilterLogic.Facility;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_541_Facility_DataType extends UITestBase {
    @Test
    public void test() {


        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(4));
        click(customDataDownloadPage.dataoption.get(4));

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);

        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        int filters = customDataDownloadPage.filtercriteria.size();

        System.out.println(filters);


    }

}
