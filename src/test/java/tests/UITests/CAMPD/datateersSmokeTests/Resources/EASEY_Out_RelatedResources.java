package tests.UITests.CAMPD.datateersSmokeTests.Resources;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class EASEY_Out_RelatedResources extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        waitFor(campdElements.hometitle);
// Click Resources
        waitFor(campdElements.resources);
        click(campdElements.resources);

// Click Resources
        waitFor(campdElements.resourceslinks);
        click(campdElements.resourceslinks);

// Change to Related Resources Page

        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://campd.epa.gov/resources/related-resources");

        waitFor(campdElements.pagetitle);

// Select AirData Resources
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        verifyTrue((campdElements.rrlink.get(0)).getAttribute("href").contains("https://www.epa.gov/outdoor-air-quality-data"));
        verifyTrue((campdElements.rrlink.get(1)).getAttribute("href").contains("https://www.epa.gov/castnet"));
        verifyTrue((campdElements.rrlink.get(2)).getAttribute("href").contains("https://www.epa.gov/egrid"));
        jse.executeScript("scroll(0, 500);");

        verifyTrue((campdElements.rrlink.get(3)).getAttribute("href").contains("https://www.eia.gov/environment/"));
        verifyTrue((campdElements.rrlink.get(4)).getAttribute("href").contains("https://www.epa.gov/air-trends"));
        verifyTrue((campdElements.rrlink.get(5)).getAttribute("href").contains("https://nadp.slh.wisc.edu/"));
        jse.executeScript("scroll(0, 500);");

        verifyTrue((campdElements.rrlink.get(6)).getAttribute("href").contains("https://www.epa.gov/air-emissions-inventories"));
        verifyTrue((campdElements.rrlink.get(7)).getAttribute("href").contains("https://www3.epa.gov/airmarkets/progress/reports/index.html"));
        verifyTrue((campdElements.rrlink.get(8)).getAttribute("href").contains("https://www.epa.gov/ghgemissions"));

    }
}

