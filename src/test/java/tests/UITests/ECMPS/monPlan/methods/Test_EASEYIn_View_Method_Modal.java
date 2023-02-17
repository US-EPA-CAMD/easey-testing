package tests.UITests.ECMPS.monPlan.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_View_Method_Modal extends UITestBase {

    @Test
    public void test() throws InterruptedException {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordButton);
        input(monitoringPlansPage.filterByKeywordBox,"Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        waitFor(monitoringPlansPage.selectConfigurationsLabel);
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.selectConfigurationsLabel);

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        waitFor(driver -> monitoringPlansPage.configTabs.size() > 2);
        click(monitoringPlansPage.configTabs.get(0));

        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.accordionMethodsLabel);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);

        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");
        verifyEquals(monitoringPlansPage.closeModal, "Close");
        click(monitoringPlansPage.closeModal);

        waitFor(driver -> !isDisplayed(monitoringPlansPage.closeModal));
        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.accordionMethodsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 4);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        click(monitoringPlansPage.viewButton.get(0));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Method");

        waitFor(monitoringPlansPage.xOutModal);
        click(monitoringPlansPage.xOutModal);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.closeModal));

        verifyFalse(isDisplayed(monitoringPlansPage.monPlanModalHeaderLabel));

    }
}
