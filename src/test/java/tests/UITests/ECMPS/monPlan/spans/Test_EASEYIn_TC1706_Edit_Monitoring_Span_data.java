package tests.UITests.ECMPS.monPlan.spans;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_TC1706_Edit_Monitoring_Span_data extends UiReusableComponents {

    @Test()
    public void tests() throws InterruptedException {
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

        waitFor(monitoringPlansPage.logInButtonOpenModal);
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

        waitFor(monitoringPlansPage.title);
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Astoria Generating Station (Oris Code 8906)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringSpan);
        click(monitoringPlansPage.monitoringSpan);

        waitFor(monitoringPlansPage.accordionSpansLabel);
        verifyEquals(monitoringPlansPage.accordionSpansLabel, "Spans");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.spansTableComponentTypeLabel);
        verifyEquals(monitoringPlansPage.spansTableComponentTypeLabel, "Component Type");

        waitFor(monitoringPlansPage.spansTableComponentTypeField);
        String componentType = monitoringPlansPage.spansTableComponentTypeField.get(0).getText();

        waitFor(monitoringPlansPage.viewButton,1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

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