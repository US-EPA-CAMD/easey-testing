package tests.UITests.EASEYIn_Emissioners.monPlan.defaults;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC406_View_MP_Defaults_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Cross");
        click(monitoringPlansPage.filterByKeywordButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Clicks on Cross (Oris Code 113)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.titleOfFacilityInConfig);
        verifyEquals(monitoringPlansPage.titleOfFacilityInConfig, "Cross");

        js.executeScript("window.scrollBy(0,250)", "");
        js.executeScript("document.body.style.zoom = '0.8'");

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringDefaults);
        click(monitoringPlansPage.monitoringDefaults);

        click(monitoringPlansPage.location.get(0));
        verifyEquals(monitoringPlansPage.location.get(0), "1");

        waitFor(monitoringPlansPage.accordionDefaultsLabel);
        verifyEquals(monitoringPlansPage.accordionDefaultsLabel, "Defaults");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 2);
        js.executeScript("arguments[0].click();", monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Default");

    }
}