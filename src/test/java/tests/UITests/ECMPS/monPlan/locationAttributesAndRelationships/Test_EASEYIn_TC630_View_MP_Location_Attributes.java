package tests.UITests.ECMPS.monPlan.locationAttributesAndRelationships;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC630_View_MP_Location_Attributes extends UITestBase {

    @Test
    public void test() throws InterruptedException {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

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

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringLocationAttributesAndRelationships);
        click(monitoringPlansPage.monitoringLocationAttributesAndRelationships);

        click(monitoringPlansPage.location.get(2));
        verifyEquals(monitoringPlansPage.location.get(2), "CS0AAN");

        waitFor(monitoringPlansPage.accordionLocationAttributesLabel);
        verifyEquals(monitoringPlansPage.accordionLocationAttributesLabel, "Location Attributes");

        Thread.sleep(3000);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Location Attribute");

    }
}
