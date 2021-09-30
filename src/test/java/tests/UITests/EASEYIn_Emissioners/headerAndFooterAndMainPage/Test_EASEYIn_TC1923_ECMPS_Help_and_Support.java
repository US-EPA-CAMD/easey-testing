package tests.UITests.EASEYIn_Emissioners.headerAndFooterAndMainPage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1923_ECMPS_Help_and_Support extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.helpSupportMenuHeader, "|Help/Support");
        click(monitoringPlansPage.helpSupportMenuHeader);

        waitFor(monitoringPlansPage.helpSupportButton);
        verifyEquals(monitoringPlansPage.helpSupportButton, "Help/Support");
        click(monitoringPlansPage.helpSupportButton);

        verifyEquals(monitoringPlansPage.helpSupportPageHeader, "Help/Support");

        verifyEquals(monitoringPlansPage.helpSupportPageFaqsHeader, "FAQs");

        verifyEquals(monitoringPlansPage.helpSupportPageVisitFaqsButton, "Visit FAQs");
        click(monitoringPlansPage.helpSupportPageVisitFaqsButton);

        verifyEquals(monitoringPlansPage.faqsPageHeader,"FAQs");

        click(monitoringPlansPage.helpSupportMenuHeader);
        click(monitoringPlansPage.helpSupportButton);
        verifyEquals(monitoringPlansPage.helpSupportPageHeader, "Help/Support");

        verifyEquals(monitoringPlansPage.helpSupportPageTutorialsHeader, "Tutorials");

        verifyEquals(monitoringPlansPage.helpSupportPageCdxHelpLink, "CDX Help Topics");

        verifyEquals(monitoringPlansPage.helpSupportPageContactUsHeader, "Contact Us");

        verifyEquals(monitoringPlansPage.helpSupportPageSubmitButton, "Submit");

    }
}
