package tests.UITests.EASEYIn_Emissioners.monPlan.rectangularDuctWAFs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC631_View_MP_Rectangular_Duct_WAFs_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        js.executeScript("window.scrollBy(0,350)", "");
        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringRectangularDuctWAFs);
        click(monitoringPlansPage.monitoringRectangularDuctWAFs);

        waitFor(monitoringPlansPage.accordionRectangularDuctWAFsLabel);
        verifyEquals(monitoringPlansPage.accordionRectangularDuctWAFsLabel, "WAFs Rectangular Duct");

        click(monitoringPlansPage.location.get(2));
        verifyEquals(monitoringPlansPage.location.get(2), "CS0AAN");

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.accordionRectangularDuctWAFsLabel);

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 0);
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Rectangular Duct WAF");

    }
}