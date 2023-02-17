package tests.UITests.ECMPS.monPlan.loads;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_TC1711_Edit_MP_Load_Data extends UiReusableComponents {

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
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Holcomb (Oris Code 8906)
        waitFor(monitoringPlansPage.facilityCaret);
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
        click(monitoringPlansPage.configcheckOutButton);

        waitFor(monitoringPlansPage.configcheckBackInButton);
        System.out.println(monitoringPlansPage.configcheckBackInButton.isDisplayed());
        System.out.println(monitoringPlansPage.configcheckBackInButton.isEnabled());
        verifyEquals(monitoringPlansPage.configcheckBackInButton, "Check Back In");

        click(monitoringPlansPage.monitoringLoads);
        verifyEquals(monitoringPlansPage.accordionLoadsLabel, "Loads");

        // This wait is needed inorder to allow the View button to change from View to View / Edit
        waitFor(monitoringPlansPage.revertOfficialRecordButton);

        js.executeScript("window.scrollBy(0,200)", "");

        waitFor(monitoringPlansPage.LoadsTableMaxLoadValLabel);
        verifyEquals(monitoringPlansPage.LoadsTableMaxLoadValLabel, "Maximum Load Value");

        String maxLoadVal = monitoringPlansPage.LoadsTableMaxLoadValField.get(0).getText();

        js.executeScript("document.body.style.zoom = '0.7'");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        js.executeScript("arguments[0].click();", monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Load");

        waitFor(monitoringPlansPage.LoadsModalMaxLoadValField);
        if (maxLoadVal.equals("1")) {
            monitoringPlansPage.LoadsModalMaxLoadValField.clear();
            input(monitoringPlansPage.LoadsModalMaxLoadValField, "2");
        } else {
            monitoringPlansPage.LoadsModalMaxLoadValField.clear();
            input(monitoringPlansPage.LoadsModalMaxLoadValField, "1");
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        js.executeScript("arguments[0].click();", monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        js.executeScript("document.body.style.zoom = '1'");

        Thread.sleep(2000);
        waitFor(monitoringPlansPage.LoadsTableMaxLoadValField.get(0));
        verifyNotEquals(monitoringPlansPage.LoadsTableMaxLoadValField.get(0).getText(), maxLoadVal);

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