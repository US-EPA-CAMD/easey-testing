package tests.UITests.EASEYIn_Emissioners.generalTests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_MonPlan_MethodsAndSystems extends UITestBase {

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
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        verifyFalse(isDisplayed(monitoringPlansPage.accordionSystemsLabel));

        click(monitoringPlansPage.sectionsDropdown);

        click(monitoringPlansPage.monitoringSystems);

        verifyTrue(isDisplayed(monitoringPlansPage.accordionSystemsLabel));
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

    }
}
