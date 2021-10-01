package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_Pagination extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.facilitiesOutOf, "1-100 out of 2523");
        verifyTrue(isDisplayed(headerFooterAndHomePage.nextPageButton));
        click(headerFooterAndHomePage.nextPageButton);
        verifyEquals(headerFooterAndHomePage.facilitiesOutOf, "101-200 out of 2523");

        verifyTrue(isDisplayed(headerFooterAndHomePage.lastPageButton));
        click(headerFooterAndHomePage.lastPageButton);
        verifyEquals(headerFooterAndHomePage.facilitiesOutOf, "2501-2523 out of 2523");

        verifyTrue(isDisplayed(headerFooterAndHomePage.previousPageButton));
        click(headerFooterAndHomePage.previousPageButton);
        verifyEquals(headerFooterAndHomePage.facilitiesOutOf, "2401-2500 out of 2523");

        verifyTrue(isDisplayed(headerFooterAndHomePage.firstPageButton));
        click(headerFooterAndHomePage.firstPageButton);
        verifyEquals(headerFooterAndHomePage.facilitiesOutOf, "1-100 out of 2523");


    }
}
