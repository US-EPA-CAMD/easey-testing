package tests.UITests.CAMPD;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_534_CDD_Quickstart extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        waitFor(campdElements.hometitle);

//navigate to the CAMPD FAQ Page

        // Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);

        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.tutorialspdfs.get(0));
        click(campdElements.tutorialspdfs.get(0));

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://api.epa.gov/easey/dev/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf");






    }
}

