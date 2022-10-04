package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1922_ECMPS_HomeLanding_Page extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.dashHomeTitle, "Home");
        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgAboutEcmpsHeader, "About ECMPS");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        verifyEquals(monitoringPlansPage.homePgMonPlansHeader, "Monitoring Plans");
        verifyEquals(monitoringPlansPage.homePgViewMonPlansLink, "View Monitoring Plans");
        click(monitoringPlansPage.homePgViewMonPlansLink);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        click(monitoringPlansPage.dashHomeTitle);

        js.executeScript("window.scrollBy(0,250)", "");

        verifyEquals(monitoringPlansPage.homePgQaCertHeader, "QA & Certifications");
        verifyEquals(monitoringPlansPage.homePgViewQaCertLink, "View QA & Certifications");
        click(monitoringPlansPage.homePgViewQaCertLink);

        verifyEquals(monitoringPlansPage.comingSoon, "Coming Soon");

        click(monitoringPlansPage.dashHomeTitle);

        js.executeScript("window.scrollBy(0,500)", "");

        waitFor(monitoringPlansPage.homePgEmissionsHeader);
        verifyEquals(monitoringPlansPage.homePgEmissionsHeader, "Emissions");
        verifyEquals(monitoringPlansPage.homePgViewEmissionsLink, "View Emissions");
        click(monitoringPlansPage.homePgViewEmissionsLink);

        verifyEquals(monitoringPlansPage.comingSoon, "Coming Soon");

        click(monitoringPlansPage.dashHomeTitle);

        verifyEquals(monitoringPlansPage.homePgWhatsNewHeader, "What's New");

    }
}
