package tests.UITests.EASEYIn_Emissioners.monPlan.unitInformation.unitCapacity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables.EmMonPlanReusables;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1721_Edit_MP_Unit_Capacity_Data extends EmMonPlanReusables {

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
        input(monitoringPlansPage.filterByKeywordBox, "E C Gaston");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on E C Gaston (Oris Code 26)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringUnitInformation);
        click(monitoringPlansPage.monitoringUnitInformation);
        verifyEquals(monitoringPlansPage.monitoringUnitInformation, "Unit Information");

        waitFor(monitoringPlansPage.accordionUnitCapacitiesLabel);
        verifyEquals(monitoringPlansPage.accordionUnitCapacitiesLabel, "Unit Capacities");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.maxHourlyHeatInputCapacityHeader);
        verifyEquals(monitoringPlansPage.maxHourlyHeatInputCapacityHeader.get(2), "Maximum Hourly Heat Input Capacity");


        String maxHeatInputCap = monitoringPlansPage.maxHourlyHeatInputCapacityTableField.get(4).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);
        verifyEquals(monitoringPlansPage.viewButton.get(4).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(4));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Unit Capacity");

        if (maxHeatInputCap.equals("5462")) {
            waitFor(monitoringPlansPage.maxHourlyHeatInputCapacityField);
            monitoringPlansPage.maxHourlyHeatInputCapacityField.clear();
            input(monitoringPlansPage.maxHourlyHeatInputCapacityField, "1");
        } else {
            waitFor(monitoringPlansPage.maxHourlyHeatInputCapacityField);
            monitoringPlansPage.maxHourlyHeatInputCapacityField.clear();
            input(monitoringPlansPage.maxHourlyHeatInputCapacityField, "5462");
        }

        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);

        Thread.sleep(3000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));
        waitFor(monitoringPlansPage.maxHourlyHeatInputCapacityHeader,1);
        verifyNotEquals(monitoringPlansPage.maxHourlyHeatInputCapacityTableField.get(4).getText(), maxHeatInputCap);

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