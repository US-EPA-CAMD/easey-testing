package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class UI_TC117_628_View_System_Details_Components_Modal extends UITestBase {

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
        click(monitoringPlansPage.tableResults.get(0));

        //A new tab with the name of the selected facility should appear along with its Monitoring Plans data
        verifyTrue(monitoringPlansPage.tabs.size() == 2);
        click(monitoringPlansPage.tabs.get(1));
        verifyEquals(monitoringPlansPage.facilityTitle, facility);

        //Under the Sections dropdown list select Monitoring Systems
        waitFor(monitoringPlansPage.sectionsDropdown);
        click(monitoringPlansPage.sectionsDropdown);
        click(monitoringPlansPage.monitoringSystems);
        //The data for Monitoring Systems appears in the Systems table

        //Opening Accordion Table
        waitFor(monitoringPlansPage.accordionButton);
        click(monitoringPlansPage.accordionButton);


        //Click on View under the Actions column
        click(monitoringPlansPage.systemTableButtonList.get(1));

        //Then the system displays a modal window (labels, cancel, save and close, X)
        verifyEquals(monitoringPlansPage.cancelModal,"Cancel");
        verifyEquals(monitoringPlansPage.saveCloseModal,"Save and Close");

        //Closing Model using the x button
        click(monitoringPlansPage.xOutModal);

        //Click on View under the Actions column
        click(monitoringPlansPage.systemTableButtonList.get(1));
        // Click on cancel button to close modal
        click(monitoringPlansPage.cancelModal);

        //Click on View under the Actions column
        click(monitoringPlansPage.systemTableButtonList.get(1));
        // Click on Save/Close button to close modal
        click(monitoringPlansPage.saveCloseModal);

    }
}
