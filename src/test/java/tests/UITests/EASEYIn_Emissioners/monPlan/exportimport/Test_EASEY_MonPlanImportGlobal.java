package tests.UITests.EASEYIn_Emissioners.monPlan.exportimport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;

public class Test_EASEY_MonPlanImportGlobal extends CommonExport {
    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");


    @Test
    public void test() throws InterruptedException {
        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");
        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");


        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);

        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);
        sleep(90000);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        click(monitoringPlansPage.configOpenButton.get(5));
        Thread.sleep(9000);
        click(monitoringPlansPage.configTab1);
        sleep(9000);

        click(monitoringPlansPage.importButton);

        //click(monitoringPlansPage.uploadFileChoiceButton);
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='file-input-single']"));
        upload_file.sendKeys("C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\EASEYIn_Emissioners\\monPlan\\exportimport\\files\\upload.json");

        sleep(9000);

        closebrowser();
    }
}
