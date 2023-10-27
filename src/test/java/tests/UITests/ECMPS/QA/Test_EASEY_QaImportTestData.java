package tests.UITests.ECMPS.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.utils.CommonExport;

import java.net.URL;

//This test launches from QA [test data], logs in, selects facility, and uploads a file (only for Smith Generating 1)
public class Test_EASEY_QaImportTestData extends CommonExport {
    //TODO rework file path
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");


    @Test
    public void test() throws InterruptedException {

        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/qa/tests");
        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        //wait for page to load, verify page is QA
        waitFor(qaCertificationPage.title);
        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");

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
        waitFor(qaCertificationPage.title);

        //verify the page is QA
        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");

        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);

        //Search for facility
        input(qaCertificationPage.filterByKeywordBox,"Smith Generating");

        waitFor(qaCertificationPage.filterByKeywordButton);
        click(qaCertificationPage.filterByKeywordButton);

        waitFor(qaCertificationPage.facilityCaret);
        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> qaCertificationPage.configOpenButton.size() > 1);

        //verifies at least one search result returns
        verifyEquals(qaCertificationPage.configOpenButton.get(2), "Open");
        //clicks "open" button for first result
//        click(qaCertificationPage.configOpenButton.get(0));
        click(qaCertificationPage.configOpenAndCheckoutButton.get(0));
        waitFor(qaCertificationPage.configTab1);

        // Clicks on Smith Tab
        //configTabSmith
        click(qaCertificationPage.configTab1);

//        waitFor(qaCertificationPage.checkOutBTN);
//        click(qaCertificationPage.checkOutBTN);

        waitFor(qaCertificationPage.importBTNQA);
        //clicks import button
        click(qaCertificationPage.importBTNQA);

        waitFor(qaCertificationPage.importSelectType);

        click(qaCertificationPage.importSelectType);

        waitFor(qaCertificationPage.importFileOption);
        click(qaCertificationPage.importFileOption);

        waitFor(qaCertificationPage.continueBTN);
        click(qaCertificationPage.continueBTN);


        driver.findElement(By.xpath("//input[@id='file-input-single']")).sendKeys("C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\ECMPS\\QA\\files\\upload2.json");


        waitFor(qaCertificationPage.continueBTN);
        click(qaCertificationPage.continueBTN);



        //wait for success
        waitFor(qaCertificationPage.successMessage);

        waitFor(qaCertificationPage.okBTN);
        click(qaCertificationPage.okBTN);


        waitFor(qaCertificationPage.checkInBTN);
        click(qaCertificationPage.checkInBTN);


        waitFor(qaCertificationPage.logoutBTN);
        click(qaCertificationPage.logoutBTN);




        closebrowser();

    }
}

