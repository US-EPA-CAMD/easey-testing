package tests.UITests.EASEYIn_Emissioners.headerAndFooterAndMainPage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_ECMPS_Header extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyTrue(isDisplayed(monitoringPlansPage.ecmpsHeaderImage));

        verifyTrue(isDisplayed(monitoringPlansPage.ecmpsHeaderLabel));

        verifyEquals(monitoringPlansPage.ecmpsHeaderResourcesLabel.get(0), "Resources");

        verifyEquals(monitoringPlansPage.ecmpsHeaderHelpAndSupportLabel.get(1), "|Help/Support");

        verifyEquals(monitoringPlansPage.ecmpsHeaderRegulatoryPartnersLabel.get(2), "|Regulatory Partners");

        verifyEquals(monitoringPlansPage.ecmpsHeaderSiteMapLabel, "|Site Map");

    }
}
