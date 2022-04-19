package tests.UI_Smoke_Tests.Datateers.Resources;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Glossary extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.resources);
        click(campdElements.resources);

        waitFor(campdElements.glossary);
        click(campdElements.glossary);
        // Click Data Button

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/glossary");
        jse.executeScript("scroll(0, 500);");

        //
        waitFor(campdElements.glossarylink.get(0));
        click(campdElements.glossarylink.get(0));

        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        driver.get("chrome://downloads");

        // get the latest downloaded file name
        String fileName = (String) jse.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");

        System.out.println(fileName);

        String fileconfirm = ".xlsx";

        verifyTrue(fileName.contains(fileconfirm));
// Test for second button
        goTo("https://campd-dev.app.cloud.gov");

        waitFor(campdElements.resources);
        click(campdElements.resources);

        waitFor(campdElements.glossary);
        click(campdElements.glossary);
        // Click Data Button

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/glossary");
        jse.executeScript("scroll(0, 500);");

        //
        waitFor(campdElements.glossarylink.get(1));
        click(campdElements.glossarylink.get(1));

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://api.epa.gov/easey/dev/content-mgmt/campd/resources/glossary/CAMPD-Glossary.pdf");

    }
}