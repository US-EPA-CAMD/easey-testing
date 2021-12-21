package tests.UI_Smoke_Tests.Emissioners;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

/*
This test verifies that the application successfully opens
 */

public class Test_EASEYIn_SMK_MonPlanPage extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Verifying that the page has opened and the title is visible
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.title);
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

    }
}
