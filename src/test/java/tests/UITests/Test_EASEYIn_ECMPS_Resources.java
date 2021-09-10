package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_ECMPS_Resources extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // This is part of the message that appears when a page does not exist yet.
        String sorryMessage = "Sorry, but this web page does not exist.";

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageHeader, "Resources");

        verifyEquals(monitoringPlansPage.resourcesPageGlossaryHeader, "Glossary");
        verifyEquals(monitoringPlansPage.resourcesPageGlossaryLink, "Visit the Glossary");
        click(monitoringPlansPage.resourcesPageGlossaryLink);

        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageReportInstructionsHeader, "Reporting Instructions");
        verifyEquals(monitoringPlansPage.resourcesPageReportInstructionsLink, "Visit Reporting Instructions");
        click(monitoringPlansPage.resourcesPageReportInstructionsLink);

        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageCamApiHeader, "CAM API");
        verifyEquals(monitoringPlansPage.resourcesPageCamApiLink, "Visit CAM API");
        click(monitoringPlansPage.resourcesPageCamApiLink);

        verifyEquals(monitoringPlansPage.pageDoesntExist, sorryMessage);

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);
        waitFor(monitoringPlansPage.resourcesButton);
        verifyEquals(monitoringPlansPage.resourcesButton, "Resources");
        click(monitoringPlansPage.resourcesButton);

        verifyEquals(monitoringPlansPage.resourcesPageAdditionalResourcesHeader, "Additional Resources");

        verifyEquals(monitoringPlansPage.resourcesPageCdxLink, "CDX");

        verifyEquals(monitoringPlansPage.resourcesPageTutorialsLink, "Tutorials");

    }
}
