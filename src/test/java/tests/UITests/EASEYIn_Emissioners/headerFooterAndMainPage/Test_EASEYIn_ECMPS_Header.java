package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_ECMPS_Header extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);


        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyTrue(isDisplayed(headerFooterAndHomePage.ecmpsHeaderImage));

        verifyTrue(isDisplayed(headerFooterAndHomePage.ecmpsHeaderLabel));

        verifyEquals(headerFooterAndHomePage.ecmpsHeaderResourcesLabel.get(0), "Resources");

        verifyEquals(headerFooterAndHomePage.ecmpsHeaderHelpAndSupportLabel.get(1), "|Help/Support");

        verifyEquals(headerFooterAndHomePage.ecmpsHeaderRegulatoryPartnersLabel.get(2), "|Regulatory Partners");

        verifyEquals(headerFooterAndHomePage.ecmpsHeaderSiteMapLabel, "|Site Map");

    }
}
