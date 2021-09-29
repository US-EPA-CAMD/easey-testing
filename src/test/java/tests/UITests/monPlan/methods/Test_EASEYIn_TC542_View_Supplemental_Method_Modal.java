package tests.UITests.monPlan.methods;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC542_View_Supplemental_Method_Modal extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        input(monitoringPlansPage.filterByKeywordBox,"Dolet Hills Power Station");
        click(monitoringPlansPage.filterByKeywordButton);

        click(monitoringPlansPage.facilityCaretFirst);

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionSupplementalMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionSupplementalMethodsLabel, "Supplemental Methods");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(8).getText(), "View");
        click(monitoringPlansPage.viewButton.get(8));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Component: Monitoring MATS Methods");

        verifyEquals(monitoringPlansPage.closeModal, "Close");
        click(monitoringPlansPage.closeModal);

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

        click(monitoringPlansPage.viewButton.get(8));

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Component: Monitoring MATS Methods");

        click(monitoringPlansPage.xOutModal);

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

    }
}
