package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1924_ECMPS_Resources extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        String sorryMessage = "Sorry, but this web page does not exist.";

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.resourcesMenuHeader);
        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageHeader, "Resources");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        verifyEquals(monitoringPlansPage.resourcesPageGlossaryHeader, "Glossary");
        verifyEquals(monitoringPlansPage.resourcesPageGlossaryLink, "Visit the Glossary");
        click(monitoringPlansPage.resourcesPageGlossaryLink);

        verifyEquals(monitoringPlansPage.comingSoon, sorryMessage);

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        // Commented out code is being kept while changes are being made to the UI
//        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageReportInstructionsHeader, "Reporting Instructions");
        verifyEquals(monitoringPlansPage.resourcesPageReportInstructionsLink, "Visit Reporting Instructions");
        click(monitoringPlansPage.resourcesPageReportInstructionsLink);

        verifyEquals(monitoringPlansPage.comingSoon, "Coming Soon");

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
//        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageCamApiHeader, "CAM API");
        verifyEquals(monitoringPlansPage.resourcesPageCamApiLink, "Visit CAM API");
        click(monitoringPlansPage.resourcesPageCamApiLink);

        verifyEquals(monitoringPlansPage.comingSoon, "Coming Soon");

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
//        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageAdditionalResourcesHeader, "Additional Resources");

        verifyEquals(monitoringPlansPage.resourcesPageCdxLink, "CDX");

        verifyEquals(monitoringPlansPage.resourcesPageTutorialsLink, "Tutorials");

    }
}
