package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_1413_Access_users_Workspace extends UITestBase {

    @Test
    public void tests () {

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // This is part of the message that appears when a page does not exist yet.
        String sorryMessage = "Sorry, but this web page does not exist.";

        // Verify Home Label
        // Verify Mon Plans
        verifyEquals(monitoringPlansPage.dashMonPlan, "Monitoring Plans");

        // Verify QA & Cert
        verifyEquals(monitoringPlansPage.dashQaCert, "QA & Certifications");
        click(monitoringPlansPage.dashQaCert);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Emissions
        verifyEquals(monitoringPlansPage.dashEmissions, "Emissions");
        click(monitoringPlansPage.dashEmissions);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify  that the Monitoring Plans page has reappeared
        click(monitoringPlansPage.dashMonPlan);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Verify Log In button
        verifyEquals(monitoringPlansPage.logInButton, "Log In");

        // Verify CAMD Apps
        verifyEquals(monitoringPlansPage.dashCamdApps, "CAMD Apps");
        click(monitoringPlansPage.dashCamdApps);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Help & Contact
        verifyEquals(monitoringPlansPage.dashHelpContact, "Help & Contact");
        click(monitoringPlansPage.dashHelpContact);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify  that the Monitoring Plans page has reappeared
        click(monitoringPlansPage.dashMonPlan);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

    }
}

