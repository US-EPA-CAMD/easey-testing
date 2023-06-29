package tests.UITests.ECMPS.monPlan.monPlan_SmokeTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

/*
This test verifies that the application successfully opens
 */

public class Test_ECMPSUI_SMK_MonPlanPage extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://ecmps-dev.app.cloud.gov/ecmps/monitoring-plans
//        goTo("https://ecmps-dev.app.cloud.gov/monitoring-plans");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Verifying that the page has opened and the title is visible
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.title);
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

    }
}
