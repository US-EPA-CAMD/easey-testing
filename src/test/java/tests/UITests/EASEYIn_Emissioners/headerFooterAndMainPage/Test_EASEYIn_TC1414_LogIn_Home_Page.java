package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1414_LogIn_Home_Page extends UITestBase {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.dashHomeTitle, "Home");
        click(headerFooterAndHomePage.dashHomeTitle);

        verifyEquals(headerFooterAndHomePage.logInLabelHomePage, "Log In");

        verifyEquals(headerFooterAndHomePage.usernameLabel.getText(), "Username");
        input(headerFooterAndHomePage.usernameField, username);

        verifyEquals(headerFooterAndHomePage.passwordLabel.getText(), "Password");
        input(headerFooterAndHomePage.passwordField, password);

        verifyEquals(headerFooterAndHomePage.logInButton, "Log In");
        click(headerFooterAndHomePage.logInButtonModal);

        waitFor(monitoringPlansPage.title);
        waitFor(headerFooterAndHomePage.dashWorkspace);
        verifyEquals(headerFooterAndHomePage.dashWorkspace, "Workspace");

        waitFor(headerFooterAndHomePage.logOutButton);
        verifyEquals(headerFooterAndHomePage.logOutButton.getText(), "Log Out");

    }
}
