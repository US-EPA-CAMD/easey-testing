package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class UI_TC95_813_Footer_Menu extends UITestBase {

    @Test
    public void test () {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

//        Verify that the EPA standard menu is available on the footer in accordance with the wireframes and acceptance criteria.
//
//
//                Menu is visible and correctly designed
        verifyTrue(monitoringPlansPage.footerMenuBTN.isDisplayed());
//
//        Click on menu
        click(monitoringPlansPage.footerMenuBTN);
//        Menu opens
        waitFor(monitoringPlansPage.footerMenuContent);
        verifyTrue(monitoringPlansPage.footerMenuContent.isDisplayed());
//
//        The menu should display the following links. Click on each.
//
//                Accessibility
//                Privacy
//                Privacy and Security Notice

//        The links should open up in another tab after being clicked
//        pause();
        click(monitoringPlansPage.footerAccessibility);
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/accessibility");
        closeTab();
        click(monitoringPlansPage.footerPrivacy);
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/privacy");
        closeTab();
        click(monitoringPlansPage.footerNotice);
        changeTab();
        verifyEquals(driver.getCurrentUrl(), "https://www.epa.gov/privacy/privacy-and-security-notice");
        closeTab();

//        Click on the 'x' in the menu
        click(monitoringPlansPage.footerClose);
//        Menu is closed
        verifyFalse(monitoringPlansPage.footerMenuContent.isDisplayed());
    }
}
