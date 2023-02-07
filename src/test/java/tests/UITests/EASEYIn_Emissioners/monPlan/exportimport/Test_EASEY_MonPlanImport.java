package tests.UITests.EASEYIn_Emissioners.monPlan.exportimport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;

//This test launches from MP, logs in, selects facility, and uploads a file (only for Smith Generating 5)
public class Test_EASEY_MonPlanImport extends CommonExport {
    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");


    @Test
    public void test() throws InterruptedException {
        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/monitoring-plans");
        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        //wait for page to load, verify page is MP
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        //open log in modal
        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);
        //give username
        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);
        ////give password
        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);
        //verify log in btn is visible and click log in
        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);
        //wait for log in to complete
        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");
        //verify logged in and page is MP
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);
        //verify the page is MP
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
        //wait for search bar to be visible
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox, "Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);

        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
        click(monitoringPlansPage.configOpenButton.get(5));
        Thread.sleep(9000);


        // Clicks on Smith Tab
        //configTabSmith
        click(monitoringPlansPage.configTabSmith);
        //waits for checkout btn
        waitFor(monitoringPlansPage.checkOutBTN);
        //click checkout button
        click(monitoringPlansPage.checkOutBTN);
        //waits for both check in btn and import btn to be visible
        waitFor(monitoringPlansPage.checkInBTN);
        waitFor(monitoringPlansPage.importButton);
        //clicks import button
        click(monitoringPlansPage.importButton);

        //click(monitoringPlansPage.uploadFileChoiceButton);
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='file-input-single']"));
        upload_file.sendKeys("C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\EASEYIn_Emissioners\\monPlan\\exportimport\\files\\upload.json");
        //wait for import button to show
        waitFor(monitoringPlansPage.importSubmitBTN);
        //click import button
        click(monitoringPlansPage.importSubmitBTN);
        //wait for success
        waitFor(monitoringPlansPage.successMessage);

        //if to print status to console
        //TODO add verify statement
        if (monitoringPlansPage.successMessage.isDisplayed()) {
            System.out.println("The file was successfully uploaded");
        } else {
            System.out.println("The file was NOT successfully uploaded" + "/n" + " NOT UPLOADED");
        }
        //TODO revert to offical call

        //click ok
        click(monitoringPlansPage.okBTN);
        //wait for checkin button
        waitFor(monitoringPlansPage.checkInBTN);
        //click checkin
        click(monitoringPlansPage.checkInBTN);
        closebrowser();
    }
}
