package tests.UITests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_Show_Inactive extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        monitoringPlansPage.filterByKeywordBox.sendKeys("Barry");
        click(monitoringPlansPage.filterByKeywordButton);

        click(monitoringPlansPage.facilityCaretBarry);

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabBarry12CS0AAN);

        verifyEquals(monitoringPlansPage.accordionButtonMonPlan, "Methods");

        verifyFalse(monitoringPlansPage.showInactiveCheckbox.findElement(By.id("checkbox")).isSelected());
        click(monitoringPlansPage.showInactiveCheckbox);
        verifyTrue(monitoringPlansPage.showInactiveCheckbox.findElement(By.id("checkbox")).isSelected());

    }
}
