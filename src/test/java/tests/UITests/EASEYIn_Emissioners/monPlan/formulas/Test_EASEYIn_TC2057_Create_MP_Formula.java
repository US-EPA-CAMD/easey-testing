package tests.UITests.EASEYIn_Emissioners.monPlan.formulas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2057_Create_MP_Formula extends EmMonPlanReusables {

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
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Holcomb (Oris Code 8906)
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

        waitFor(monitoringPlansPage.monitoringFormulas);
        click(monitoringPlansPage.monitoringFormulas);
        waitFor(monitoringPlansPage.accordionFormulasLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 2);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createFormulaButton);

        int numOfMethods = monitoringPlansPage.viewButton.size();

        waitFor(monitoringPlansPage.createFormulaButton);
        click(monitoringPlansPage.createFormulaButton);

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        input(monitoringPlansPage.monitoringFormulasIdField, "TES");
        click(monitoringPlansPage.monMethodsModalParameterDropdown.get(1));
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        waitFor(monitoringPlansPage.viewButton);

        int newNumOfMethods = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfMethods == numOfMethods + 1);

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