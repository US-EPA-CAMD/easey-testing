package tests.UITests.EASEYIn_Emissioners.monPlan.defaults;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1697_Edit_MP_Defaults_Data extends EmMonPlanReusables {

    @Test()
    public void tests() {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        waitFor(monitoringPlansPage.usernameLabelModal);
        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        waitFor(monitoringPlansPage.passwordLabelModal);
        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);

        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(monitoringPlansPage.title);
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Gadsden");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Gadsden (Oris Code 7)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringDefaults);
        click(monitoringPlansPage.monitoringDefaults);

        waitFor(monitoringPlansPage.accordionDefaultsLabel);
        verifyEquals(monitoringPlansPage.accordionDefaultsLabel, "Defaults");

        click(monitoringPlansPage.location.get(2));
        verifyEquals(monitoringPlansPage.location.get(2), "CS0BAN");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(monitoringPlansPage.defaultsTableParameterCodeLabel);
        verifyEquals(monitoringPlansPage.defaultsTableParameterCodeLabel, "Parameter Code");

        String parameterCode = monitoringPlansPage.defaultsTableParameterCodeField.get(0).getText();

        waitFor(monitoringPlansPage.viewButton,1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Default");

        if (parameterCode.equals("CO2N")) {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(7));
        } else {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(8));
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));
        waitFor(monitoringPlansPage.defaultsTableParameterCodeField,1);
        verifyNotEquals(monitoringPlansPage.defaultsTableParameterCodeField.get(0).getText(), parameterCode);

        // Revert starts here
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertOfficialRecordButton);
        verifyEquals(monitoringPlansPage.revertOfficialRecordButton, "Revert to Official Record");
        click(monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertModalYesButton);
        verifyEquals(monitoringPlansPage.revertModalYesButton, "Yes");
        click(monitoringPlansPage.revertModalYesButton);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.revertModalYesButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));

        // These steps Checks Back In the configuration
        waitFor(monitoringPlansPage.configcheckBackInButton);
        click(monitoringPlansPage.configcheckBackInButton);

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");

    }
    @Override
    @AfterMethod
    public void afterMethod() {
        logOutMethod();
        super.afterMethod();
    }
}