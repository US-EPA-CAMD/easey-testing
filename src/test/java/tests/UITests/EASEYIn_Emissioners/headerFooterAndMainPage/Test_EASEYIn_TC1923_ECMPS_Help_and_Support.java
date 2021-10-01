package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1923_ECMPS_Help_and_Support extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.helpSupportMenuHeader, "|Help/Support");
        click(headerFooterAndHomePage.helpSupportMenuHeader);

        waitFor(headerFooterAndHomePage.helpSupportButton);
        verifyEquals(headerFooterAndHomePage.helpSupportButton, "Help/Support");
        click(headerFooterAndHomePage.helpSupportButton);

        verifyEquals(headerFooterAndHomePage.helpSupportPageHeader, "Help/Support");

        verifyEquals(headerFooterAndHomePage.helpSupportPageFaqsHeader, "FAQs");

        verifyEquals(headerFooterAndHomePage.helpSupportPageVisitFaqsButton, "Visit FAQs");
        click(headerFooterAndHomePage.helpSupportPageVisitFaqsButton);

        verifyEquals(headerFooterAndHomePage.faqsPageHeader,"FAQs");

        click(headerFooterAndHomePage.helpSupportMenuHeader);
        click(headerFooterAndHomePage.helpSupportButton);
        verifyEquals(headerFooterAndHomePage.helpSupportPageHeader, "Help/Support");

        verifyEquals(headerFooterAndHomePage.helpSupportPageTutorialsHeader, "Tutorials");

        verifyEquals(headerFooterAndHomePage.helpSupportPageCdxHelpLink, "CDX Help Topics");

        verifyEquals(headerFooterAndHomePage.helpSupportPageContactUsHeader, "Contact Us");

        verifyEquals(headerFooterAndHomePage.helpSupportPageSubmitButton, "Submit");

    }
}
