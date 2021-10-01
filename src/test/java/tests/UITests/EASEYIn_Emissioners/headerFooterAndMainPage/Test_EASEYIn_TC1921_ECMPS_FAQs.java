package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1921_ECMPS_FAQs extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.resourcesMenuHeader, "Resources");
        click(headerFooterAndHomePage.resourcesMenuHeader);

        verifyEquals(headerFooterAndHomePage.faqsButton, "FAQs");
        click(headerFooterAndHomePage.faqsButton);

        waitFor(headerFooterAndHomePage.faqsPageHeader);
        verifyEquals(headerFooterAndHomePage.faqsPageHeader, "FAQs");

        verifyEquals(headerFooterAndHomePage.faqsPageMonPanHeader, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.faqsPageQAandCertificationsHeader, "QA & Certifications");

        verifyEquals(headerFooterAndHomePage.faqsPageEmissionsHeader, "Emissions");

        verifyFalse(isDisplayed(headerFooterAndHomePage.faqsPageAccordionContent.get(0)));
        click(headerFooterAndHomePage.faqsPageAccordionButton.get(0));
        verifyTrue(isDisplayed(headerFooterAndHomePage.faqsPageAccordionContent.get(0)));

        // Opening second accordion
        verifyFalse(isDisplayed(headerFooterAndHomePage.faqsPageAccordionContent.get(1)));
        click(headerFooterAndHomePage.faqsPageAccordionButton.get(1));
        verifyTrue(isDisplayed(headerFooterAndHomePage.faqsPageAccordionContent.get(1)));

        // The system allows more than one accordion to be open at once,
        // This verifies that the first accordion is still open
        verifyTrue(isDisplayed(headerFooterAndHomePage.faqsPageAccordionContent.get(0)));

    }
}
