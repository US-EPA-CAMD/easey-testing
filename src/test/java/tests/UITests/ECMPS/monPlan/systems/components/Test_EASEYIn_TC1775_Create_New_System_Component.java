package tests.UITests.ECMPS.monPlan.systems.components;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_TC1775_Create_New_System_Component extends UiReusableComponents {

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

        waitFor(monitoringPlansPage.passwordLabelModal);
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
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Astoria Generating Station (Oris Code 8906)
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

        click(monitoringPlansPage.monitoringSystems);
        waitFor(monitoringPlansPage.accordionSystemsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "System: 211");

        waitFor(monitoringPlansPage.systemComponentsHeader);
        verifyEquals(monitoringPlansPage.systemComponentsHeader, "System Components");

        int numOfComponents = monitoringPlansPage.viewButtonSystemComponents.size();

        waitFor(monitoringPlansPage.addComponentBtn);
        click(monitoringPlansPage.addComponentBtn);

        waitFor(monitoringPlansPage.createNewComponentBtn);
        click(monitoringPlansPage.createNewComponentBtn);

        waitFor(monitoringPlansPage.createModalSubHeader);
        verifyEquals(monitoringPlansPage.createModalSubHeader, "Create Component");

        input(monitoringPlansPage.componentIdFieldModal, "TES");

        waitFor(driver -> monitoringPlansPage.componentTypeDropdown.size() > 1);
        click(monitoringPlansPage.componentTypeDropdown.get(1));

        waitFor(driver -> monitoringPlansPage.componentSamDropdown.size() > 1);
        click(monitoringPlansPage.componentSamDropdown.get(1));

        waitFor(driver -> monitoringPlansPage.componentBasisDescriptionDropdown.size() > 1);
        click(monitoringPlansPage.componentBasisDescriptionDropdown.get(1));

        input(monitoringPlansPage.componentManufacturerFieldModal, "TEST Manu");

        input(monitoringPlansPage.componentModelVersionFieldModal, "TEST Mod & Ver");

        input(monitoringPlansPage.serialNumberFieldModal, "TES 12345");

        input(monitoringPlansPage.modalStartDateField,"03/01/2022");
        input(monitoringPlansPage.modalStartTimeField, "1");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(driver -> monitoringPlansPage.viewButtonSystemComponents.size() > 1);
        Thread.sleep(3000);

        int newNumOfComponents = monitoringPlansPage.viewButtonSystemComponents.size();

        verifyTrue(newNumOfComponents == numOfComponents + 1);

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