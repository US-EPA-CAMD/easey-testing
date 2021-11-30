package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC1921_ECMPS_FAQs extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.resourcesMenuHeader, "Resources");
        click(monitoringPlansPage.resourcesMenuHeader);

        waitFor(monitoringPlansPage.faqsButton);
        verifyEquals(monitoringPlansPage.faqsButton, "FAQs");
        click(monitoringPlansPage.faqsButton);

        waitFor(monitoringPlansPage.faqsPageHeader);
        verifyEquals(monitoringPlansPage.faqsPageHeader, "FAQs");

        verifyEquals(monitoringPlansPage.faqsPageMonPanHeader, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.faqsPageQAandCertificationsHeader, "QA & Certifications");

        verifyEquals(monitoringPlansPage.faqsPageEmissionsHeader, "Emissions");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        verifyFalse(isDisplayed(monitoringPlansPage.faqsPageAccordionContent.get(0)));
        click(monitoringPlansPage.faqsPageAccordionButton.get(0));
        verifyTrue(isDisplayed(monitoringPlansPage.faqsPageAccordionContent.get(0)));

        // Opening second accordion
        verifyFalse(isDisplayed(monitoringPlansPage.faqsPageAccordionContent.get(1)));
        click(monitoringPlansPage.faqsPageAccordionButton.get(1));
        verifyTrue(isDisplayed(monitoringPlansPage.faqsPageAccordionContent.get(1)));

        // The system allows more than one accordion to be open at once,
        // This verifies that the first accordion is still open
        verifyTrue(isDisplayed(monitoringPlansPage.faqsPageAccordionContent.get(0)));

    }
}
