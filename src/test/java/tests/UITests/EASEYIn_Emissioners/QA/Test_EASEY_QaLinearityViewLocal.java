package tests.UITests.EASEYIn_Emissioners.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

import java.util.concurrent.TimeoutException;

public class Test_EASEY_QaLinearityViewLocal extends CommonExport {

    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");

    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/qa-test");

        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");
        verifyEquals(qaCertificationPage.login, "Log In");
        click(qaCertificationPage.login);

        verifyEquals(qaCertificationPage.usernameModal.getText(), "Username");
        input( qaCertificationPage.usernameFieldModal, username);

        verifyEquals(qaCertificationPage.passwordLabelModal.getText(), "Password");
        input(qaCertificationPage.passwordFieldModal, password);

        verifyEquals(qaCertificationPage.logInButtonSubmit, "Log In");
        click(qaCertificationPage.logInButtonSubmit);

        waitFor(qaCertificationPage.dashWorkspace);
        verifyEquals(qaCertificationPage.dashWorkspace, "Workspace");

        waitFor(qaCertificationPage.title);
        waitFor(qaCertificationPage.filterByKeywordBox);

        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");


        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);
        //Search for facility
        input(qaCertificationPage.filterByKeywordBoxQa,"Smith Generating");
        click(qaCertificationPage.filterByKeywordBTNQa);

        waitFor(qaCertificationPage.facilityName);
        //verify the search returns the correct results
        verifyEquals(qaCertificationPage.facilityName, "Smith Generating Facility");

        //waits for return
        waitFor(driver -> qaCertificationPage.facilityCaret.size() > 1);
        sleep(90000);
        sleep(90000);

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));


        //verifies at least one search result returns
        //verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        sleep(90000);
        sleep(90000);
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);

        //if "Check Back in" button is visible press it (handles if the facility was already checked out by a failed test)
        if(isDisplayed(qaCertificationPage.checkBACKINBTN)){
            click(qaCertificationPage.checkBACKINBTN);
            waitFor(qaCertificationPage.configOpenButton.get(1));
        }
        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(1), "Open");
        click(qaCertificationPage.configOpenButton.get(5));

        click(qaCertificationPage.configTab1);



        //Wait for load
        waitFor(qaCertificationPage.testTypeGroupBox);

        //todo click check in btn here
        waitFor(qaCertificationPage.configcheckOutButton);
        //check out facility
        click(qaCertificationPage.configcheckOutButton);

        waitFor(qaCertificationPage.testTypeGroupBox);
        //click into test type box and make selection
        click(qaCertificationPage.testTypeGroupBox);
        waitFor(qaCertificationPage.linearitySummary);
        click(qaCertificationPage.linearitySummary);



        sleep(90000);

        //click test data report button
        //click(qaCertificationPage.testDataReportBTN);

        //click add test data
       waitFor(qaCertificationPage.addTestDataBTN);
       click(qaCertificationPage.addTestDataBTN);

       waitFor(qaCertificationPage.testSummaryModalTitle);

       // waitFor(qaCertificationPage.testSummaryModalText);

        //try catch for modal selections
        //try {
            sleep(90000);

            //make modal selections: click into box and make selection or pass it the date
            click(qaCertificationPage.componentIDBox);
            click(qaCertificationPage.componentID700option);

            click(qaCertificationPage.spanScaleCodeBox);
            click(qaCertificationPage.spanScaleCodeHigh);

            click(qaCertificationPage.testNumberBox);
            input(qaCertificationPage.testNumberBox, "1");

            click(qaCertificationPage.testReasonCodeBox);
            click(qaCertificationPage.qaSelectionTestReasonCode);

            click(qaCertificationPage.testResultCodeBox);
            click(qaCertificationPage.testResultCodeBoxEntry);

            click(qaCertificationPage.beginDate);
            input(qaCertificationPage.beginDate, "01012022");

            click(qaCertificationPage.beginHour);
            click(qaCertificationPage.zeroEntry);

            click(qaCertificationPage.beginMinute);
            click(qaCertificationPage.zeroEntry);

            click(qaCertificationPage.endDate);
            input(qaCertificationPage.endDate, "01012023");

            click(qaCertificationPage.endHour);
            click(qaCertificationPage.zeroEntry);

            click(qaCertificationPage.endMinute);
            click(qaCertificationPage.zeroEntry);
            sleep(90000);

            //TODO verify and print selections somehow??!!
           // System.out.println("Unit or Stack Pipe ID:" + qaCertificationPage.UnitIdBox.getText());
            //System.out.println("Test Type Code:" + qaCertificationPage.testTypeCodeBox.getText());
            System.out.println("Component ID:" + qaCertificationPage.componentID700option.isDisplayed());
            System.out.println("Span Scale Code:" + qaCertificationPage.spanScaleCodeHigh.isDisplayed());
            //System.out.println("Test Number:" + qaCertificationPage.testNumberBox.getText());
            System.out.println("Test Reason:" + qaCertificationPage.qaSelectionTestReasonCode.isDisplayed());
            System.out.println("Test Result Code:" + qaCertificationPage.testResultCodeBoxEntry.isDisplayed());
//            System.out.println("Begin Date:" + qaCertificationPage.beginDate.getText());
//            System.out.println("Begin Hour:" + qaCertificationPage.beginHour.getText());
//            System.out.println("Begin Minute:" + qaCertificationPage.beginMinute.getText());
//            System.out.println("End Date:" + qaCertificationPage.endDate.getText());
//            System.out.println("End Hour:" + qaCertificationPage.endHour.getText());
//            System.out.println("End Minute:" + qaCertificationPage.endMinute.getText());

            click(qaCertificationPage.saveBTN);
            sleep(90000);
//        }
//        catch(Exception E){
//            System.out.println("Something went wrong");
//            waitFor(qaCertificationPage.cancelBTN);
//            click(qaCertificationPage.cancelBTN);
//
//            waitFor(qaCertificationPage.checkInBTN);
//            click(qaCertificationPage.checkInBTN);
//
//            waitFor(qaCertificationPage.configcheckOutButton);
//        }

//        if(isDisplayed(qaCertificationPage.saveBTN)){
//            System.out.println("had to click save twice");
//            click(qaCertificationPage.saveBTN);
//        }

        waitFor(qaCertificationPage.editDataBTN);
        waitFor(qaCertificationPage.removeDataBTN);
        //
        waitFor(qaCertificationPage.testTypeCodeTableHeader);
        waitFor(qaCertificationPage.testTypeCodeTableContents);
        //remove the data
        click(qaCertificationPage.removeDataBTN);
        System.out.println("Data entry was removed");
        //click check in
        waitFor(qaCertificationPage.checkInBTN);
        click(qaCertificationPage.checkInBTN);
        //wait for check out button to load to be sure it finished
        waitFor(qaCertificationPage.configcheckOutButton);
        System.out.println("Facility was checked back in!!");
        sleep(90000);




    }

}
