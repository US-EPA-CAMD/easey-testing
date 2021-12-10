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
        input(monitoringPlansPage.filterByKeywordBox, "Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        js.executeScript("window.scrollBy(0,250)", "");
        js.executeScript("document.body.style.zoom = '0.8'");

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringDefaults);
        click(monitoringPlansPage.monitoringDefaults);

        waitFor(monitoringPlansPage.accordionDefaultsLabel);
        verifyEquals(monitoringPlansPage.accordionDefaultsLabel, "Defaults");

        click(monitoringPlansPage.location.get(2));
        verifyEquals(monitoringPlansPage.location.get(2), "CS0AAN");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Default");

    }
}