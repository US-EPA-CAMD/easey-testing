package tests.UITests.CAMPD.datateersSmokeTests.Home;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Navigation extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

// Click Resources
        waitFor(campdElements.resources);
        click(campdElements.resources);
        // click glossary
        waitFor(campdElements.glossary);
        verifyTrue((campdElements.glossary).getAttribute("href").contains("/resources/glossary"));

        // click related resources
        waitFor(campdElements.resourceslinks);
        verifyTrue((campdElements.resourceslinks).getAttribute("href").contains("/resources/related-resources"));
// Click help/support

        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
        // click tutorials
        waitFor(campdElements.aboutlink);
        verifyTrue((campdElements.aboutlink).getAttribute("href").contains("/help-support/about"));

        waitFor(campdElements.contactuslink);
        verifyTrue((campdElements.contactuslink).getAttribute("href").contains("https://www.epa.gov/airmarkets/forms/campd-contact-us"));

        // click tutorials
        waitFor(campdElements.faqlink);
        verifyTrue((campdElements.faqlink).getAttribute("href").contains("/help-support/faqs"));

        // click tutorials
        waitFor(campdElements.tutorialslink);
        verifyTrue((campdElements.tutorialslink).getAttribute("href").contains("/help-support/tutorials"));

// Click data
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);
        // click datahome
        waitFor(campdElements.datahome);
        verifyTrue((campdElements.datahome).getAttribute("href").contains("/data"));
        // Click cdd
        waitFor(campdElements.datadownload);
        verifyTrue((campdElements.datadownload).getAttribute("href").contains("/data/custom-data-download"));
        // click bulk data
        waitFor(campdElements.bulkdata);
        verifyTrue((campdElements.bulkdata).getAttribute("href").contains("/data/bulk-data-files"));

        // click camAPI
        waitFor(campdElements.camapi);
        verifyTrue((campdElements.camapi).getAttribute("href").contains("https://www.epa.gov/airmarkets/cam-api-portal"));



    }

}