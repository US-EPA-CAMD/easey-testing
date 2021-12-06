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


public class TC_498_Contact_Us extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        waitFor(customDataDownloadPage.hometitle);
// Click help and support
        waitFor(customDataDownloadPage.navitem);
        click(customDataDownloadPage.navitem);
// click contact us
        waitFor(customDataDownloadPage.contactuslink);
        click(customDataDownloadPage.contactuslink);
 // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");

        waitFor(customDataDownloadPage.pagetitle);

//   Fill out form

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);");

        waitFor(customDataDownloadPage.email);
        input(customDataDownloadPage.email, "maeganwood@cvpcorp.com");
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.contactradio);
        click(customDataDownloadPage.contactradio);
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.comment);
        input(customDataDownloadPage.comment, "This is an Automated Test by Maegan Wood");
        jse.executeScript("scroll(0, 600);");
        waitFor(customDataDownloadPage.contactsubmit);
        click(customDataDownloadPage.contactsubmit);


//navigate to the CAMPD FAQ Page

        // Click help and support
        waitFor(customDataDownloadPage.navitem);
        click(customDataDownloadPage.navitem);
        // click contact us
        waitFor(customDataDownloadPage.faqlink);
        click(customDataDownloadPage.faqlink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/faqs");

        waitFor(customDataDownloadPage.pagetitle);
        // Click help and support
        waitFor(customDataDownloadPage.navitem);
        click(customDataDownloadPage.navitem);
        // click contact us
            waitFor(customDataDownloadPage.contactuslink);
            click(customDataDownloadPage.contactuslink);
            // verify page location

            changeTab();

            verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");

            waitFor(customDataDownloadPage.pagetitle);

//navigate to the CAMPD Tutorials page

        // Click help and support
        waitFor(customDataDownloadPage.navitem);
        click(customDataDownloadPage.navitem);
        // click contact us
        waitFor(customDataDownloadPage.tutorialslink);
        click(customDataDownloadPage.tutorialslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");

        waitFor(customDataDownloadPage.pagetitle);
        // Click help and support
        waitFor(customDataDownloadPage.navitem);
        click(customDataDownloadPage.navitem);
        // click contact us
        waitFor(customDataDownloadPage.contactuslink);
        click(customDataDownloadPage.contactuslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");

        waitFor(customDataDownloadPage.pagetitle);

    }
}

