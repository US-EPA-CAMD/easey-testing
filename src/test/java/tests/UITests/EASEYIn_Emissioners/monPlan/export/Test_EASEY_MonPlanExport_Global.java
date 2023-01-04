package tests.UITests.EASEYIn_Emissioners.monPlan.export;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Test_EASEY_MonPlanExport_Global extends UITestBase {


    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    //boolean method- traverse through downloads and get name of files

    public static File getLatestFileFromDir(String directoryFilePath)
    {
        //get directory
        File directory = new File(directoryFilePath);
        //make list of files in directory
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        //go through files if not null
        if (files != null)
        {
            for (File file : files)
            {
                if (file.lastModified() > lastModifiedTime)
                {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        System.out.println(chosenFile);
        return chosenFile;
    }

    public void VerifyDownloadWithFileExtension(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory",  "C:\\Users\\mackenzieharwood\\Downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        File getLatestFile = getLatestFileFromDir(fileDownloadpath);
        String fileName = getLatestFile.getName();

        Format f = new SimpleDateFormat("(MM-dd-yyyy)");
        String currentDate = f.format(new Date());
        //Look for the file in the files
        // You should write smart REGEX according to the filename
        if(fileName.equalsIgnoreCase("MP Export - Smith Generating Facility, SCT5 "+currentDate+".json")){
            System.out.println( "Downloaded file: "+ fileName+ " and the file is located at -"+ fileDownloadpath);

        }

        else{System.out.println( "Downloaded file name is not matching with expected file name");}

        getLatestFile.deleteOnExit();


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
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        Thread.sleep(9000);
        click(monitoringPlansPage.configOpenButton.get(5));
        Thread.sleep(9000);
        click(monitoringPlansPage.configTab1);
        sleep(9000);
        //clicks the export tab on the left menu  column
        click(monitoringPlansPage.exportTab);
        //creates new export page object to access properties specific to export
        ExportPage exportPage = new ExportPage(driver);
        Thread.sleep(5000);
        Thread.sleep(5000);
        //verify on export page
        verifyEquals(exportPage.title, "Export Data");

        //EXPORT BUTTON GREYED OUT UNTIL MP BUTTON SELECTED
        click(exportPage.MPButton);
        sleep(900000000);


        //click export button
        click(exportPage.exportButton);

        //give time
        Thread.sleep(5000);
        Thread.sleep(5000);

        //check if downloaded file
        VerifyDownloadWithFileExtension();

        closebrowser();
    }

    //Quit from browser
    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
