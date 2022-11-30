package tests.UITests.EASEYIn_Emissioners.monPlan.qualifications.qualLee;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2127_Edit_Monitoring_Qual_LEE_Data extends EmMonPlanReusables {

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
        input(monitoringPlansPage.filterByKeywordBox, "Seminole");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Seminole (Oris Code 136)
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

        waitFor(monitoringPlansPage.qualLeeParameterCodeTableHeader);
        verifyEquals(monitoringPlansPage.qualLeeParameterCodeTableHeader, "Parameter Code");

        String parameterCode = monitoringPlansPage.qualLeeParameterCodeTableField.get(2).getText();

        Thread.sleep(4000);
        waitFor(driver -> monitoringPlansPage.viewEditQualLeeBtn.size() > 0);
        verifyEquals(monitoringPlansPage.viewEditQualLeeBtn.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewEditQualLeeBtn.get(0));

        waitFor(monitoringPlansPage.qualificationsModalSubHeaders);
        verifyEquals(monitoringPlansPage.qualificationsModalSubHeaders, "Qualification LEE");
        if (parameterCode.equals("HG")) {
            waitFor(monitoringPlansPage.qualLeeParameterCodeDropdown);
            click(monitoringPlansPage.qualLeeParameterCodeDropdown.get(1));
//            js.executeScript("arguments[0].click();", monitoringPlansPage.qualLeeParameterCodeDropdown.get(1));
        } else {
            waitFor(monitoringPlansPage.qualLeeParameterCodeDropdown);
            click(monitoringPlansPage.qualLeeParameterCodeDropdown.get(2));
        }

        verifyEquals(monitoringPlansPage.saveCloseModal, "Save and Close");
        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewEditQualLeeBtn);

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.qualLeeParameterCodeTableField.get(2));
        verifyNotEquals(monitoringPlansPage.qualLeeParameterCodeTableField.get(2).getText(), parameterCode);

        // Waiting for clicking Save and Close button
        waitFor(monitoringPlansPage.saveCloseModal);
        verifyEquals(monitoringPlansPage.saveCloseModal, "Save and Close");
        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

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