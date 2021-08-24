package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_Keep_state_of_facilities_among_tabs_in_Mon_Plans extends UITestBase {

    @Test
    public void tests () {

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

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

        waitFor(monitoringPlansPage.accordionSystemsLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.accordionSystemsLabel));
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

        verifyEquals(monitoringPlansPage.selectConfigurationsButton, "Select Configurations");
        click(monitoringPlansPage.selectConfigurationsButton);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox,"Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        click(monitoringPlansPage.facilityCaretBarry);

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        click(monitoringPlansPage.configOpenButton.get(1));

        waitFor(driver -> monitoringPlansPage.configTabs.size() > 1);
        click(monitoringPlansPage.configTabs.get(1));

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        waitFor(monitoringPlansPage.accordionSystemsLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.accordionSystemsLabel));
        verifyEquals(monitoringPlansPage.accordionSystemsLabel, "Systems");

    }
}
