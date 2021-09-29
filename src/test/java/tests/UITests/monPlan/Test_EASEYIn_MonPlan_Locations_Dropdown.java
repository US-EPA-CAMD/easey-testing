package tests.UITests.monPlan;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_MonPlan_Locations_Dropdown extends UITestBase {

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

        // Locations dropdown selection: Location 1 selected
        verifyTrue(monitoringPlansPage.location.get(0).isSelected());

        // Locations dropdown selection: Location 2 not selected
        verifyFalse(monitoringPlansPage.location.get(1).isSelected());
        // Locations dropdown selection: Location CS0AAN not selected
        verifyFalse(monitoringPlansPage.location.get(2).isSelected());

        // Select Location 2
        click(monitoringPlansPage.location.get(1));
        // Locations dropdown selection: Location 2 selected
        verifyTrue(monitoringPlansPage.location.get(1).isSelected());

        // Locations dropdown selection: Location 1 not selected
        verifyFalse(monitoringPlansPage.location.get(0).isSelected());
        // Locations dropdown selection: Location CS0AAN not selected
        verifyFalse(monitoringPlansPage.location.get(2).isSelected());

    }
}
