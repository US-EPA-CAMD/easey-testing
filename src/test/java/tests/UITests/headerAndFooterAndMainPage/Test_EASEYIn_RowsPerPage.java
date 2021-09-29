package tests.UITests.headerAndFooterAndMainPage;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_RowsPerPage extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        // Verifies how many rows are in the Facilities table
        // The extra 1 is the table header
        verifyEquals(monitoringPlansPage.rowsPerPage.size(), 101);

        click(monitoringPlansPage.rowsPerPageButton);
        // Verify 100 rows per page option
        verifyEquals(monitoringPlansPage.rowsPerPageOptions.get(0), "100");

        // Select 200 rows per page option
        verifyEquals(monitoringPlansPage.rowsPerPageOptions.get(1), "200");
        click(monitoringPlansPage.rowsPerPageOptions.get(1));

        // Verifies how many rows are in the Facilities table
        // The extra 1 is the table header
        verifyEquals(monitoringPlansPage.rowsPerPage.size(), 201);

        click(monitoringPlansPage.rowsPerPageButton);

        // Select 500 rows per page option
        verifyEquals(monitoringPlansPage.rowsPerPageOptions.get(2), "500");
        click(monitoringPlansPage.rowsPerPageOptions.get(2));

        // Verifies how many rows are in the Facilities table
        // The extra 1 is the table header
        verifyEquals(monitoringPlansPage.rowsPerPage.size(), 501);


    }
}
