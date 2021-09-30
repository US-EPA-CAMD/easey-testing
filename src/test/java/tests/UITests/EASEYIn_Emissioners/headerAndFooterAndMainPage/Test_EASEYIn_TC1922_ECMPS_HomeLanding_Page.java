package tests.UITests.EASEYIn_Emissioners.headerAndFooterAndMainPage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1922_ECMPS_HomeLanding_Page extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // This is part of the message that appears when a page does not exist yet.
        String sorryMessage = "Sorry, but this web page does not exist.";

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashHomeTitle, "Home");
        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgAboutEcmpsHeader, "About ECMPS");

        verifyEquals(monitoringPlansPage.homePgMonPlansHeader, "Monitoring Plans");
        verifyEquals(monitoringPlansPage.homePgViewMonPlansLink, "View Monitoring Plans");
        click(monitoringPlansPage.homePgViewMonPlansLink);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgQaCertHeader, "QA & Certifications");
        verifyEquals(monitoringPlansPage.homePgViewQaCertLink, "View QA & Certifications");
        click(monitoringPlansPage.homePgViewQaCertLink);

        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgEmissionsHeader, "Emissions");
        verifyEquals(monitoringPlansPage.homePgViewEmissionsLink, "View Emissions");
        click(monitoringPlansPage.homePgViewEmissionsLink);

        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgWhatsNewHeader, "What's New");

    }
}
