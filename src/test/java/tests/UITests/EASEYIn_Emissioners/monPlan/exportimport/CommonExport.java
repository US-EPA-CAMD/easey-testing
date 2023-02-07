package tests.UITests.EASEYIn_Emissioners.monPlan.exportimport;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import tests.utils.UITestBase;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CommonExport extends UITestBase {

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


    ///FOR FILES DOWNLOADED WITH CURRENT DATE
    public void VerifyDownload(String fileDownloadpath, String searchFileName){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", fileDownloadpath);
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
            System.out.println( "Downloaded file");
        }

    }
    public void VerifyDownloadWithFileExtension(String fileDownloadpath, String searchFile){
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory",  fileDownloadpath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        File getLatestFile = getLatestFileFromDir(fileDownloadpath);
        String fileName = getLatestFile.getName();

        Format f = new SimpleDateFormat("(MM-dd-yyyy)");
        String currentDate = f.format(new Date());
        //Look for the file in the files
        if(fileName.equalsIgnoreCase(searchFile +"("+currentDate+").json")){
            System.out.println( "Downloaded file: "+ fileName+ " and the file is located at -"+ fileDownloadpath);

        } else{System.out.println( "Downloaded file name is not matching with expected file name");}

        getLatestFile.deleteOnExit();


    }




    //Quit from browser
    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
