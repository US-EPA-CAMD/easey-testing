package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_483_Accordion extends UITestBase {
    @Test
    public void test() {

        // Navigate to EASEY In

        goTo("https://campd-dev.app.cloud.gov/help-support/about-campd");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);
        waitFor(campdElements.pagetitle);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 2000)");
        click(campdElements.accordion.get(0));

        jse.executeScript("scroll(0, -2000);");

        jse.executeScript("scroll(0, 2000);");

        click(campdElements.accordion.get(0));

        verifyTrue(campdElements.accordion.get(0).isEnabled());


    }
}

