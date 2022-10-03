package tests.UI_Smoke_Tests.Emissioners;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;

/*
This test verifies that the user
can successfully get access to the facilities and configurations
logged in Workspace View.
 */

public class Test_ECMPSUI_SMK_OpenConfiguration_LoggedIn extends EmMonPlanReusables {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

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
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.title);

        // Verifying that the Monitoring Plans in Workspace in Visible
        waitFor(monitoringPlansPage.workspaceMonPlan);
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        // Inputting and getting desired facility with search box
        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Widows Creek");
        click(monitoringPlansPage.filterByKeywordButton);

        // Selenium does not see the Workspace.
        // This scrolls down so that the Workspace is visible.
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.facilityCaret.get(0));

        // Clicks on Widows Creek (Oris Code 50)
        click(monitoringPlansPage.facilityCaret.get(0));

        // Opens the desired configuration
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        // Clicks on the tab of the configuration
        click(monitoringPlansPage.configTabs.get(0));

        // Verifies that the configuration is open and its default is Methods
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        js.executeScript("window.scrollBy(0,250)", "");

        // Checks Out the configuration
        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        // Checks Back In the configuration
        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // These steps closes the tab and automatically Checks Back In the configuration
        click(monitoringPlansPage.closeConfigTab.get(0));
        waitFor(monitoringPlansPage.selectConfigurationsLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.selectConfigurationsLabel));

    }
    @Override
    @AfterMethod
    public void afterMethod() {
        logOutMethod();
        super.afterMethod();
    }
}