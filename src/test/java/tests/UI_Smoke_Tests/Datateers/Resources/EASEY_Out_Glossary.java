package tests.UI_Smoke_Tests.Datateers.Resources;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class EASEY_Out_Glossary extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd.epa.gov");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        waitFor(campdElements.resources);
        click(campdElements.resources);

        waitFor(campdElements.glossary);
        click(campdElements.glossary);
        // Click Data Button

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/resources/glossary");
        jse.executeScript("scroll(0, 1000);");

        //
        waitFor(campdElements.glossarylink.get(0));
        click(campdElements.glossarylink.get(0));


// Test for second button

        //
        waitFor(campdElements.glossarylink.get(1));
        click(campdElements.glossarylink.get(1));


    }
}