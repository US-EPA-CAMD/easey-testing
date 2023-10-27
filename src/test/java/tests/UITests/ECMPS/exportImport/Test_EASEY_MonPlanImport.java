package tests.UITests.ECMPS.exportImport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

//This test launches from MP, logs in, selects facility, and uploads a file (only for Smith Generating 5)
public class Test_EASEY_MonPlanImport extends CommonExport {
    //set download path
    //TODO REPLACE PATH WITH RELATIVE PATH OF UPLOAD.JSON IN THE FILES SUBDIRECTORY
    private static String fileUploadpath = "C:\\EPA\\easey-testing\\src\\test\\java\\tests\\UITests\\ECMPS\\exportImport\\files\\MP Export - Smith Generating Facility, SCT1 (10-26-2023).json";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");


    private static String facilitySearch = "Smith Generating";


    @Test
    public void test() throws InterruptedException {

        WebDriverWait wt = new WebDriverWait(driver, 5);

        // Navigate to EASEY In
        //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");
        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //wait for page to load, verify page is MP
        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        //logOn
        logOn(username,password,monitoringPlansPage);

        //verify logged in and page is MP
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);
        //verify the page is MP
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
        //wait for search bar to be visible
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,facilitySearch);
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);

        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
//        js.executeScript("arguments[0].scrollIntoView(true);",
//                monitoringPlansPage.configOpenButton.get(5));
        click(monitoringPlansPage.configOpenButton.get(0));
        waitFor(monitoringPlansPage.configTabSmith1);

        // Clicks on Smith Tab
        //configTabSmith
        click(monitoringPlansPage.configTabSmith1);
        //waits for checkout btn
        waitFor(monitoringPlansPage.checkOutBTN);
        //click checkout button
        click(monitoringPlansPage.checkOutBTN);
        //waits for both check in btn and import btn to be visible
        waitFor(monitoringPlansPage.checkInBTN);
        waitFor(monitoringPlansPage.importButton);
        //clicks import button
        click(monitoringPlansPage.importButton);
        Thread.sleep(1000);

        waitFor(monitoringPlansPage.uploadFileChoiceButton);

        //click(monitoringPlansPage.uploadFileChoiceButton);
        WebElement upload_file = driver.findElement(By.xpath("//input[@id='file-input-single']"));
        upload_file.sendKeys(fileUploadpath);
        //wait for import button to show
        wt.until(ExpectedConditions.elementToBeClickable(monitoringPlansPage.importBTN));
        //click import button
        click(monitoringPlansPage.importBTN);
        //wait for success
        waitFor(monitoringPlansPage.successMessage);

        //if to print status to console
        //TODO add verify statement
        if(monitoringPlansPage.successMessage.isDisplayed()){
            System.out.println("The file was successfully uploaded");
        }else{
            System.out.println("The file was NOT successfully uploaded"+ "/n"+" NOT UPLOADED" );
        }


        waitFor(monitoringPlansPage.okButton);
        click(monitoringPlansPage.okButton);

        // Revert starts here
        revertToOfficial();

    }
    @Override
    @AfterMethod
    public void afterMethod() {
        logOutMethod();
        super.afterMethod();
    }
}