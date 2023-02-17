package tests.UITests.ECMPS.monPlan.methods;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_ECMPSUI_Fun_TC542_View_Supplemental_Method_Modal extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox,"Dolet Hills Power Station");
        click(monitoringPlansPage.filterByKeywordButton);

        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 0);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));


        waitFor(monitoringPlansPage.accordionSupplementalMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionSupplementalMethodsLabel, "Supplemental Methods");
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 8);
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.viewButton.get(8));

        verifyEquals(monitoringPlansPage.viewButton.get(8).getText(), "View");
        click(monitoringPlansPage.viewButton.get(8));

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Component: Monitoring MATS Methods");

    }
}
