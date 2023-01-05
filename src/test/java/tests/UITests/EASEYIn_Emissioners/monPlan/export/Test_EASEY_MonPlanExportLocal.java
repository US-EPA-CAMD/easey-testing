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

public class Test_EASEY_MonPlanExportLocal extends UITestBase {
    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    //boolean method-traverse through downloads and get name of files

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

    public void VerifyDownloads(){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory",  "C:\\Users\\mackenzieharwood\\Downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        File getLatestFile = getLatestFileFromDir(fileDownloadpath);
        String fileName = getLatestFile.getName();

        Format f = new SimpleDateFormat("(MM-dd-yyyy)");
        String currentDate = f.format(new Date());
        //if file name = fileName print success
        if(("MP Export - Smith Generating Facility, SCT5 "+"("+currentDate+").json").equalsIgnoreCase(fileName)){
            System.out.println( "Downloaded file: "+ fileName+ " and the file is located at -"+ fileDownloadpath);
            getLatestFile.deleteOnExit();

        } else{
            System.out.println(fileName);
            System.out.println( "Downloaded file name is not matching with expected file name");
        }

    }

    @Test()
    public void tests() throws InterruptedException {
        String username = System.getenv("MACKENZIE_TESTING_USERNAME");
        String password = System.getenv("MACKENZIE_TESTING_PASSWORD");



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
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        click(monitoringPlansPage.configOpenButton.get(5));
        Thread.sleep(9000);

        // Clicks on Smith
        //configTabSmith
        click(monitoringPlansPage.configTabSmith);
        //Wait for load
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //clicks the export tab on the left menu  column
        click(monitoringPlansPage.exportTabLocal);


        //creates new export page object to access properties specific to export
        ExportPage exportPage = new ExportPage(driver);
        Thread.sleep(5000);
        //verify on export page
        verifyEquals(exportPage.title, "Export Data");

        //EXPORT BUTTON GREYED OUT UNTIL MP BUTTON SELECTED
        click(exportPage.MPButton);


        //click export button
        click(exportPage.exportButton);
        sleep(900000000);
        Thread.sleep(5000);
        Thread.sleep(5000);

        //check if downloaded file
        VerifyDownloads();

        closebrowser();




    }
    //Quit from browser
    @AfterClass
    public void closebrowser(){
        driver.quit();
    }
}
