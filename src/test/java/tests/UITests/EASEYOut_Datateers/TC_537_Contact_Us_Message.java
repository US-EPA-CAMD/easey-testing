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


public class TC_537_Contact_Us_Message extends UITestBase {
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

//   Submit without filling out form

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");

        waitFor(customDataDownloadPage.contactsubmit);
        click(customDataDownloadPage.contactsubmit);

        waitFor(customDataDownloadPage.contactusalert);
        verifyEquals(customDataDownloadPage.contactusalert.getText(),"All fields are required. Please fill in the form completely and try again.");

// Reload, submit properly
        goTo("https://campd-dev.app.cloud.gov/help-support/contact-us");

        jse.executeScript("scroll(0, 250);");

        waitFor(customDataDownloadPage.email);
        input(customDataDownloadPage.email, "maeganwood@cvpcorp.com");
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.contactradio);
        click(customDataDownloadPage.contactradio);
        jse.executeScript("scroll(0, 250);");
        waitFor(customDataDownloadPage.comment);
        input(customDataDownloadPage.comment, "This is an Automated Test by Maegan Wood");
        jse.executeScript("scroll(0, 700);");

        waitFor(customDataDownloadPage.contactsubmit);
        click(customDataDownloadPage.contactsubmit);

        waitFor(customDataDownloadPage.contactusalert);
        verifyEquals(customDataDownloadPage.contactusalert.getText(),"Success! You will be sent a confirmation email within the next 24 hours. If you do not receive a notification, please resubmit your issue, reach out to the Clean Air Markets Division hotline at 202-343-9620, or email campd-support@camdsupport.com directly.");


    }
}
