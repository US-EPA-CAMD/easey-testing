package tests.UITests.ECMPS.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.utils.CommonExport;

//This test launches from QA [test data], logs in, selects facility, and uploads a file (only for Smith Generating 1)
public class Test_EASEY_QaImportTestData extends CommonExport {
    //TODO rework file path
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");


    @Test
    public void test() throws InterruptedException {
        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/qa-test");
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
        verifyEquals(qaCertificationPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
        click(qaCertificationPage.configOpenButton.get(0));
        waitFor(qaCertificationPage.configTab1);

        // Clicks on Smith Tab
        //configTabSmith
        click(qaCertificationPage.configTab1);

        waitFor(qaCertificationPage.checkOutBTN);
        click(qaCertificationPage.checkOutBTN);

        waitFor(qaCertificationPage.importBTNQA);
        //clicks import button
        click(qaCertificationPage.importBTNQA);

        //click(monitoringPlansPage.uploadFileChoiceButton);
        WebElement upload_file = driver.findElement(By.xpath("//option[contains(text(),'Import from File')]"));

        click(qaCertificationPage.continueBTN);

        waitFor(qaCertificationPage.inputLink);

        //TODO FIX file
        upload_file.sendKeys("C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\EASEYIn_Emissioners\\QA\\files\\upload.json");
        //wait for import button to show
        waitFor(qaCertificationPage.importSubmitBTN);
        //click import button
        click(qaCertificationPage.importSubmitBTN);
        //wait for success
        waitFor(qaCertificationPage.successMessage);

        //if to print status to console
        //TODO add verify statement
        if(qaCertificationPage.successMessage.isDisplayed()){
            System.out.println("The file was successfully uploaded");
        }else{
            System.out.println("The file was NOT successfully uploaded"+ "/n"+" NOT UPLOADED" );
        }


        revertToOfficial();


        //closing out
//        logOutMethod();


        closebrowser();

    }
}
