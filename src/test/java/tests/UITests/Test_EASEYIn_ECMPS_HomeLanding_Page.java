package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_ECMPS_HomeLanding_Page extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashHomeTitle, "Home");
        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgAboutEcmpsHeader, "About ECMPS");
        verifyEquals(monitoringPlansPage.homePgMonPlansHeader, "Monitoring Plans");
        verifyEquals(monitoringPlansPage.homePgViewMonPlansLink, "View Monitoring Plans");
        verifyEquals(monitoringPlansPage.homePgQaCertHeader, "QA & Certifications");
        verifyEquals(monitoringPlansPage.homePgViewQaCertLink, "View QA & Certifications");
        verifyEquals(monitoringPlansPage.homePgEmissionsHeader, "Emissions");
        verifyEquals(monitoringPlansPage.homePgViewEmissionsLink, "View Emissions");
        verifyEquals(monitoringPlansPage.homePgWhatsNewHeader, "What's New");


    }
}
