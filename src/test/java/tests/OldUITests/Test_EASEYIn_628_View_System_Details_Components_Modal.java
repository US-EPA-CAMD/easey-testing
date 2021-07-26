package tests.OldUITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_628_View_System_Details_Components_Modal extends UITestBase {

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

        //Under the Sections dropdown list select Monitoring Systems
        waitFor(monitoringPlansPage.monitoringSystems);
        click(monitoringPlansPage.monitoringSystems);
        //The data for Monitoring Systems appears in the Systems table

        //Click on View under the Actions column
        waitFor(driver -> monitoringPlansPage.systemTableButtonList.size() > 1);
        click(monitoringPlansPage.systemTableButtonList.get(0));

        //Verifying the labels on the popup modal
        waitFor(monitoringPlansPage.modalTitle);
        verifyEquals(monitoringPlansPage.modalTitle, "Monitoring Systems: AF1");
        verifyEquals(monitoringPlansPage.modalSystemID, "System ID");
        verifyEquals(monitoringPlansPage.modalSystemDesignation, "System Designation");
        verifyEquals(monitoringPlansPage.modalSystemType, "System Type");
        verifyEquals(monitoringPlansPage.modalFuelType, "Fuel Type");
        verifyEquals(monitoringPlansPage.modalStartTimeDate, "Start Date and Time");
        verifyEquals(monitoringPlansPage.modalEndTimeDate, "End Date and Time");

        //Then the system displays a modal window (labels, cancel, save and close, X)
        verifyEquals(monitoringPlansPage.cancelModal,"Cancel");
        verifyEquals(monitoringPlansPage.saveCloseModal,"Save and Close");

        //Closing Model using the x button
        click(monitoringPlansPage.xOutModal);
        //Verifying base page is visible
        verifyEquals(monitoringPlansPage.systemIDTitle,"System ID");

        //Click on View under the Actions column
        click(monitoringPlansPage.systemTableButtonList.get(1));
        //Click on cancel button to close modal
        verifyEquals(monitoringPlansPage.cancelModal,"Cancel");
        click(monitoringPlansPage.cancelModal);
        // Verifying base page is visible
        verifyEquals(monitoringPlansPage.systemIDTitle,"System ID");

        //Click on View under the Actions column
        click(monitoringPlansPage.systemTableButtonList.get(1));
        //Click on Save/Close button to close modal
        verifyEquals(monitoringPlansPage.saveCloseModal,"Save and Close");
        click(monitoringPlansPage.saveCloseModal);
        //Verifying base page is visible
        verifyEquals(monitoringPlansPage.systemIDTitle,"System ID");

    }
}
