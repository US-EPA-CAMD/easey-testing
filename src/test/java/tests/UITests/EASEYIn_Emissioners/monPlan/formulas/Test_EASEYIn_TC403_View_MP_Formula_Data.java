package tests.UITests.EASEYIn_Emissioners.monPlan.formulas;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC403_View_MP_Formula_Data extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        Actions action = new Actions(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        input(monitoringPlansPage.filterByKeywordBox, "Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Barry (Oris Code 3)
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        waitFor(monitoringPlansPage.accordionMethodsLabel);
        verifyEquals(monitoringPlansPage.accordionMethodsLabel, "Methods");

        click(monitoringPlansPage.monitoringFormulas);
        verifyEquals(monitoringPlansPage.monitoringFormulas, "Formulas");

        waitFor(monitoringPlansPage.accordionFormulasLabel);
        verifyEquals(monitoringPlansPage.accordionFormulasLabel, "Formulas");

        click(monitoringPlansPage.location.get(0));
        verifyEquals(monitoringPlansPage.location.get(0), "1");

        verifyTrue(isDisplayed(monitoringPlansPage.viewButton.get(0)));
        click(monitoringPlansPage.accordionCollapseButtonMonPlan);
        verifyFalse(isDisplayed(monitoringPlansPage.monPlanActionsHeader));
        click(monitoringPlansPage.accordionExpandButtonMonPlan);
        waitFor(driver -> monitoringPlansPage.viewButton.size() > 1);
        verifyTrue(isDisplayed(monitoringPlansPage.viewButton.get(0)));

        verifyEquals(monitoringPlansPage.viewButton.get(0), "View");
        action.moveToElement(monitoringPlansPage.viewButton.get(0)).click().build().perform();

        verifyEquals(monitoringPlansPage.monPlanModalHeaderLabel, "Formula");

    }
}