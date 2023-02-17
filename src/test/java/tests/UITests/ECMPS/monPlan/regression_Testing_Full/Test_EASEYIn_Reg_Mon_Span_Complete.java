package tests.UITests.ECMPS.monPlan.regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_Span_Complete extends UiReusableComponents {

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
        Thread.sleep(500);
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringSpan);
        click(monitoringPlansPage.monitoringSpan);

        waitFor(monitoringPlansPage.accordionSpansLabel);
        verifyEquals(monitoringPlansPage.accordionSpansLabel, "Spans");

        // Start of View
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        Thread.sleep(1000);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Span");

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
        waitFor(monitoringPlansPage.createDefaultButton);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createSpanButton);

        int numOfSpans = monitoringPlansPage.viewButton.size();

        waitFor(monitoringPlansPage.createSpanButton);
        click(monitoringPlansPage.createSpanButton);

        waitFor(monitoringPlansPage.monMethodsModalComponentTypeDropdown);
        click(monitoringPlansPage.monMethodsModalComponentTypeDropdown.get(1));
        input(monitoringPlansPage.modalStartDateField, "01/01/2022");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        int newNumOfSpans = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfSpans == numOfSpans + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.spansTableComponentTypeLabel);
        verifyEquals(monitoringPlansPage.spansTableComponentTypeLabel, "Component Type");

        waitFor(monitoringPlansPage.spansTableComponentTypeField);
        String componentType = monitoringPlansPage.spansTableComponentTypeField.get(0).getText();

        waitFor(monitoringPlansPage.viewButton,1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionSpansLabel);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Span");

        if (componentType.equals("CO2")) {
            waitFor(monitoringPlansPage.monMethodsModalComponentTypeDropdown);
            click(monitoringPlansPage.monMethodsModalComponentTypeDropdown.get(3));
        } else {
            waitFor(monitoringPlansPage.monMethodsModalComponentTypeDropdown);
            click(monitoringPlansPage.monMethodsModalComponentTypeDropdown.get(1));
        }

        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);

        Thread.sleep(3000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));
        waitFor(monitoringPlansPage.spansTableComponentTypeLabel,1);
        verifyNotEquals(monitoringPlansPage.spansTableComponentTypeField.get(0).getText(), componentType);
        // End of Edit

        // Evaluate starts here
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
        waitFor(monitoringPlansPage.evaluateButton);
        click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
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