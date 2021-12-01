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


public class TC_483_Accordion extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov/help-support/about-campd");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
        waitFor(customDataDownloadPage.abouttitle);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 2000)");
        click(customDataDownloadPage.accordion);

        jse.executeScript("scroll(0, -2000);");

        jse.executeScript("scroll(0, 2000);");

        click(customDataDownloadPage.accordion);


    }
}

