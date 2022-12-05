package tests.UITests.EASEYIn_Emissioners.monPlan.export;

import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEY_MonPlanExport_Global extends UITestBase {
    @Test
    public void test() throws InterruptedException {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);
        input(monitoringPlansPage.filterByKeywordBox,"Gadsden");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on Gadsden
        click(monitoringPlansPage.facilityCaret.get(0));


        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabGadsden12CS0BAN);

        click(monitoringPlansPage.export);
        ExportPage exportPage = new ExportPage(driver);

        //click(exportPage.YearDD.get(1));

        //click(exportPage.QuarterDD.get(1));

       // click(exportPage.exportButton);
        sleep(5);
    }
}
