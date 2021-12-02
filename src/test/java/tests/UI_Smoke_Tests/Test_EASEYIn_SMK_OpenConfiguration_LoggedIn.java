package tests.UI_Smoke_Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

/*
This test verifies that the user
can successfully get access to the facilities and configurations
logged in Workspace View.
 */

public class Test_EASEYIn_SMK_OpenConfiguration_LoggedIn extends UITestBase {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

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
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        // Selenium does not see the Workspace.
        // This scrolls down so that the Workspace is visible.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        // Verifying that the Monitoring Plans in Workspace in Visible
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        // Inputting and getting desired facility with search box
        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Widows Creek");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Widows Creek (Oris Code 50)
        click(monitoringPlansPage.facilityCaret.get(0));

        // Opens the desired configuration
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        // Clicks on the tab of the configuration
        click(monitoringPlansPage.configTabs.get(0));

        // Verifies that the configuration is open and its default is Methods
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        // Checks Out the configuration
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        // Checks Back In the configuration
        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // These steps closes the tab and automatically Checks Back In the configuration
        click(monitoringPlansPage.closeConfigTab.get(0));
        waitFor(monitoringPlansPage.selectConfigurationLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.selectConfigurationLabel));

        // Selenium does not see the Log Out button.
        // This scrolls up so that the Log Out is visible.
        js.executeScript("window.scrollBy(0,-250)", "");

        // Verifying that Log Out has now changed to Log In
        click(monitoringPlansPage.logOutButton);
        waitFor(monitoringPlansPage.logInButtonOpenModal);
        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");

    }
}