package tests.UITests.EASEYIn_Emissioners.monPlan.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;

public class Test_EASEYIn_Reg_Mon_Mats_Methods_Complete extends EmMonPlanReusables {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

        goToo("ecmps","/monitoring-plans");

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
        input(monitoringPlansPage.filterByKeywordBox, "Delaware City");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Delaware City (Oris Code 592)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        // Start of View
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        Thread.sleep(1000);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");

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
        waitFor(monitoringPlansPage.createMatsMethodsButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createMatsMethodsButton);
        waitFor(monitoringPlansPage.createMatsMethodsButton);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        int numOfMethods = monitoringPlansPage.viewButton.size();

        click(monitoringPlansPage.createMatsMethodsButton);

        waitFor(monitoringPlansPage.modalStartDateField);
        waitFor(monitoringPlansPage.modalStartTimeField);
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");
        waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
        click(monitoringPlansPage.monMethodsModalParameterDropdown.get(3));
        waitFor(monitoringPlansPage.monMethodsModalMethodologyDropdown);
        click(monitoringPlansPage.monMethodsModalMethodologyDropdown.get(1));


        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);

        int newNumOfMethods = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfMethods == numOfMethods + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.monMethodsTableParameterLabel);
        verifyEquals(monitoringPlansPage.monMethodsTableParameterLabel, "Parameter");

        String parameterCode = monitoringPlansPage.monMethodsTableParameterField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 2);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.viewButton.get(2));
        verifyEquals(monitoringPlansPage.viewButton.get(2).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(2));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Component: Monitoring MATS Methods");

        waitFor(monitoringPlansPage.monMethodsTableParameterField);
        if (parameterCode.equals("HG")) {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(1));
        } else {
            waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
            click(monitoringPlansPage.monMethodsModalParameterDropdown.get(2));
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.monMethodsTableParameterField.get(2));
        verifyNotEquals(monitoringPlansPage.monMethodsTableParameterField.get(2).getText(), parameterCode);
        // End of Edit

        // Evaluate starts here
       js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
       waitFor(monitoringPlansPage.evaluateButton);
       click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusPassed);
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