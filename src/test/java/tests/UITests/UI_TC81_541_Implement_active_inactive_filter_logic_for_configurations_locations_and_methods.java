package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class UI_TC81_541_Implement_active_inactive_filter_logic_for_configurations_locations_and_methods extends UITestBase {

    @Test
    public void test() {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
//        Select one facility from the table by clicking on the Open tab. (Barry AL, Oris Code 3 was mainly used for this test)
        waitFor(driver -> monitoringPlansPage.tableResults.size() > 3);
        String facility = monitoringPlansPage.tableResults.get(0).getText().split("\n")[1];
        click(monitoringPlansPage.tableResults.get(0));
//        A new tab with the name of the selected facility should appear.
        verifyTrue(monitoringPlansPage.tabs.size() == 2);

//        Click on the tab that just appeared, with the name of the desired facility.
        click(monitoringPlansPage.tabs.get(1));
//        The facility’s monitoring plan should appear
        verifyEquals(monitoringPlansPage.facilityTitle, facility);
//
//        The Show Inactive checkbox should be unchecked as its default state.
//        The criteria for this test case is based on the wireframes and the acceptance criteria
        waitFor(monitoringPlansPage.showInactiveCheckbox);
        verifyFalse(monitoringPlansPage.showInactiveCheckbox.isSelected());

//        Click on the Configurations drop down in order to confirm that no Inactive configurations are showing.
        click(monitoringPlansPage.configurationsDropdown);
//        No inactive configurations appear in the dropdown.
        verifyNotDisplayed(monitoringPlansPage.inactiveConfigurations);
//
//        Click on the Show Inactive checkbox
        click(monitoringPlansPage.showInactiveCheckbox);
//
//        A check mark will indicate that the checkbox has been selected
        verifyTrue(monitoringPlansPage.showInactiveCheckbox.isSelected());
//        Click on Configurations dropdown
        click(monitoringPlansPage.configurationsDropdown);
//        The inactive configurations will now appear in the dropdown box.
        verifyTrue(monitoringPlansPage.inactiveConfigurations.isDisplayed());
//
//        Select various configurations of Active and Inactive
//
//        The data in the Locations dropdown and Methods table should reflect the selected configurations (Active/Inactive).
//
//        Only Inactive methods will have an end date.

    }
}
