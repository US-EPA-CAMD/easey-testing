package tests.UITests.EASEYIn_Emissioners.monPlan.qualifications.qualPercent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2123_Edit_Monitoring_Qual_Percent_Data extends UITestBase {

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
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Wallingford Energy");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Wallingford Energy (Oris Code 55517)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringQualifications);
        click(monitoringPlansPage.monitoringQualifications);

        waitFor(monitoringPlansPage.accordionQualificationsLabel);
        verifyEquals(monitoringPlansPage.accordionQualificationsLabel, "Qualifications");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        js.executeScript("window.scrollBy(0,200)", "");

        waitFor(monitoringPlansPage.qualificationTypeCodeLabel);
        verifyEquals(monitoringPlansPage.qualificationTypeCodeLabel, "Qualification Type Code");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Qualification");

        waitFor(driver -> monitoringPlansPage.qualificationsHeaders.size() > 2);

        waitFor(monitoringPlansPage.qualPercentQualYearTableHeader.get(0));
        verifyEquals(monitoringPlansPage.qualPercentQualYearTableHeader.get(0), "Qualification Year");

        String qualYear = monitoringPlansPage.qualPercentQualYearTableField.get(1).getText();

        waitFor(driver -> monitoringPlansPage.viewEditQualPercentBtn.size() > 1);
        verifyEquals(monitoringPlansPage.viewEditQualPercentBtn.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewEditQualPercentBtn.get(0));

        waitFor(monitoringPlansPage.qualificationsModalSubHeaders);
        verifyEquals(monitoringPlansPage.qualificationsModalSubHeaders, "Qualification Percent");
        if (qualYear.equals("2021")) {
            waitFor(monitoringPlansPage.qualPercentQualYearDropdown);
            click(monitoringPlansPage.qualPercentQualYearDropdown.get(1));
        } else {
            waitFor(monitoringPlansPage.qualPercentQualYearDropdown);
            click(monitoringPlansPage.qualPercentQualYearDropdown.get(22));
        }

        verifyEquals(monitoringPlansPage.saveCloseModal, "Save and Close");
        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewEditQualLeeBtn);

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.qualPercentQualYearTableField.get(1));
        verifyNotEquals(monitoringPlansPage.qualPercentQualYearTableField.get(1).getText(), qualYear);

        // Waiting for clicking Save and Close button
        waitFor(monitoringPlansPage.saveCloseModal);
        verifyEquals(monitoringPlansPage.saveCloseModal, "Save and Close");
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

        // These steps closes the tab and automatically Checks Back In the configuration
        click(monitoringPlansPage.closeConfigTab.get(0));
        waitFor(monitoringPlansPage.selectConfigurationsLabel);
        verifyTrue(isDisplayed(monitoringPlansPage.selectConfigurationsLabel));

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