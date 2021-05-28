package tests.UITests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test_EASEYIn_1414_Display_login_welcome extends UITestBase {

    private static final String csvPath = "";

    @Test
    public void tests() throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader(csvPath));
        String[] csvCell;
        while ((csvCell = reader.readNext()) != null) {
            String username = csvCell[0];
            String password = csvCell[1];

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
            monitoringPlansPage.usernameField.sendKeys(username);
            // Enter Password
            verifyEquals(monitoringPlansPage.passwordLabel, "Password");
            monitoringPlansPage.passwordField.sendKeys(password);
            // Click Log In
            verifyEquals(monitoringPlansPage.logInButtonModal, "Log In");
            click(monitoringPlansPage.logInButtonModal);
            // Welcome note appears on Dashboard Navigation
            // A Person Icon with the words "Welcome, [User's first name]"
            waitFor(monitoringPlansPage.welcomeMessage);
            verifyEquals(monitoringPlansPage.welcomeMessage, "Welcome, Moses");
            // The Log In button now says Log Out
            //Click Log Out button
            verifyEquals(monitoringPlansPage.logOutButton, "Log Out");
            click(monitoringPlansPage.logOutButton);
            // Confirm that the Logout has occurred
            waitFor(monitoringPlansPage.logInButton);
            verifyEquals(monitoringPlansPage.logInButton, "Log In");

        }
    }
}