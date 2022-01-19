package tests.UITests.EASEYIn_Emissioners.monPlan.loads;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC405_View_MP_Load_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.title);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox,"Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));
        js.executeScript("window.scrollBy(0,250)", "");

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        js.executeScript("window.scrollBy(0,250)", "");

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringLoads);
        click(monitoringPlansPage.monitoringLoads);

        waitFor(monitoringPlansPage.accordionLoadsLabel);
        verifyEquals(monitoringPlansPage.accordionLoadsLabel, "Loads");

        click(monitoringPlansPage.location.get(2));
        verifyEquals(monitoringPlansPage.location.get(2), "CS0AAN");

        js.executeScript("document.body.style.zoom = '0.6'");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        js.executeScript("arguments[0].click();", monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Load");
        js.executeScript("arguments[0].click();", monitoringPlansPage.closeModal);

        js.executeScript("document.body.style.zoom = '1'");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.menuBtn);
        click(monitoringPlansPage.closeConfigTab.get(0));
        waitFor(monitoringPlansPage.selectConfigurationsLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.selectConfigurationsLabel));

    }
}