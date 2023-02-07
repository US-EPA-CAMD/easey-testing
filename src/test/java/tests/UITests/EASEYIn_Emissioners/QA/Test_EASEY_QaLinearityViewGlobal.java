package tests.UITests.EASEYIn_Emissioners.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

public class Test_EASEY_QaLinearityViewGlobal extends CommonExport {
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

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));


        //verifies at least one search result returns
        //verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(1), "Open");
        click(qaCertificationPage.configOpenButton.get(5));

        click(qaCertificationPage.configTab1);


        click(qaCertificationPage.configTabSmith);


        //Wait for load
        waitFor(qaCertificationPage.testTypeGroupBox);
        //click into test type box and make selection
        click(qaCertificationPage.testTypeGroupBox);
        click(qaCertificationPage.linearitySummary);
        //click first view button
        waitFor(qaCertificationPage.viewLS);
        click(qaCertificationPage.viewLS);
        //wait for modal to open
        waitFor(qaCertificationPage.testSummaryModalTitle);
        //verify the title says Test Summary Data
        verifyEquals(qaCertificationPage.testSummaryModalTitle, "Test Summary Data");
        sleep(900000);
        //close modal and print
        click(qaCertificationPage.closeModal);
        System.out.println("Viewed data!");


    }


}
