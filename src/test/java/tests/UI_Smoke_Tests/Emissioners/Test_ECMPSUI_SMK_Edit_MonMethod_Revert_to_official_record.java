package tests.UI_Smoke_Tests.Emissioners;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_ECMPSUI_SMK_Edit_MonMethod_Revert_to_official_record extends UITestBase {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        waitFor(monitoringPlansPage.usernameLabelModal);
        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);

        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(monitoringPlansPage.title);

        waitFor(monitoringPlansPage.workspaceMonPlan);
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Astoria Generating Station (Oris Code 8906)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        js.executeScript("window.scrollBy(0,200)", "");

        waitFor(monitoringPlansPage.monMethodsTableParameterLabel);
        verifyEquals(monitoringPlansPage.monMethodsTableParameterLabel, "Parameter");

        String parameterCode = monitoringPlansPage.monMethodsTableParameterField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");

        waitFor(monitoringPlansPage.monMethodsTableParameterField);
        if (parameterCode.equals("CO2")) {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(7));
        } else {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(1));
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.monMethodsTableParameterField.get(0));
        verifyNotEquals(monitoringPlansPage.monMethodsTableParameterField.get(0).getText(), parameterCode);

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

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.monMethodsTableParameterField.get(0));
        verifyEquals(monitoringPlansPage.monMethodsTableParameterField.get(0).getText(), parameterCode);

        // These steps Checks Back In the configuration
        waitFor(monitoringPlansPage.configcheckBackInButton);
        click(monitoringPlansPage.configcheckBackInButton);

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");

    }
    @Override
    @AfterMethod
    public void afterMethod() {

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.menuBtn);

        if (isDisplayed(monitoringPlansPage.logOutButton)) {
            click(monitoringPlansPage.logOutButton);
            waitFor(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        } else {
            isDisplayed(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        }
        super.afterMethod();
    }
}