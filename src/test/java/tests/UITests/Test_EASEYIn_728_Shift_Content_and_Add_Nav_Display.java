package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_728_Shift_Content_and_Add_Nav_Display extends UITestBase {

    @Test
    public void tests () {

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashboardTitle, "EASEY-In Dashboard");

        verifyEquals(monitoringPlansPage.dashWorkspaceTitle, "Workspace");
        verifyEquals(monitoringPlansPage.dashMonPlan, "- Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashQaCert, "- QA & Certifications");
        click(monitoringPlansPage.dashQaCert);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        verifyEquals(monitoringPlansPage.dashEmissions, "- Emissions");
        click(monitoringPlansPage.dashEmissions);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        click(monitoringPlansPage.dashMonPlan);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashCamdApps, "CAMD Apps");
        click(monitoringPlansPage.dashCamdApps);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        verifyEquals(monitoringPlansPage.dashProfile, "Profile");
        click(monitoringPlansPage.dashProfile);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        verifyEquals(monitoringPlansPage.dashAccountMan, "Account Management");
        click(monitoringPlansPage.dashAccountMan);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        verifyEquals(monitoringPlansPage.dashHelpContact, "Help & Contact");
        click(monitoringPlansPage.dashHelpContact);
        verifyEquals(monitoringPlansPage.pageDoesntExist, "Sorry, but this web page does not exist.");

        click(monitoringPlansPage.dashMonPlan);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

    }
}
