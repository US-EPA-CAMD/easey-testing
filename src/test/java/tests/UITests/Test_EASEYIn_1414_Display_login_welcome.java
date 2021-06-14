package tests.UITests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CSVParser;
import tests.utils.UITestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test_EASEYIn_1414_Display_login_welcome extends UITestBase {

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "UITestData/TC1414_LogIn_Data.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }
    @Test(dataProvider = "csv")
    public void tests(Map<String, String> map) throws IOException, CsvValidationException {

        String username = map.get("username");
        String password = map.get("password");


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