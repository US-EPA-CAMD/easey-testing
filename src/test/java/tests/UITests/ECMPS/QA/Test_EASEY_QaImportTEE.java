package tests.UITests.ECMPS.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.utils.CommonExport;

//This test launches from QA [certs event data & test extension exemption data], logs in, selects facility, and uploads a file (only for Smith Generating 1)
public class Test_EASEY_QaImportTEE extends CommonExport {
    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");

    //make changes
    @Test
    public void test() throws InterruptedException {
        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/qa/qce-tee");
        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        //wait for page to load, verify page is Qa TEE
        waitFor(qaCertificationPage.teeTitle);
        verifyEquals(qaCertificationPage.teeTitle, "QA Cert Event Data & Test Extension Exemption Data");

        //open log in modal
        verifyEquals(qaCertificationPage.logInButtonOpenModal, "Log In");
        click(qaCertificationPage.logInButtonOpenModal);
        //give username
        verifyEquals(qaCertificationPage.usernameLabelModal.getText(), "Username");
        waitFor(qaCertificationPage.usernameFieldModal);
        input(qaCertificationPage.usernameFieldModal, username);
        ////give password
        verifyEquals(qaCertificationPage.passwordLabelModal.getText(), "Password");
        input(qaCertificationPage.passwordFieldModal, password);
        //verify log in btn is visible and click log in
        verifyEquals(qaCertificationPage.logInButtonSubmit, "Log In");
        click(qaCertificationPage.logInButtonSubmit);

        waitFor(driver -> !isDisplayed(qaCertificationPage.logInButtonSubmit));

        //wait for log in to complete
        waitFor(qaCertificationPage.teeTitle);

        //verify the page is QA
        verifyEquals(qaCertificationPage.teeTitle, "QA Cert Event Data & Test Extension Exemption Data");

        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);

        //Search for facility
        input(qaCertificationPage.filterByKeywordBox, "Smith Generating");

        waitFor(qaCertificationPage.filterByKeywordButton);
        click(qaCertificationPage.filterByKeywordButton);

        waitFor(qaCertificationPage.facilityCaret);
        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);

        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        click(qaCertificationPage.configOpenAndCheckoutButton.get(0));
        waitFor(qaCertificationPage.configTab1);

        // Clicks on Smith Tab
        //configTabSmith
        click(qaCertificationPage.configTab1);

        //wait for and click import button
        waitFor(qaCertificationPage.importBTNQA);
        click(qaCertificationPage.importBTNQA);

        //wait for and click import type box
        waitFor(qaCertificationPage.importSelectType);
        click(qaCertificationPage.importSelectType);

        //wait for and click import from historical
        waitFor(qaCertificationPage.importHistoricalOption);
        click(qaCertificationPage.importHistoricalOption);

        click(qaCertificationPage.continueBTN);

        //wait for and click reporting period
        waitFor(qaCertificationPage.importHistoricalReportingPeriod);
        click(qaCertificationPage.importHistoricalReportingPeriod);

        input(qaCertificationPage.importHistoricalReportingPeriod, "2013 ");

        //wait for and click preview
        waitFor(qaCertificationPage.previewBTN);
        click(qaCertificationPage.previewBTN);

        //wait for import button to show
        waitFor(qaCertificationPage.importSubmitBTN);
        click(qaCertificationPage.importSubmitBTN);

        //wait for success
        waitFor(qaCertificationPage.successMessage);

        //if to print status to console
        //TODO add verify statement
        if (qaCertificationPage.successMessage.isDisplayed()) {
            System.out.println("The file was successfully uploaded");
        } else {
            System.out.println("The file was NOT successfully uploaded" + "/n" + " NOT UPLOADED");
        }

        revertToOfficial();


        closebrowser();

    }
}
