package tests.UITests.EASEYIn_Emissioners.monPlan.rectangularDuctWAFs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1808_Create_MP_Rectangular_Duct_WAFs_Data extends EmMonPlanReusables {

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
        input(monitoringPlansPage.filterByKeywordBox, "Martin Drake");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Martin Drake (Oris Code 492)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringRectangularDuctWAFs);
        click(monitoringPlansPage.monitoringRectangularDuctWAFs);

        waitFor(monitoringPlansPage.accordionRectangularDuctWAFsLabel);
        verifyEquals(monitoringPlansPage.accordionRectangularDuctWAFsLabel, "WAFs Rectangular Duct");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionRectangularDuctWAFsLabel);

        js.executeScript("document.body.style.zoom = '0.8'");
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int numOfDuctWAFs = monitoringPlansPage.viewButton.size();
        js.executeScript("document.body.style.zoom = '1'");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createRectangularDuctWafBtn);
        waitFor(monitoringPlansPage.createRectangularDuctWafBtn);
        click(monitoringPlansPage.createRectangularDuctWafBtn);

        waitFor(monitoringPlansPage.wafMethodModalDropdown);
        click(monitoringPlansPage.wafMethodModalDropdown.get(1));
        input(monitoringPlansPage.wafValueModalField, "10");
        input(monitoringPlansPage.modalStartDateField, "12/01/2021");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);

        js.executeScript("document.body.style.zoom = '0.8'");
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int newNumOfDuctWAFs = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfDuctWAFs == numOfDuctWAFs + 1);
        js.executeScript("document.body.style.zoom = '1'");

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