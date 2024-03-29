package tests.UITests.ECMPS.monPlan.systems.components;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1479_View_Component_Modal extends UITestBase {

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

        waitFor(monitoringPlansPage.monitoringSystems);
        click(monitoringPlansPage.monitoringSystems);

        waitFor(monitoringPlansPage.accordionSystemsLabel);
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "System: AF1");

        waitFor(monitoringPlansPage.systemFuelFlowsHeader);

        waitFor(monitoringPlansPage.systemComponentsHeader);
        verifyEquals(monitoringPlansPage.systemComponentsHeader, "System Components");

        waitFor(driver -> monitoringPlansPage.viewButtonSystemComponents.size() > 1);
        verifyEquals(monitoringPlansPage.viewButtonSystemComponents.get(0).getText(), "View");
        click(monitoringPlansPage.viewButtonSystemComponents.get(0));

        waitFor(monitoringPlansPage.monPlanModalSysSecondTableHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalSysSecondTableHeaderLabel, "Component: AFA");

    }
}
