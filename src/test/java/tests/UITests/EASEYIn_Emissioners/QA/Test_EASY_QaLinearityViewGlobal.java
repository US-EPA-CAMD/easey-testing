package tests.UITests.EASEYIn_Emissioners.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

public class Test_EASY_QaLinearityViewGlobal extends CommonExport {
    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
    goToo("ecmps","/qa-test");

    QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

    verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");

        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);
        //Search for facility
        input(qaCertificationPage.filterByKeywordBoxQa,"Smith Generating");
        click(qaCertificationPage.filterByKeywordBTNQa);
        //waits for return
        waitFor(driver -> qaCertificationPage.facilityCaret.size() > 1);
        sleep(90000);

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));
        sleep(90000);

        //verifies at least one search result returns
        //verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(1), "Open");
        click(qaCertificationPage.configOpenButton.get(5));
        Thread.sleep(9000);
        click(qaCertificationPage.configTab1);
        sleep(9000);

        click(qaCertificationPage.configTabSmith);
        //Wait for load
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);
    }


}
