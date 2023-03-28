package tests.UITests.ECMPS.monPlan.monPlan_SmokeTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

/*
This test verifies that the user can successfully log In to the application
*/

public class Test_ECMPSUI_SMK_LogIn_and_LogOut extends UiReusableComponents {

    @Test()
    public void tests() {
        String username = System.getenv("TESTING_USERNAME");
        String password = System.getenv("TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // Verifying that the page has opened and the title is visible
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Verifying that the Log In button is visible and clickable
        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        // Inputting username into the Log In modal
        waitFor(monitoringPlansPage.usernameLabelModal);
        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        // Inputting password into the Log In modal
        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);

        // Clicking the Log In submit button
        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        // Verifying that the system has logged in by verifying that the Workspace is now visible
        waitFor(monitoringPlansPage.title);

        // Verifying that Log In has now changed to Log Out
        waitFor(monitoringPlansPage.logOutButton);
        verifyEquals(monitoringPlansPage.logOutButton.getText(), "Log Out");

        // Verifying that Log Out has now changed to Log In
        click(monitoringPlansPage.logOutButton);
        waitFor(monitoringPlansPage.logInButtonOpenModal);
        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");

    }
    @Override
    @AfterMethod
    public void afterMethod() {
        logOutMethod();
        super.afterMethod();
    }
}
