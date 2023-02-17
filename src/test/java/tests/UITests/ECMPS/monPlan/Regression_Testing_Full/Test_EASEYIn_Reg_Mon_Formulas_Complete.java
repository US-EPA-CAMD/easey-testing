package tests.UITests.ECMPS.monPlan.Regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_Formulas_Complete extends UiReusableComponents {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

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

        waitFor(monitoringPlansPage.workspaceMonPlan);
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Astoria Generating Station (Oris Code 8906)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringFormulas);
        click(monitoringPlansPage.monitoringFormulas);

        waitFor(monitoringPlansPage.accordionFormulasLabel);
        verifyEquals(monitoringPlansPage.accordionFormulasLabel, "Formulas");

        // Start of View
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        Thread.sleep(1000);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionFormulasLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Formula");

        waitFor(monitoringPlansPage.closeModal);
        click(monitoringPlansPage.closeModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.closeModal));

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));
        // End of View

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        // Start of Create
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createFormulaButton);

        int numOfMethods = monitoringPlansPage.viewButton.size();

        waitFor(monitoringPlansPage.createFormulaButton);
        click(monitoringPlansPage.createFormulaButton);

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        input(monitoringPlansPage.monitoringFormulasIdField, "001");
        click(monitoringPlansPage.monMethodsModalParameterDropdown.get(1));
        waitFor(monitoringPlansPage.monMethodsModalFormulaCodeDropdown);
        click(monitoringPlansPage.monMethodsModalFormulaCodeDropdown.get(1));
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        waitFor(monitoringPlansPage.viewButton);

        int newNumOfMethods = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfMethods == numOfMethods + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.formulasTableParameterLabel);
        verifyEquals(monitoringPlansPage.formulasTableParameterLabel, "Parameter");

        waitFor(monitoringPlansPage.formulasTableParameterField);
        String parameterField = monitoringPlansPage.formulasTableParameterField.get(1).getText();

        waitFor(monitoringPlansPage.viewButton,1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Formula");

        if (parameterField.equals("CO2")) {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(1));
        } else {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(5));
        }

        waitFor(monitoringPlansPage.monMethodsModalFormulaCodeDropdown);
        click(monitoringPlansPage.monMethodsModalFormulaCodeDropdown.get(1));

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);

        Thread.sleep(2000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));
        waitFor(monitoringPlansPage.formulasTableParameterLabel,1);
        verifyNotEquals(monitoringPlansPage.formulasTableParameterField.get(1).getText(), parameterField);
        // End of Edit

        // Evaluate starts here
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
        waitFor(monitoringPlansPage.evaluateButton);
        click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue),180000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusPassed,180000);
        verifyEquals(monitoringPlansPage.evalStatusPassed, "Passed");
        // Evaluate ends here

        // Revert starts here
        revertToOfficial();

    }
    @Override
    @AfterMethod
    public void afterMethod() {
        logOutMethod();
        super.afterMethod();
    }
}