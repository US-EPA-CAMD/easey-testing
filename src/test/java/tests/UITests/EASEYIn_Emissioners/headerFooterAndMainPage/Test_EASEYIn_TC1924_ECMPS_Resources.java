package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1924_ECMPS_Resources extends UITestBase {

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

        verifyEquals(headerFooterAndHomePage.resourcesMenuHeader, "Resources");
        click(headerFooterAndHomePage.resourcesMenuHeader);
        waitFor(headerFooterAndHomePage.resourcesButton);
        verifyEquals(headerFooterAndHomePage.resourcesButton, "Resources");
        click(headerFooterAndHomePage.resourcesButton);

        verifyEquals(headerFooterAndHomePage.resourcesPageHeader, "Resources");

        verifyEquals(headerFooterAndHomePage.resourcesPageGlossaryHeader, "Glossary");
        verifyEquals(headerFooterAndHomePage.resourcesPageGlossaryLink, "Visit the Glossary");
        click(headerFooterAndHomePage.resourcesPageGlossaryLink);

        verifyEquals(headerFooterAndHomePage.pageDoesntExist, sorryMessage);

        verifyEquals(headerFooterAndHomePage.resourcesMenuHeader, "Resources");
        click(headerFooterAndHomePage.resourcesMenuHeader);
        waitFor(headerFooterAndHomePage.resourcesButton);
        verifyEquals(headerFooterAndHomePage.resourcesButton, "Resources");
        click(headerFooterAndHomePage.resourcesButton);

        verifyEquals(headerFooterAndHomePage.resourcesPageReportInstructionsHeader, "Reporting Instructions");
        verifyEquals(headerFooterAndHomePage.resourcesPageReportInstructionsLink, "Visit Reporting Instructions");
        click(headerFooterAndHomePage.resourcesPageReportInstructionsLink);

        verifyEquals(headerFooterAndHomePage.pageDoesntExist, sorryMessage);

        verifyEquals(headerFooterAndHomePage.resourcesMenuHeader, "Resources");
        click(headerFooterAndHomePage.resourcesMenuHeader);
        waitFor(headerFooterAndHomePage.resourcesButton);
        verifyEquals(headerFooterAndHomePage.resourcesButton, "Resources");
        click(headerFooterAndHomePage.resourcesButton);

        verifyEquals(headerFooterAndHomePage.resourcesPageCamApiHeader, "CAM API");
        verifyEquals(headerFooterAndHomePage.resourcesPageCamApiLink, "Visit CAM API");
        click(headerFooterAndHomePage.resourcesPageCamApiLink);

        verifyEquals(headerFooterAndHomePage.pageDoesntExist, sorryMessage);

        verifyEquals(headerFooterAndHomePage.resourcesMenuHeader, "Resources");
        click(headerFooterAndHomePage.resourcesMenuHeader);
        waitFor(headerFooterAndHomePage.resourcesButton);
        verifyEquals(headerFooterAndHomePage.resourcesButton, "Resources");
        click(headerFooterAndHomePage.resourcesButton);

        verifyEquals(headerFooterAndHomePage.resourcesPageAdditionalResourcesHeader, "Additional Resources");

        verifyEquals(headerFooterAndHomePage.resourcesPageCdxLink, "CDX");

        verifyEquals(headerFooterAndHomePage.resourcesPageTutorialsLink, "Tutorials");

    }
}
