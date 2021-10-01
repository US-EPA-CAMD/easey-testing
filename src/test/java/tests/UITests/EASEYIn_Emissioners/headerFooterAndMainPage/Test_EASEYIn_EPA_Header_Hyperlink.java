package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_EPA_Header_Hyperlink extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        monitoringPlansPage.epaHeaderLogoAndHyperlink.isDisplayed();

        click(monitoringPlansPage.epaHeaderLogoAndHyperlink);

        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/");

    }
}
