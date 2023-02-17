package tests.UITests.ECMPS.monPlan.regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_DuctWafs_Complete extends UiReusableComponents {

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
        input(monitoringPlansPage.filterByKeywordBox, "Martin Drake");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Martin Drake (Oris Code 492)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringRectangularDuctWAFs);
        click(monitoringPlansPage.monitoringRectangularDuctWAFs);

        waitFor(monitoringPlansPage.accordionRectangularDuctWAFsLabel);
        verifyEquals(monitoringPlansPage.accordionRectangularDuctWAFsLabel, "WAFs Rectangular Duct");
        Thread.sleep(1000);

        // Start of View
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionRectangularDuctWAFsLabel);

        Thread.sleep(3000);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Rectangular Duct WAF");

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
                monitoringPlansPage.accordionRectangularDuctWAFsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int numOfDuctWAFs = monitoringPlansPage.viewButton.size();

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createRectangularDuctWafBtn);
        waitFor(monitoringPlansPage.createRectangularDuctWafBtn);
        click(monitoringPlansPage.createRectangularDuctWafBtn);

        waitFor(monitoringPlansPage.wafMethodModalDropdown);
        click(monitoringPlansPage.wafMethodModalDropdown.get(1));
        input(monitoringPlansPage.wafDeterminationDateField, "12/01/2021");
        input(monitoringPlansPage.wafValueModalField, "10");
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int newNumOfDuctWAFs = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfDuctWAFs == numOfDuctWAFs + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.wafMethodTableLabel);
        verifyEquals(monitoringPlansPage.wafMethodTableLabel, "WAF Method");

        String WAFMethod = monitoringPlansPage.wafMethodTableField.get(1).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Rectangular Duct WAF");

        waitFor(monitoringPlansPage.wafMethodModalDropdown);
        if (WAFMethod.equals("DF")) {
            click(monitoringPlansPage.wafMethodModalDropdown.get(1));
        } else {
            click(monitoringPlansPage.wafMethodModalDropdown.get(2));
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        Thread.sleep(2000);
        waitFor(monitoringPlansPage.wafMethodTableField.get(1));
        verifyNotEquals(monitoringPlansPage.wafMethodTableField.get(1).getText(), WAFMethod);
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