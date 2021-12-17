package tests.UITests.EASEYIn_Emissioners.monPlan.qualifications.qualPercent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2122_View_Monitoring_Qual_Percent_Data extends UITestBase {

    @Test
    public void test() throws InterruptedException {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.title);

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Smith Generating Facility");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Smith Generating Facility (Oris Code 54)
        click(monitoringPlansPage.facilityCaret.get(0));

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        waitFor(monitoringPlansPage.configTabs);
        click(monitoringPlansPage.configTabs.get(0));

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringQualifications);
        click(monitoringPlansPage.monitoringQualifications);

        waitFor(monitoringPlansPage.accordionQualificationsLabel);
        verifyEquals(monitoringPlansPage.accordionQualificationsLabel, "Qualifications");

        waitFor(monitoringPlansPage.location);
        click(monitoringPlansPage.location.get(0));
        verifyEquals(monitoringPlansPage.location.get(0), "SCT1");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Qualification");

        waitFor(driver -> monitoringPlansPage.qualificationsHeaders.size() > 2);
        verifyEquals(monitoringPlansPage.qualificationsHeaders.get(0), "Qualification Percent");

        waitFor(driver -> monitoringPlansPage.viewButtonbtnOpenQualificationPerc.size() > 14);
        Thread.sleep(1000); // Maybe a better option can be found other than Thread.sleep();
        verifyEquals(monitoringPlansPage.viewButtonbtnOpenQualificationPerc.get(0), "View");
        action.moveToElement(monitoringPlansPage.viewButtonbtnOpenQualificationPerc.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        waitFor(monitoringPlansPage.qualificationsViewModalHeader);
        verifyEquals(monitoringPlansPage.qualificationsViewModalHeader, "Qualification Percent");

    }
}
