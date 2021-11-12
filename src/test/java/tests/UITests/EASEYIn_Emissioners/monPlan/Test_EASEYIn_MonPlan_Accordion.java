package tests.UITests.EASEYIn_Emissioners.monPlan;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_MonPlan_Accordion extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

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

        waitFor(monitoringPlansPage.monPlanActionsHeader);
        verifyEquals(monitoringPlansPage.monPlanActionsHeader, "Actions");
        verifyTrue(isDisplayed(monitoringPlansPage.monPlanActionsHeader));

        click(monitoringPlansPage.accordionCollapseButtonMonPlan);

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanActionsHeader));

        waitFor(monitoringPlansPage.accordionExpandButtonMonPlan);
        click(monitoringPlansPage.accordionExpandButtonMonPlan);

        waitFor(monitoringPlansPage.monPlanActionsHeader);
        verifyEquals(monitoringPlansPage.monPlanActionsHeader, "Actions");
        verifyTrue(isDisplayed(monitoringPlansPage.monPlanActionsHeader));

    }
}
