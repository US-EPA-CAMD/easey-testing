package tests.UITests.ECMPS.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.utils.CommonExport;
//This test launches from QA test data, selects a facility to view a linearity data and views the first entry

public class Test_EASEY_QaRATAGlobal extends CommonExport {

    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/qa/tests");

        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");

        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);
        //Search for facility
        input(qaCertificationPage.filterByKeywordBox, "Smith Generating");
        click(qaCertificationPage.filterByKeywordButton);
        //waits for return
        waitFor(driver -> qaCertificationPage.facilityCaret.size() > 1);

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));



        //add wait to let build TODO
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(0), "Open");
        click(qaCertificationPage.configOpenButton.get(0));

        click(qaCertificationPage.configTab1);


        click(qaCertificationPage.configTab1);


        //Wait for load
        waitFor(qaCertificationPage.testTypeGroupBox);
        //click into test type box and make selection
        click(qaCertificationPage.testTypeGroupBox);

        click(qaCertificationPage.rataOption);

        waitFor(qaCertificationPage.viewTestData1);

        //view first test data

        click(qaCertificationPage.viewTestData1);
       // click(qaCertificationPage.viewTestData1);

        waitFor(qaCertificationPage.testSummaryModalTitle);

        verifyEquals(qaCertificationPage.testSummaryModalTitle, "Test Summary Data");

        waitFor(qaCertificationPage.closeModal);

        click(qaCertificationPage.closeModal);

//        waitFor(qaCertificationPage.expandRow);
//
//        click(qaCertificationPage.expandRow);
//
//        waitFor(qaCertificationPage.expandDataRow);
//
//        click(qaCertificationPage.expandDataRow);
//
//        waitFor(qaCertificationPage.expandRataDataRow);
//
//        click(qaCertificationPage.expandRataDataRow);



        closebrowser();
    }
}
