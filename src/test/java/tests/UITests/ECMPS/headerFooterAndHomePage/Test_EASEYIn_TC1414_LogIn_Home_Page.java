package tests.UITests.ECMPS.headerFooterAndHomePage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1414_LogIn_Home_Page extends UITestBase {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashHomeTitle, "Home");
        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.logInLabelHomePage, "Log In");

        verifyEquals(monitoringPlansPage.usernameLabelHomePage.getText(), "Username");
        input(monitoringPlansPage.usernameFieldHomePage, username);

        verifyEquals(monitoringPlansPage.passwordLabelHomePage.getText(), "Password");
        input(monitoringPlansPage.passwordFieldHomePage, password);

        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        waitFor(monitoringPlansPage.title);
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        waitFor(monitoringPlansPage.logOutButton);
        verifyEquals(monitoringPlansPage.logOutButton.getText(), "Log Out");

    }
}
