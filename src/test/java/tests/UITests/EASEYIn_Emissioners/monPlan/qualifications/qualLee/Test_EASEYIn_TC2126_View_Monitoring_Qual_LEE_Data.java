package tests.UITests.EASEYIn_Emissioners.monPlan.qualifications.qualLee;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2126_View_Monitoring_Qual_LEE_Data extends UITestBase {

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
        input(monitoringPlansPage.filterByKeywordBox, "Hayden");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Hayden (Oris Code 525)
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
        verifyEquals(monitoringPlansPage.location.get(0), "H1");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        Thread.sleep(1000); // Maybe a better option can be found other than Thread.sleep();
        verifyEquals(monitoringPlansPage.viewButton.get(0).getText(), "View");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Qualification");

        waitFor(monitoringPlansPage.qualificationsHeaders, 2);
        verifyEquals(monitoringPlansPage.qualificationsHeaders.get(1), "Qualification LEE");

        waitFor(driver -> monitoringPlansPage.viewEditQualLeeBtn.size() > 0);
        verifyEquals(monitoringPlansPage.viewEditQualLeeBtn.get(0), "View");
        Thread.sleep(1000); // Maybe a better option can be found other than Thread.sleep();
        action.moveToElement(monitoringPlansPage.viewEditQualLeeBtn.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        waitFor(monitoringPlansPage.createModalSubHeader);
        verifyEquals(monitoringPlansPage.createModalSubHeader, "Qualification LEE");

    }
}
