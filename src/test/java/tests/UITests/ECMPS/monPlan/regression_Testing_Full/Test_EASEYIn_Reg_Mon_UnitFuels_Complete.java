package tests.UITests.ECMPS.monPlan.regression_Testing_Full;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.UITests.UiReusableComponents.UiReusableComponents;

public class Test_EASEYIn_Reg_Mon_UnitFuels_Complete extends UiReusableComponents {

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MOSES_TESTING_USERNAME");
        String password = System.getenv("MOSES_TESTING_PASSWORD");

        //Navigate to EASEY In
        //https://ecmps-dev.app.cloud.gov/monitoring-plans

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
        waitFor(driver -> !isDisplayed(monitoringPlansPage.logInAuthenticationImg));

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(monitoringPlansPage.title);

        waitFor(monitoringPlansPage.workspaceMonPlan);
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "E C Gaston");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on E C Gaston (Oris Code 26)
        Thread.sleep(500);
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringUnitInformation);
        click(monitoringPlansPage.monitoringUnitInformation);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        waitFor(monitoringPlansPage.accordionUnitFuelsLabel);
        verifyEquals(monitoringPlansPage.accordionUnitFuelsLabel, "Unit Fuels");

        // Start of View
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        Thread.sleep(1000);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionUnitFuelsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Unit Fuel");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.closeModal);
        waitFor(monitoringPlansPage.closeModal);
        click(monitoringPlansPage.closeModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.closeModal));

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
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

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));

        // Start of Create
        waitFor(monitoringPlansPage.accordionUnitFuelsLabel);
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionUnitFuelsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 3);

        int numOfUnits = monitoringPlansPage.viewButton.size();

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.createUnitFuelsButton);
        waitFor(monitoringPlansPage.createUnitFuelsButton);
        click(monitoringPlansPage.createUnitFuelsButton);

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Create Unit Fuel");

        waitFor(monitoringPlansPage.fuelTypeUnitFuelDropdown);
        click(monitoringPlansPage.fuelTypeUnitFuelDropdown.get(1));

        waitFor(monitoringPlansPage.indicatorCodeUnitFuelsDropdown);
        click(monitoringPlansPage.indicatorCodeUnitFuelsDropdown.get(1));

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.modalStartDateFieldUnitFuel);
        waitFor(monitoringPlansPage.modalStartDateFieldUnitFuel);
        input(monitoringPlansPage.modalStartDateFieldUnitFuel, "06/01/2022");
        Thread.sleep(1000);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);
        Thread.sleep(3000);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionUnitFuelsLabel);

        waitFor(monitoringPlansPage.viewButton);
        Thread.sleep(3000);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);
        Thread.sleep(1000);

        int newNumOfUnits = monitoringPlansPage.viewButton.size();

        verifyTrue(newNumOfUnits == numOfUnits + 1);
        // End of Create

        // Start of Edit
        waitFor(monitoringPlansPage.indicatorCodeUnitFuelsHeader);
        verifyEquals(monitoringPlansPage.indicatorCodeUnitFuelsHeader.get(0), "Indicator Code");

        String indicatorCode = monitoringPlansPage.indicatorCodeUnitFuelsTableField.get(0).getText();

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View / Edit");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Unit Fuel");

        if (indicatorCode.equals("I")) {
            waitFor(monitoringPlansPage.indicatorCodeUnitFuelsDropdown);
            click(monitoringPlansPage.indicatorCodeUnitFuelsDropdown.get(2));
        } else {
            waitFor(monitoringPlansPage.indicatorCodeUnitFuelsDropdown);
            click(monitoringPlansPage.indicatorCodeUnitFuelsDropdown.get(1));
        }

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.saveCloseModal);
        waitFor(monitoringPlansPage.saveCloseModal);
        click(monitoringPlansPage.saveCloseModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));

        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage));
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);

        Thread.sleep(3000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.saveCloseModal));
        waitFor(monitoringPlansPage.indicatorCodeUnitFuelsTableField,2);
        verifyNotEquals(monitoringPlansPage.indicatorCodeUnitFuelsTableField.get(2).getText(), indicatorCode);
        // End of Edit

        // Evaluate starts here
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.evaluateButton);
        waitFor(monitoringPlansPage.evaluateButton);
        click(monitoringPlansPage.evaluateButton);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInQueue), 180000);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.evalStatusInProgress));
        waitFor(monitoringPlansPage.evalStatusCriticalErrors, 180);
        waitFor(monitoringPlansPage.evalStatusCriticalErrors);
        verifyEquals(monitoringPlansPage.evalStatusCriticalErrors, "Critical Errors");
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