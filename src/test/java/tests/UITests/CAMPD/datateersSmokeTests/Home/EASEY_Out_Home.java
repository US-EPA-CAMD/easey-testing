package tests.UITests.CAMPD.datateersSmokeTests.Home;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Home extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd.epa.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 1000);");

        // Tutorials
        waitFor(campdElements.whatsnewlink.get(0));
        verifyTrue((campdElements.whatsnewlink.get(0)).getAttribute("href").contains("https://campd.epa.gov/help-support/tutorials"));
        verifyTrue((campdElements.whatsnewlink.get(1)).getAttribute("href").contains("https://api.epa.gov/easey/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf"));
        verifyTrue((campdElements.whatsnewlink.get(2)).getAttribute("href").contains("https://www.epa.gov/airmarkets/forms/campd-contact-us"));
        verifyTrue((campdElements.whatsnewlink.get(3)).getAttribute("href").contains("https://lp.constantcontactpages.com/su/SmTSbfJ"));


        // Click Data Home Page Button

        waitFor(campdElements.homepageData);
        click(campdElements.homepageData);

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/data/custom-data-download");



    }
}

