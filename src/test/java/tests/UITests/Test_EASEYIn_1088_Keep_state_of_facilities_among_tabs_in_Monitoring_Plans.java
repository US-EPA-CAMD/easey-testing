package tests.UITests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_1088_Keep_state_of_facilities_among_tabs_in_Monitoring_Plans extends UITestBase {

    @Test
    public void tests () {

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        //Choose one facility from the table by clicking on the Open tab
        // (Barry AL, Oris Code 3 was mainly used for this test) and select the open tab.
        waitFor(driver -> monitoringPlansPage.tableResults.size() > 3);
        String facility = monitoringPlansPage.tableResults.get(0).getText().split("\n")[1];
        click(monitoringPlansPage.openFacilityTab.get(0));

        //A new tab with the name of the selected facility should appear along with its Monitoring Plans data
        verifyTrue(monitoringPlansPage.tabs.size() == 2);
        click(monitoringPlansPage.tabs.get(1));
        verifyEquals(monitoringPlansPage.facilityTitle, facility);

        // Selecting Monitoring Systems under Sections Dropdown
        waitFor(monitoringPlansPage.monitoringMethods);
        click(monitoringPlansPage.monitoringSystems);
        Assert.assertEquals(true, monitoringPlansPage.monitoringSystems.isSelected());

        // Back to Select Facility page
        click(monitoringPlansPage.tabs.get(0));

        // Clicking on the Gadsden facility and its tab
        click(monitoringPlansPage.openFacilityTab.get(2));
        click(monitoringPlansPage.tabs.get(2));
        verifyEquals(monitoringPlansPage.facilityName, "Gadsden");

        // Back to the Berry Tab
        click(monitoringPlansPage.tabs.get(1));
        verifyEquals(monitoringPlansPage.facilityName, "Barry");

        // The pre selected Sections option of Monitoring Systems should still be selected
        Assert.assertEquals(true, monitoringPlansPage.monitoringSystems.isSelected());

    }
}
