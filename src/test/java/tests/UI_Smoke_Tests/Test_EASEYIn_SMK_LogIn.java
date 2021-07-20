package tests.UI_Smoke_Tests;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CSVParser;
import tests.utils.UITestBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test_EASEYIn_SMK_LogIn extends UITestBase {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.logInButton, "Log In");
        click(monitoringPlansPage.logInButton);

        verifyEquals(monitoringPlansPage.usernameLabel.getText(), "Username");
        monitoringPlansPage.usernameField.sendKeys(username);

        verifyEquals(monitoringPlansPage.passwordLabel.getText(), "Password");
        monitoringPlansPage.passwordField.sendKeys(password);

        verifyEquals(monitoringPlansPage.logInButton, "Log In");
        click(monitoringPlansPage.logInButtonModal);

        waitFor(monitoringPlansPage.title);
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        waitFor(monitoringPlansPage.logOutButton);
        verifyEquals(monitoringPlansPage.logOutButton.getText(), "Log Out");

    }
}
