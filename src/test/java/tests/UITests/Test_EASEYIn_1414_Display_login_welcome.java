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
        verifyEquals(monitoringPlansPage.logInButton, "Log In");
        click(monitoringPlansPage.logInButton);
        // Log In modal pops up.
        verifyEquals(monitoringPlansPage.logInLabel, "Log In");
        // Enter Username
        verifyEquals(monitoringPlansPage.usernameLabel, "Username");
        monitoringPlansPage.usernameField.sendKeys("username");
        // Enter Password
        verifyEquals(monitoringPlansPage.passwordLabel, "Username");
        monitoringPlansPage.passwordField.sendKeys("password");
        // Click Log In
        click(monitoringPlansPage.logInButton);
        // Welcome note appears on Dashboard Navigation
            // A Person Icon with the words "Welcome, [User's first name]"
        verifyEquals(monitoringPlansPage.welcomeMessage, "Welcome, \"Moses\"");
            // The Log In button now says Log Out
        //Click Log Out button
        verifyEquals(monitoringPlansPage.logOutButton, "Log Out");
        click(monitoringPlansPage.logOutButton);
        // Confirm that the Logout has occurred
        waitFor(monitoringPlansPage.logInButton);
        verifyEquals(monitoringPlansPage.logInButton, "Log In");

    }
}
