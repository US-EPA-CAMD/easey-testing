package tests.UITests.ECMPS.monPlan.monPlan_SmokeTests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

/*
This test verifies that the user
can successfully get access to the facilities and configurations
logged out Global View.
 */

public class Test_ECMPSUI_SMK_OpenConfiguration_LoggedOut extends UITestBase {

    @Test
    public void test() throws InterruptedException {

//        Navigate to EASEY In
//        https://ecmps-dev.app.cloud.gov/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Verifying that the page has opened and the title is visible
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Selenium does not see the caret icon.
        // This scrolls down so that the caret is visible.
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.title);

//        Using input box to search for desired facility
//        waitFor(monitoringPlansPage.filterByKeywordBox);
//        input(monitoringPlansPage.filterByKeywordBox,"Barry");
//        click(monitoringPlansPage.filterByKeywordButton);

        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 0);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.facilityCaret.get(0));

        // Clicks on Barry (Oris Code 3)
        Thread.sleep(500);
        click(monitoringPlansPage.facilityCaret.get(0));

        // Opens the desired configuration
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        // Clicks on the tab of the configuration
        click(monitoringPlansPage.configTabs.get(0));

        // Verifies that the configuration is open and its default is Methods
        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

    }
}