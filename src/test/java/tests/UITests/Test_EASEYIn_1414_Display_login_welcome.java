package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_1414_Display_login_welcome extends UITestBase {

    @Test
    public void tests () {

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Click Log In button on dashboard
        verifyEquals(monitoringPlansPage.logIn, "Log In");
        click(monitoringPlansPage.logIn);
        // Log In modal pops up.
        // Enter Username
        // Enter Password
        // Click Log In
        // Welcome note appears on Dashboard Navigation
            // A Person Icon with the words "Welcome, [User's first name]"
            // The Log In button now says Log Out
        //Click Log Out button
        // Confirm that the Logout has occurred








    }
}
