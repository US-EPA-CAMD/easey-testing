package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_1344_Edit_Monitoring_Methods_section_with_form_validation extends UITestBase {

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
        waitFor(monitoringPlansPage.facilityTitle);
        verifyEquals(monitoringPlansPage.facilityTitle, facility);

        //Click on View/Edit under the Actions column
        waitFor(driver -> monitoringPlansPage.systemTableButtonList.size() > 1);
        click(monitoringPlansPage.systemTableButtonList.get(0));

        // Modal popup with information on which Method was selected
        //   an ID field that allows user to enter the necessary information,
        //   a Save and Close button and a Cancel button.

        // Click on Save and Close

        // Click on Cancel





    }
}
