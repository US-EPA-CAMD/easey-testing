package tests.UITests.ECMPS.monPlan.regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_Mats_Methods_Complete extends UiReusableComponents {

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
        input(monitoringPlansPage.filterByKeywordBox, "Dolet Hills Power Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Dolet Hills Power Station (Oris Code 51)
        Thread.sleep(200);
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 3);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        // Start of View
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        Thread.sleep(1000);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 6);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionSupplementalMethodsLabel);
        Thread.sleep(1000);
        verifyEquals(monitoringPlansPage.viewButton.get(8).getText(), "View");
        click(monitoringPlansPage.viewButton.get(8));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Component: Monitoring MATS Methods");

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
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        waitFor(monitoringPlansPage.createMatsMethodsButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createMatsMethodsButton);
        waitFor(monitoringPlansPage.createMatsMethodsButton);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 7);
        int numOfMethods = monitoringPlansPage.viewButton.size();

        click(monitoringPlansPage.createMatsMethodsButton);

        waitFor(monitoringPlansPage.modalStartDateField);
        waitFor(monitoringPlansPage.modalStartTimeField);
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");
        waitFor(monitoringPlansPage.monMethodsModalParameterDropdown);
        click(monitoringPlansPage.monMethodsModalParameterDropdown.get(2));
        waitFor(monitoringPlansPage.monMethodsModalMethodologyDropdown);
        click(monitoringPlansPage.monMethodsModalMethodologyDropdown.get(1));


        click(monitoringPlansPage.saveCloseModal);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        waitFor(monitoringPlansPage.viewButton);

        waitFor(monitoringPlansPage.createMonMethodsButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createMonMethodsButton);
        Thread.sleep(1000);
        waitFor(monitoringPlansPage.createMatsMethodsButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createMatsMethodsButton);
        Thread.sleep(3000);

        int newNumOfMethods = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfMethods == numOfMethods + 1);
        // End of Create

        // Start of Edit
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        waitFor(monitoringPlansPage.monMethodsTableParameterLabel);
        verifyEquals(monitoringPlansPage.monMethodsTableParameterLabel, "Parameter");

        String parameterCode = monitoringPlansPage.monMethodsTableParameterField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 3);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionSupplementalMethodsLabel);
        verifyEquals(monitoringPlansPage.viewButton.get(8).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(8));

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

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.monMethodsTableParameterField.get(9));
        Thread.sleep(3000);
        waitFor(monitoringPlansPage.monMethodsTableParameterField.get(8));
        verifyNotEquals(monitoringPlansPage.monMethodsTableParameterField.get(8).getText(), parameterCode);
        // End of Edit

        // Evaluate starts here
       js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
       waitFor(monitoringPlansPage.evaluateButton);
       click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue), 180000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusPassed, 180000);
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