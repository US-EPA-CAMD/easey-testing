package tests.OldUITests;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CSVParser;
import tests.utils.UITestBase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Test_EASEYIn_728_Shift_Content_and_Add_Nav_Display extends UITestBase {

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

        // This is part of the message that appears when a page does not exist yet.
        String sorryMessage = "Sorry, but this web page does not exist.";

        // Verify Home Label
        waitFor(monitoringPlansPage.dashHomeTitle);
        verifyEquals(monitoringPlansPage.dashHomeTitle, "Home");

        // Verify Mon Plans
        verifyEquals(monitoringPlansPage.dashMonPlan.get(0), "Monitoring Plans");

        // Verify QA & Cert
        waitFor(driver -> monitoringPlansPage.dashQaCert.size() > 1);
        verifyEquals(monitoringPlansPage.dashQaCert.get(0), "QA & Certifications");
        click(monitoringPlansPage.dashQaCert.get(0));
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Emissions
        verifyEquals(monitoringPlansPage.dashEmissions.get(0), "Emissions");
        click(monitoringPlansPage.dashEmissions.get(0));
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify that the Monitoring Plans page has reappeared
        click(monitoringPlansPage.dashMonPlan.get(0));
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Verify Workspace
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");
        click(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Mon Plans under Workspace
        verifyEquals(monitoringPlansPage.dashMonPlan.get(1), "Monitoring Plans");
        click(monitoringPlansPage.dashMonPlan.get(1));
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Verify QA & Cert under Workspace
        verifyEquals(monitoringPlansPage.dashQaCert.get(1), "QA & Certifications");
        click(monitoringPlansPage.dashQaCert.get(1));
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Emissions under Workspace
        verifyEquals(monitoringPlansPage.dashEmissions.get(1), "Emissions");
        click(monitoringPlansPage.dashEmissions.get(1));
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify Profile
        verifyEquals(monitoringPlansPage.dashProfile, "Profile");
        click(monitoringPlansPage.dashProfile);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify
        verifyEquals(monitoringPlansPage.dashAccountMan, "Account Management");
        click(monitoringPlansPage.dashAccountMan);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify
        verifyEquals(monitoringPlansPage.dashCamdApps, "CAMD Apps");
        click(monitoringPlansPage.dashCamdApps);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify
        verifyEquals(monitoringPlansPage.dashHelpContact, "Help & Contact");
        click(monitoringPlansPage.dashHelpContact);
        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        // Verify that the Monitoring Plans page has reappeared
        click(monitoringPlansPage.dashMonPlan.get(0));
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
    }
}
