package tests.UITests.EASEYIn_Emissioners.monPlan.export;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.regex.Pattern.*;
import java.util.regex.Matcher;
import java.io.File;
import java.util.HashMap;

public class Test_EASEY_MonPlanExport_Global extends UITestBase {

    //set download path
    String fileDownloadpath = "C:\\EPA\\easey-testing\\src\\downloads";
    //boolean method- traverse through downloads and get name of files
    String stringToBeMatched = "QA & Certification";

    public void setChromeDownloadPath() {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("downloads"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void VerifyDownloadWithFileExtension(WebElement element){
        //click export button
        click(element);
        System.out.println("Clicked EXPORT gurllll");
        //give time to download
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        sleep(900000000);
        System.out.println("WAITED");

        File folder = new File(fileDownloadpath);
       // List the files on that folder
        File[] listOfFiles = folder.listFiles();
        boolean matchFound = false;
        File f = null;
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        System.out.println("folder: " + folder);


        for (File listOfFile : listOfFiles) {
            String fileName = listOfFile.getName();
            f = new File(fileName);
            System.out.println("Inside For LOOP ");
            System.out.println("File " + fileName);

//            if (listOfFile.isFile()) {
//
//               // pattern.matcher(listOfFile.getName());
//                System.out.println("File " + fileName);
                if (stringToBeMatched == f.getName() ) {

                    System.out.println("File " + fileName);
                    matchFound = true;
                }
            //}
        }
           //Assert.assertTrue(matchFound, "Downloaded document is not found");
       // f.deleteOnExit();
            System.out.println("the method ran girl !!!!!");

    }

    @Test
    public void test() throws InterruptedException {


//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        sleep(90000);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(5), "Open");
        //clicks "open" button for first result
        click(monitoringPlansPage.configOpenButton.get(0));

        //supposed to click on the facility tab that you just selected but errors HERE
        click(monitoringPlansPage.configTab1);
        sleep(9000);
        //clicks the export tab on the left menu  column
        click(monitoringPlansPage.exportTab);
        //creates new export page object to access properties specific to export
        ExportPage exportPage = new ExportPage(driver);

        verifyEquals(exportPage.title, "Export Data");
        sleep(9000);
        //Adjust selections for data you want to export: can change year or quarter
        //click(exportPage.YearDD.get(1));
        //click(exportPage.QuarterDD.get(1));


        //verify with name clicks so delete above or...

        //selects everything to be downloaded (monitoring plan, qa, and emissions)
        click(exportPage.MPButton);
        click(exportPage.qaButton);
        click(exportPage.emissionsButton);

        //validation method that clicks export button and checks something was downloaded
        VerifyDownloadWithFileExtension(exportPage.exportButton);
        click(exportPage.exportButton);

        //close everything
        closebrowser();
    }

    //Quit from browser
    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
