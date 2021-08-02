package tests.UITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_Pagination extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.facilitiesOutOf, "1-100 out of 2523");
        isDisplayed(monitoringPlansPage.nextPageButton);
        click(monitoringPlansPage.nextPageButton);
        verifyEquals(monitoringPlansPage.facilitiesOutOf, "101-200 out of 2523");

        isDisplayed(monitoringPlansPage.lastPageButton);
        click(monitoringPlansPage.lastPageButton);
        verifyEquals(monitoringPlansPage.facilitiesOutOf, "2501-2523 out of 2523");

        isDisplayed(monitoringPlansPage.previousPageButton);
        click(monitoringPlansPage.previousPageButton);
        verifyEquals(monitoringPlansPage.facilitiesOutOf, "2401-2500 out of 2523");

        isDisplayed(monitoringPlansPage.firstPageButton);
        click(monitoringPlansPage.firstPageButton);
        verifyEquals(monitoringPlansPage.facilitiesOutOf, "1-100 out of 2523");


    }
}
