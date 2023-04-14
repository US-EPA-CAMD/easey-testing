package tests.UITests.ECMPS.monPlan.regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_LocAttributes_Complete extends UiReusableComponents {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("TESTING_USERNAME");
        String password = System.getenv("TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

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

        waitFor(monitoringPlansPage.workspaceMonPlan);
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Astoria Generating Station");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Martin Drake (Oris Code 492)
        Thread.sleep(500);
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringLocationAttributesAndRelationships);
        click(monitoringPlansPage.monitoringLocationAttributesAndRelationships);

        waitFor(monitoringPlansPage.accordionLocationAttributesLabel);
        verifyEquals(monitoringPlansPage.accordionLocationAttributesLabel, "Location Attributes");
        Thread.sleep(1000);

        // Start of View
        waitFor(monitoringPlansPage.accordionRelationshipsDataLabel);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionRelationshipsDataLabel);

        Thread.sleep(4000);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Location Attribute");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.closeModal);
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

        // Start of Edit
        waitFor(monitoringPlansPage.createLocationAttributeBTN);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createLocationAttributeBTN);

        waitFor(monitoringPlansPage.locAttributesGroundElevationTableField.get(2));
        String groundElevationData = monitoringPlansPage.locAttributesGroundElevationTableField.get(2).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        js.executeScript("arguments[0].click();", monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Location Attribute");

        waitFor(monitoringPlansPage.locAttributesGroundElevationModalField);
        monitoringPlansPage.locAttributesGroundElevationModalField.clear();
        if (groundElevationData.equals("14")) {
            input(monitoringPlansPage.locAttributesGroundElevationModalField, "10");
        } else {
            input(monitoringPlansPage.locAttributesGroundElevationModalField, "14");
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        js.executeScript("arguments[0].click();", monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        waitFor(monitoringPlansPage.createLocationAttributeBTN);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createLocationAttributeBTN);

        Thread.sleep(3000);
        waitFor(monitoringPlansPage.locAttributesGroundElevationTableField.get(2));
        verifyNotEquals(monitoringPlansPage.locAttributesGroundElevationTableField.get(2).getText(), groundElevationData);
        // End of Edit

        // Start of Create
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionLocationAttributesLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int numOfAttributes = monitoringPlansPage.viewButton.size();

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createLocationAttributeBTN);
        waitFor(monitoringPlansPage.createLocationAttributeBTN);
        click(monitoringPlansPage.createLocationAttributeBTN);

        waitFor(monitoringPlansPage.locAttributesGroundElevationModalField);
        monitoringPlansPage.locAttributesGroundElevationModalField.clear();
        input(monitoringPlansPage.locAttributesGroundElevationModalField, "10");
        input(monitoringPlansPage.modalStartDateField, "01/01/2022");

        click(monitoringPlansPage.saveCloseModal);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        int newNumOfAttributes = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfAttributes == numOfAttributes + 1);
        // End of Create

        // Evaluate starts here
/**
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
        waitFor(monitoringPlansPage.evaluateButton);
        click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue), 180000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusCriticalErrors, 180000);
        waitFor(monitoringPlansPage.evalStatusCriticalErrors);
        verifyEquals(monitoringPlansPage.evalStatusCriticalErrors, "Critical Errors");
 **/
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