package tests.UITests.EASEYIn_Emissioners.monPlan.systems.components.analyzerRanges;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_949_View_Analyzer_Ranges_Modal extends UITestBase {

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

        click(monitoringPlansPage.monitoringSystems);

        waitFor(monitoringPlansPage.accordionSystemsLabel);
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

        //Location CS0AAN
        click(monitoringPlansPage.location.get(2));
        verifyTrue(monitoringPlansPage.location.get(2).isSelected());

        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "System: AA2");

        waitFor(monitoringPlansPage.systemFuelFlowsHeader);

        verifyEquals(monitoringPlansPage.systemComponentsHeader, "System Components");

        verifyEquals(monitoringPlansPage.viewButtonSystemComponents.get(0).getText(), "View");
        click(monitoringPlansPage.viewButtonSystemComponents.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalSysSecondTableHeaderLabel, "Component: AA7");

        waitFor(monitoringPlansPage.monPlanAnalyzerRangesHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanAnalyzerRangesHeaderLabel, "Analyzer Ranges");

        waitFor(driver -> monitoringPlansPage.analyzerRangesViewButton.size() > 0);
        verifyEquals(monitoringPlansPage.analyzerRangesViewButton.get(0).getText(), "View");

        // Clicking on the View button is not implemented at this time

    }
}
