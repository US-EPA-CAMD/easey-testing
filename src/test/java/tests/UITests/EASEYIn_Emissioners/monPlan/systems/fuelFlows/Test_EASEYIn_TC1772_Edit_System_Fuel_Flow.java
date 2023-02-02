package tests.UITests.EASEYIn_Emissioners.monPlan.systems.fuelFlows;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_TC1772_Edit_System_Fuel_Flow extends UiReusableComponents {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans

        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        waitFor(monitoringPlansPage.usernameFieldModal);
        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        waitFor(monitoringPlansPage.passwordFieldModal);
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
        input(monitoringPlansPage.filterByKeywordBox, "Palomar Energy Center");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Palomar Energy Center (Oris Code 55985)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
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

        waitFor(monitoringPlansPage.monitoringSystems);
        click(monitoringPlansPage.monitoringSystems);

        waitFor(monitoringPlansPage.monitoringSystemTypeTableLabel);
        verifyEquals(monitoringPlansPage.monitoringSystemTypeTableLabel, "System Type");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "System: GAS");

        waitFor(driver -> monitoringPlansPage.systemFuelFlowsHeader.size() > 1);
        verifyEquals(monitoringPlansPage.systemFuelFlowsHeader.get(1), "Fuel Flows");

        waitFor(driver -> monitoringPlansPage.viewButtonFuelFlow.size() > 8);

        String dateAndTime = monitoringPlansPage.dateAndTimeFuelFlow.get(8).getText();

        click(monitoringPlansPage.viewButtonFuelFlow.get(8));

        waitFor(monitoringPlansPage.modalEndDateField);
        input(monitoringPlansPage.modalStartTimeField, "1");
        input(monitoringPlansPage.modalEndDateField, "05/01/2022");
        input(monitoringPlansPage.modalEndTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.systemFuelFlowsHeader);

        Thread.sleep(2000);
        waitFor(driver -> monitoringPlansPage.viewButtonFuelFlow.size() > 8);
        verifyNotEquals(monitoringPlansPage.dateAndTimeFuelFlow.get(8).getText(), dateAndTime);

        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertOfficialRecordButton);
        verifyEquals(monitoringPlansPage.revertOfficialRecordButton, "Revert to Official Record");
        click(monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertModalYesButton);
        verifyEquals(monitoringPlansPage.revertModalYesButton, "Yes");
        click(monitoringPlansPage.revertModalYesButton);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.revertModalYesButton));

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
            js.executeScript("arguments[0].click();", monitoringPlansPage.logOutButton);
            waitFor(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        } else {
            isDisplayed(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        }
        super.afterMethod();
    }
}