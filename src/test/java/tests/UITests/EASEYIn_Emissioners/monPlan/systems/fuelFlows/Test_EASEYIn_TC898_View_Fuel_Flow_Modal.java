package tests.UITests.EASEYIn_Emissioners.monPlan.systems.fuelFlows;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC898_View_Fuel_Flow_Modal extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox,"Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        click(monitoringPlansPage.monitoringSystems);

        waitFor(monitoringPlansPage.accordionSystemsLabel);
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "System: AF1");

        waitFor(monitoringPlansPage.systemFuelFlowsHeader);
        verifyEquals(monitoringPlansPage.systemFuelFlowsHeader, "Fuel Flows");

        verifyEquals(monitoringPlansPage.viewButtonFuelFlow.get(0).getText(), "View");
        click(monitoringPlansPage.viewButtonFuelFlow.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalSysSecondTableHeaderLabel, "Fuel Code: PNG, System Type Code: GAS");

    }
}
