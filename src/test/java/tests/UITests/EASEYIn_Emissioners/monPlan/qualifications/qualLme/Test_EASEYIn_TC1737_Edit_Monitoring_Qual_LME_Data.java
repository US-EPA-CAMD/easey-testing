package tests.UITests.EASEYIn_Emissioners.monPlan.qualifications.qualLme;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1737_Edit_Monitoring_Qual_LME_Data extends UITestBase {

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
        input(monitoringPlansPage.filterByKeywordBox, "Cos Cob");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Cos Cob (Oris Code 542)
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

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Qualification");

        waitFor(driver -> monitoringPlansPage.qualificationsHeaders.size() > 2);

        waitFor(monitoringPlansPage.qualDataYearTableHeader);
        verifyEquals(monitoringPlansPage.qualDataYearTableHeader, "Qualification Data Year");

        String qualDataYear = monitoringPlansPage.qualDataYearTableField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewEditQualLmeBtn.size() > 0);
        verifyEquals(monitoringPlansPage.viewEditQualLmeBtn.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewEditQualLmeBtn.get(0));

        waitFor(monitoringPlansPage.qualificationsModalSubHeaders);
        verifyEquals(monitoringPlansPage.qualificationsModalSubHeaders, "Qualification LME");
        if (qualDataYear.equals("2011")) {
            waitFor(monitoringPlansPage.qualDataYearDropdown);
            click(monitoringPlansPage.qualDataYearDropdown.get(23));
        } else {
            waitFor(monitoringPlansPage.qualDataYearDropdown);
            click(monitoringPlansPage.qualDataYearDropdown.get(12));
        }

        verifyEquals(monitoringPlansPage.saveCloseModal, "Save and Close");
        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewEditQualLmeBtn);

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.qualDataYearTableField.get(1));
        verifyNotEquals(monitoringPlansPage.qualDataYearTableField.get(1).getText(), qualDataYear);

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