package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_591_Update_Contact_Us_Error_Message extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        waitFor(campdElements.hometitle);
// Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
// click contact us
        waitFor(campdElements.contactuslink);
        click(campdElements.contactuslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");

        waitFor(campdElements.pagetitle);

//   Submit without filling out form

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 1000);");

        waitFor(campdElements.contactsubmit);
        click(campdElements.contactsubmit);

        waitFor(campdElements.contactusalert);
        verifyEquals(campdElements.contactusalert.getText(),"All fields are required. Please fill in the form completely and try again.");

// Reload, submit properly
        goTo("https://campd-dev.app.cloud.gov/help-support/contact-us");

        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.email);
        input(campdElements.email, "maeganwood@cvpcorp.com");
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.contactradio);
        click(campdElements.contactradio);
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.comment);
        input(campdElements.comment, "This is an Automated Test by Maegan Wood");
        jse.executeScript("scroll(0, 700);");

        waitFor(campdElements.contactsubmit);
        click(campdElements.contactsubmit);

        waitFor(campdElements.contactusalert);
        verifyEquals(campdElements.contactusalert.getText(),"Success! You will be sent a confirmation email within the next 24 hours. If you do not receive a notification, please resubmit your issue, reach out to the Clean Air Markets Division hotline at 202-343-9620, or email campd-support@camdsupport.com directly.");


    }
}
