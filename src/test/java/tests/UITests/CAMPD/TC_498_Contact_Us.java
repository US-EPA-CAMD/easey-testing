package tests.UITests.CAMPD;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_498_Contact_Us extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

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

//   Fill out form

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 250);");

        waitFor(campdElements.email);
        input(campdElements.email, "maeganwood@cvpcorp.com");
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.contactradio);
        click(campdElements.contactradio);
        jse.executeScript("scroll(0, 250);");
        waitFor(campdElements.comment);
        input(campdElements.comment, "This is an Automated Test by Maegan Wood");
        jse.executeScript("scroll(0, 600);");
        waitFor(campdElements.contactsubmit);
        click(campdElements.contactsubmit);


//navigate to the CAMPD FAQ Page

        // Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click contact us
        waitFor(campdElements.faqlink);
        click(campdElements.faqlink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/faqs");

        waitFor(campdElements.pagetitle);
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

//navigate to the CAMPD Tutorials page

        // Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click contact us
        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/tutorials");

        waitFor(campdElements.pagetitle);
        // Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click contact us
        waitFor(campdElements.contactuslink);
        click(campdElements.contactuslink);
        // verify page location

        changeTab();
        waitFor(campdElements.pagetitle);
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/help-support/contact-us");



    }
}

