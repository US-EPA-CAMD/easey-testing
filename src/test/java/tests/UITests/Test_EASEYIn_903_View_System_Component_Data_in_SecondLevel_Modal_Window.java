package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_903_View_System_Component_Data_in_SecondLevel_Modal_Window extends UITestBase {

    @Test
    public void tests() {

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

        //Under the Sections dropdown list select Monitoring Systems
        waitFor(monitoringPlansPage.monitoringSystems);
        click(monitoringPlansPage.monitoringSystems);
        //The data for Monitoring Systems appears in the Systems table

        //Click on View under the Actions column
        waitFor(driver -> monitoringPlansPage.systemTableButtonList.size() > 1);
        click(monitoringPlansPage.systemTableButtonList.get(0));


        // Validate the below labels

        // Component ID (Required)
        // Sample Acquisition Method
        // Component Type (Required)
        // Basis Description
        // Manufacturer
        // Model or Version
        // Serial Number
        // Hg Converter Indicator
        // Start Date and Time (Required)
            // dateFormatLabel
            // hourFormatLabel
        // End Date and Time
            // dateFormatLabel
            // hourFormatLabel

    }
}