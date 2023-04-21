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
        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");
        EmissionsPage emissionsPage = new EmissionsPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //wait for page to load, verify page is MP
        waitFor(emissionsPage.title);
        verifyEquals(emissionsPage.title, "Emissions");

        //open log in modal
        verifyEquals(emissionsPage.logInButtonOpenModal, "Log In");
        click(emissionsPage.logInButtonOpenModal);
        //give username
        verifyEquals(emissionsPage.usernameLabelModal.getText(), "Username");
        input(emissionsPage.usernameFieldModal, username);
        ////give password
        verifyEquals(emissionsPage.passwordLabelModal.getText(), "Password");
        input(emissionsPage.passwordFieldModal, password);
        //verify log in btn is visible and click log in
        verifyEquals(emissionsPage.logInButtonSubmit, "Log In");
        click(emissionsPage.logInButtonSubmit);
        //wait for log in to complete
        waitFor(emissionsPage.dashWorkspace);
        verifyEquals(emissionsPage.dashWorkspace, "Workspace");
        //verify logged in and page is Emissions
        verifyEquals(emissionsPage.workspaceMonPlan, "Monitoring Plans");
        click(emissionsPage.workspaceMonPlan);
        //verify the page is MP
        verifyEquals(emissionsPage.title, "Monitoring Plans");
        //wait for search bar to be visible
        waitFor(emissionsPage.filterByKeywordBox);

        //Search for facility
        input(emissionsPage.filterByKeywordBox,"Smith Generating");
        click(emissionsPage.filterByKeywordButton);

        // Clicks on first search result
        click(emissionsPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> emissionsPage.configOpenButton.size() > 1);

        //verifies at least one search result returns
        verifyEquals(emissionsPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
        js.executeScript("arguments[0].scrollIntoView(true);",
                emissionsPage.configOpenButton.get(5));
        click(emissionsPage.configOpenButton.get(5));
        Thread.sleep(3000);

        // Clicks on Smith Tab
        //configTabSmith
        waitFor(emissionsPage.configTabSmith);
        click(emissionsPage.configTabSmith);
        //waits for checkout btn
        waitFor(emissionsPage.checkOutBTN);
        //click checkout button
        click(emissionsPage.checkOutBTN);
        //waits for both check in btn and import btn to be visible
        waitFor(emissionsPage.checkInBTN);
        waitFor(emissionsPage.importButton);
        //clicks import button
        click(emissionsPage.importButton);
        Thread.sleep(1000);

        //click(monitoringPlansPage.uploadFileChoiceButton);
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='file-input-single']"));
        upload_file.sendKeys("C:\\Users\\mosesdee\\IdeaProjects\\easey-testing\\src\\test\\java\\tests\\UITests\\ECMPS\\exportImport\\files\\upload.json");
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
