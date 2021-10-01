package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1922_ECMPS_HomeLanding_Page extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        // This is part of the message that appears when a page does not exist yet.
        String sorryMessage = "Sorry, but this web page does not exist.";

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.dashHomeTitle, "Home");
        click(headerFooterAndHomePage.dashHomeTitle);

        verifyEquals(headerFooterAndHomePage.homePgAboutEcmpsHeader, "About ECMPS");

        verifyEquals(headerFooterAndHomePage.homePgMonPlansHeader, "Monitoring Plans");
        verifyEquals(headerFooterAndHomePage.homePgViewMonPlansLink, "View Monitoring Plans");
        click(headerFooterAndHomePage.homePgViewMonPlansLink);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        click(headerFooterAndHomePage.dashHomeTitle);

        verifyEquals(headerFooterAndHomePage.homePgQaCertHeader, "QA & Certifications");
        verifyEquals(headerFooterAndHomePage.homePgViewQaCertLink, "View QA & Certifications");
        click(headerFooterAndHomePage.homePgViewQaCertLink);

        verifyEquals(headerFooterAndHomePage.pageDoesntExist, sorryMessage);

        click(headerFooterAndHomePage.dashHomeTitle);

        verifyEquals(headerFooterAndHomePage.homePgEmissionsHeader, "Emissions");
        verifyEquals(headerFooterAndHomePage.homePgViewEmissionsLink, "View Emissions");
        click(headerFooterAndHomePage.homePgViewEmissionsLink);

        verifyEquals(headerFooterAndHomePage.pageDoesntExist, sorryMessage);

        click(headerFooterAndHomePage.dashHomeTitle);

        verifyEquals(headerFooterAndHomePage.homePgWhatsNewHeader, "What's New");

    }
}
