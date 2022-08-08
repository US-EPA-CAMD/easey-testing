package tests.UI_Smoke_Tests.Datateers.HelpSupport;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_FAQ extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.hometitle);
// Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
// click contact us
        waitFor(campdElements.faqlink);
        click(campdElements.faqlink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/help-support/faqs");

// Test Tutorials Link
        waitFor(campdElements.faqslinks.get(0));
        verifyTrue((campdElements.faqslinks.get(0)).getAttribute("href").contains("https://campd.epa.gov/help-support/tutorials"));
        verifyTrue((campdElements.faqslinks.get(1)).getAttribute("href").contains("https://www.epa.gov/airmarkets/forms/campd-contact-us"));

// Test Accordions

        jse.executeScript("scroll(0, 600);");

        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"true");
        waitFor(campdElements.accordion.get(0));
        click(campdElements.accordion.get(0));

        verifyEquals(campdElements.accordion.get(0).getAttribute("aria-expanded"),"false");

    }
}

