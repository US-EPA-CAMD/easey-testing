package tests.UITests.EASEYIn_Emissioners.Regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_Load_Complete extends UiReusableComponents {

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
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Astoria Generating Station (Oris Code 8906)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionMethodsLabel);
        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringLoads);
        click(monitoringPlansPage.monitoringLoads);

        waitFor(monitoringPlansPage.accordionLoadsLabel);
        verifyEquals(monitoringPlansPage.accordionLoadsLabel, "Loads");

        // Start of View
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionLoadsLabel);
        Thread.sleep(3000);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Load");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.closeModal);
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
        waitFor(monitoringPlansPage.createLoadButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createLoadButton);

        int numOfLoads = monitoringPlansPage.viewButton.size();

        waitFor(monitoringPlansPage.createLoadButton);
        click(monitoringPlansPage.createLoadButton);

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        input(monitoringPlansPage.monitoringFormulasMaxLoadValField, "1");
        click(monitoringPlansPage.monMethodsModalMaxLoadUnitMeasureDropdown.get(1));
        input(monitoringPlansPage.modalStartDateField, "12/01/2022");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        waitFor(monitoringPlansPage.viewButton);

        int newNumOfMethods = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfMethods == numOfLoads + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.LoadsTableMaxLoadValLabel);
        verifyEquals(monitoringPlansPage.LoadsTableMaxLoadValLabel, "Maximum Load Value");

        String maxLoadVal = monitoringPlansPage.LoadsTableMaxLoadValField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        js.executeScript("arguments[0].click();", monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Load");

        waitFor(monitoringPlansPage.LoadsModalMaxLoadValField);
        if (maxLoadVal.equals("1")) {
            monitoringPlansPage.LoadsModalMaxLoadValField.clear();
            input(monitoringPlansPage.LoadsModalMaxLoadValField, "2");
        } else {
            monitoringPlansPage.LoadsModalMaxLoadValField.clear();
            input(monitoringPlansPage.LoadsModalMaxLoadValField, "1");
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        js.executeScript("arguments[0].click();", monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        Thread.sleep(2000);
        waitFor(monitoringPlansPage.LoadsTableMaxLoadValField.get(0));
        verifyNotEquals(monitoringPlansPage.LoadsTableMaxLoadValField.get(0).getText(), maxLoadVal);
        // End of Edit

        // Evaluate starts here
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
        waitFor(monitoringPlansPage.evaluateButton);
        click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue), 180000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusCriticalErrors, 180000);
        waitFor(monitoringPlansPage.evalStatusCriticalErrors);
        verifyEquals(monitoringPlansPage.evalStatusCriticalErrors, "Critical Errors");
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