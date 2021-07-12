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

public class Test_EASEYIn_SMK_LoggIn extends UITestBase {

    @DataProvider(name = "csv")
    public Object[] dp() {
        String filePath = filePathBase +
                "UITestData/TC1414_LogIn_Data.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }
    @Test(dataProvider = "csv")
    public void tests(Map<String, String> map) throws IOException, CsvValidationException, InterruptedException {

        String username = map.get("username");
        String password = map.get("password");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

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
        waitFor(monitoringPlansPage.selectConfigurationLabel);
        verifyEquals(monitoringPlansPage.selectConfigurationLabel, "Select Configurations");

        waitFor(monitoringPlansPage.logOutButton);
        verifyEquals(monitoringPlansPage.logOutButton.getText(), "Log Out");

    }
}
