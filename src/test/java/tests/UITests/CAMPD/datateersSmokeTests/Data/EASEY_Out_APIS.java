package tests.UITests.CAMPD.datateersSmokeTests.Data;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;

public class EASEY_Out_APIS extends UITestBase  {
    @Test
    public void test() {

// Navigate to CAMPD homepage

        goTo("https://campd.epa.gov/");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        waitFor(campdElements.hometitle);
// Click data menu
        waitFor(campdElements.datamenu);
        click(campdElements.datamenu);

// Click APIS
        waitFor(campdElements.camapi);
        click(campdElements.camapi);
// Verify on API Portal
        changeTab();

        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/airmarkets/cam-api-portal");


    }
}

