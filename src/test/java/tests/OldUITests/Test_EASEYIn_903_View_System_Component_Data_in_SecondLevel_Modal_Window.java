package tests.OldUITests;

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

        // System Components Headers
        verifyEquals(monitoringPlansPage.systemComponentsHeader, "System Components");
        verifyEquals(monitoringPlansPage.componentIdHeader.get(1).getText(), "Component ID");
        verifyEquals(monitoringPlansPage.componentTypeCodeHeader.get(1).getText(), "Type Code");
        verifyEquals(monitoringPlansPage.componentBeginToEndDateHeader.get(1).getText(), "Begin to End Date");
        verifyEquals(monitoringPlansPage.componentActionsHeader.get(1).getText(), "Actions");

        // Verifying the Add Components button
//        verifyEquals(monitoringPlansPage.addComponentButton, "Add Component");

        // Verifying the View button under Actions
        waitFor(driver -> monitoringPlansPage.componentsViewButton.size() > 3);
        verifyEquals(monitoringPlansPage.componentsViewButton.get(1), "View");
        click(monitoringPlansPage.componentsViewButton.get(1));

        //  Component ID
        verifyEquals(monitoringPlansPage.componentIdModal, "Component ID");
        //  Sample Acquisition Method
        verifyEquals(monitoringPlansPage.componentSampleAcquisitionMethodModal, "Sample Acquisition Method");
        //  Component Type
        waitFor(monitoringPlansPage.ComponentTypeModal);
        verifyEquals(monitoringPlansPage.ComponentTypeModal, "Component Type");
        //  Basis Description
        verifyEquals(monitoringPlansPage.componentBasisDescriptionModal, "Basis Description");
        //  Manufacturer
        verifyEquals(monitoringPlansPage.componentManufacturerModal, "Manufacturer");
        //  Model or Version
        verifyEquals(monitoringPlansPage.componentModelOrVersionModal, "Model or Version");
        //  Serial Number
        verifyEquals(monitoringPlansPage.componentSerialNumberModal, "Serial Number");
        //  Hg Converter Indicator
        verifyEquals(monitoringPlansPage.componentHgConverterIndicatorModal, "Hg Converter Indicator");
        //  Start Date and Time
        verifyEquals(monitoringPlansPage.componentStartDateAndTimeModal, "Start Date and Time");
          //  dateFormatLabel
        verifyEquals(monitoringPlansPage.componentStartDateModal, "mm/dd/yyyy");
          //  hourFormatLabel
        verifyEquals(monitoringPlansPage.componentStartHourModal, "hh");
        //  End Date and Time
        verifyEquals(monitoringPlansPage.componentEndDateAndTimeModal, "End Date and Time");
          //  dateFormatLabel
        verifyEquals(monitoringPlansPage.componentEndDateModal, "mm/dd/yyyy");
          //  hourFormatLabel
        verifyEquals(monitoringPlansPage.componentEndHourModal, "hh");

        verifyTrue(isDisplayed(monitoringPlansPage.componentBackButton));
        click(monitoringPlansPage.componentBackButton);

        verifyEquals(monitoringPlansPage.systemComponentsHeader, "System Components");

    }
}