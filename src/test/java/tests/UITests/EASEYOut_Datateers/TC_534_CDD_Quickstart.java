package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class TC_534_CDD_Quickstart extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        waitFor(customDataDownloadPage.hometitle);

//navigate to the CAMPD FAQ Page

        // Click help and support
        waitFor(customDataDownloadPage.resources);
        click(customDataDownloadPage.navitem);

        waitFor(customDataDownloadPage.tutorialslink);
        click(customDataDownloadPage.tutorialslink);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 400);");

        waitFor(customDataDownloadPage.cddpdf);
        click(customDataDownloadPage.cddpdf);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://api.epa.gov/easey/dev/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf");








    }
}

