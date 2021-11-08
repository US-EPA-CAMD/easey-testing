package tests.UITests.EASEYIn_Emissioners.monPlan.unitInformation.unitCapacity;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1722_View_MP_Unit_Capacity_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Gadsden");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Gadsden (Oris Code 7)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        click(monitoringPlansPage.monitoringUnitInformation);
        verifyEquals(monitoringPlansPage.monitoringUnitInformation, "Unit Information");

        waitFor(monitoringPlansPage.accordionUnitCapacitiesLabel);
        verifyEquals(monitoringPlansPage.accordionUnitCapacitiesLabel, "Unit Capacities");

        click(monitoringPlansPage.location.get(0));
        verifyEquals(monitoringPlansPage.location.get(0), "1");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        action.moveToElement(monitoringPlansPage.viewButton.get(1)).click().build().perform();

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Unit Capacity");

    }
}