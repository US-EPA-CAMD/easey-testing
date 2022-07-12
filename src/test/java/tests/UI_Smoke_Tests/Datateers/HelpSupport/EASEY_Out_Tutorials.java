package tests.UI_Smoke_Tests.Datateers.HelpSupport;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Tutorials extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd.epa.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.hometitle);
// Click help and support
        waitFor(campdElements.helpsupport);
        click(campdElements.helpsupport);
// click tutorials
        waitFor(campdElements.tutorialslink);
        click(campdElements.tutorialslink);
        // verify page location

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/help-support/tutorials");

        waitFor(campdElements.pagetitle);

// Test First Paragraph Links

// Test FAQS Link
        waitFor(campdElements.firstparalinks.get(0));
        verifyTrue((campdElements.firstparalinks.get(0)).getAttribute("href").contains("https://campd.epa.gov/help-support/faqs"));
        verifyTrue((campdElements.firstparalinks.get(1)).getAttribute("href").contains("https://www.epa.gov/airmarkets/forms/campd-contact-us"));


 // CDD PDF
        jse.executeScript("scroll(0, 600);");
        waitFor(campdElements.tutorialspdfs.get(0));
        verifyTrue((campdElements.tutorialspdfs.get(0)).getAttribute("href").contains("https://api.epa.gov/easey/content-mgmt/campd/documents/CustomDataDownload-QuickStartGuide.pdf"));
        verifyTrue((campdElements.tutorialspdfs.get(1)).getAttribute("href").contains("https://www.epa.gov/airmarkets/allowance-data"));
        jse.executeScript("scroll(0, 600);");
        verifyTrue((campdElements.tutorialspdfs.get(2)).getAttribute("href").contains("https://www.epa.gov/airmarkets/power-sector-emissions-data"));
        jse.executeScript("scroll(0, 600);");
        verifyTrue((campdElements.tutorialspdfs.get(3)).getAttribute("href").contains("https://api.epa.gov/easey/content-mgmt/campd/documents/data_caveats_5_3_2022.xlsx"));
        verifyTrue((campdElements.tutorialspdfs.get(4)).getAttribute("href").contains("https://www.epa.gov/airmarkets/monitoring-insights"));

        verifyTrue((campdElements.tutorialspdfs.get(5)).getAttribute("href").contains("https://www.epa.gov/airmarkets/power-sector-data-crosswalk"));
        jse.executeScript("scroll(0, 600);");


    }
}

