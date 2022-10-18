package tests.UITests.EASEYIn_Emissioners.monPlan.unitInformation.unitControls;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC2130_View_MP_Unit_Control_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox, "Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        waitFor(monitoringPlansPage.monitoringUnitInformation);
        click(monitoringPlansPage.monitoringUnitInformation);
        verifyEquals(monitoringPlansPage.monitoringUnitInformation, "Unit Information");

        waitFor(monitoringPlansPage.accordionUnitControlsLabel);
        verifyEquals(monitoringPlansPage.accordionUnitControlsLabel, "Unit Controls");

        click(monitoringPlansPage.location.get(1));
        verifyEquals(monitoringPlansPage.location.get(1), "2");

        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        action.moveToElement(monitoringPlansPage.viewButton.get(2)).click().build().perform();

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Unit Control");

    }
}