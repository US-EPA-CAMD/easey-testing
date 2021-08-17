package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_View_Method_Modal extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        input(monitoringPlansPage.filterByKeywordBox,"Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        click(monitoringPlansPage.facilityCaretBarry);

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");

        verifyEquals(monitoringPlansPage.closeModal, "Close");
        click(monitoringPlansPage.closeModal);

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

        click(monitoringPlansPage.viewButton.get(0));

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");

        click(monitoringPlansPage.xOutModal);

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

    }
}
