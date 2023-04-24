package tests.UITests.ECMPS.emissions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.EmissionsPage;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

public class Test_EASEY_EmissionsImport  extends CommonExport {
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");

    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/emissions");

        EmissionsPage emissionsPage = new EmissionsPage(driver);

        verifyEquals(emissionsPage.title, "Emissions");

        verifyEquals(emissionsPage.logInButtonOpenModal, "Log In");
        click(emissionsPage.logInButtonOpenModal);

        verifyEquals(emissionsPage.usernameLabelModal.getText(), "Username");
        input(emissionsPage.usernameFieldModal, username);

        verifyEquals(emissionsPage.passwordLabelModal.getText(), "Password");
        input(emissionsPage.passwordFieldModal, password);

        verifyEquals(emissionsPage.logInButtonSubmit, "Log In");
        click(emissionsPage.logInButtonSubmit);

        waitFor(driver -> !isDisplayed(emissionsPage.logInButtonSubmit));



        waitFor(emissionsPage.title);

        verifyEquals(emissionsPage.title, "Emissions");


        waitFor(emissionsPage.filterByKeywordBox);

        //Search for facility
        input(emissionsPage.filterByKeywordBox,"Smith Generating");
        click(emissionsPage.filterByKeywordButton);

        // Clicks on Smith
        click(emissionsPage.facilityCaret.get(0));

        waitFor(driver -> emissionsPage.configOpenButton.size() > 1);

        click(emissionsPage.configOpenButton.get(0));


        //wait for the tab to load
        waitFor(emissionsPage.configTab1);

        // Clicks on Smith Tab
        click(emissionsPage.configTab1);

        //waits for checkout btn
        waitFor(emissionsPage.checkOutBTN);
        //click checkout button
        click(emissionsPage.checkOutBTN);
        //waits for both check in btn and import btn to be visible
        waitFor(emissionsPage.checkInBTN);
        waitFor(emissionsPage.importButton);
        //clicks import button
        click(emissionsPage.importButton);

        waitFor(emissionsPage.importType);

        click(emissionsPage.importType);

        waitFor(emissionsPage.importFromFileOption);

        click(emissionsPage.importFromFileOption);

        ////input[@id='file-input-single'] is the hyperlinked text in "Drag file here or choose from folder" text
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='file-input-single']"));
        upload_file.sendKeys("C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\ECMPS\\emissions\\files\\upload.json");

        //wait for import button to show
        waitFor(emissionsPage.importSubmitBTN);
        //click import button
        click(emissionsPage.importSubmitBTN);

        //wait for success
        waitFor(emissionsPage.successMessage);

        //if to print status to console
        //TODO add verify statement
        if(emissionsPage.successMessage.isDisplayed()){
            System.out.println("The file was successfully uploaded");
        }else{
            System.out.println("The file was NOT successfully uploaded"+ "/n"+" NOT UPLOADED" );
        }


        waitFor(emissionsPage.okButton);
        click(emissionsPage.okButton);

        // Revert starts here
        revertToOfficial();

    }
}
