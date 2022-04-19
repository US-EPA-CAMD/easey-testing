package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.campdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_535_Glossary extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov");
        Actions action = new Actions(driver);
        campdElements campdElements = new campdElements(driver);

        waitFor(campdElements.hometitle);

//navigate to the CAMPD FAQ Page

        // Click help and support
        waitFor(campdElements.resources);
        click(campdElements.resources);

        waitFor(campdElements.glossary);
        click(campdElements.glossary);

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd-dev.app.cloud.gov/resources/glossary");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 400);");

        waitFor(campdElements.downloadbutton.get(0));
        click(campdElements.downloadbutton.get(0));


        waitFor(campdElements.downloadbutton.get(1));
        click(campdElements.downloadbutton.get(1));






    }
}

