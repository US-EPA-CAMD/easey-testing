package tests.UITests.ECMPS.monPlan.formulas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC403_View_MP_Formula_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        js.executeScript("window.scrollBy(0,250)", "");

        waitFor(monitoringPlansPage.monitoringFormulas);
        click(monitoringPlansPage.monitoringFormulas);
        verifyEquals(monitoringPlansPage.monitoringFormulas, "Formulas");

        click(monitoringPlansPage.location.get(0));
        verifyEquals(monitoringPlansPage.location.get(0), "1");

        waitFor(monitoringPlansPage.accordionFormulasLabel);
        verifyEquals(monitoringPlansPage.accordionFormulasLabel, "Formulas");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 2);
        verifyEquals(monitoringPlansPage.viewButton.get(0), "View");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        waitFor(monitoringPlansPage.monPlanModalHeaderLabel);
        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Formula");

    }
}