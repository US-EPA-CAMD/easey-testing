package tests.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import tests.UITests.UiReusableComponents.UiReusableComponents;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CommonExport extends UiReusableComponents {

    public static File getLatestFileFromDir(String directoryFilePath) {
        //get directory
        File directory = new File(directoryFilePath);
        //make list of files in directory
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        //go through files if not null
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        System.out.println(chosenFile);
        return chosenFile;
    }


    ///FOR FILES DOWNLOADED WITH CURRENT DATE
    public void VerifyDownload(String fileDownloadpath, String searchFileName) {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", fileDownloadpath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        File getLatestFile = getLatestFileFromDir(fileDownloadpath);
        String fileName = getLatestFile.getName();

        Format f = new SimpleDateFormat("(MM-dd-yyyy)");
        String currentDate = f.format(new Date());
        //if file name = fileName print success
        if ((searchFileName + "(" + currentDate + ").json").equalsIgnoreCase(fileName)) {
            System.out.println("Downloaded file: " + fileName + " and the file is located at -" + fileDownloadpath);
            getLatestFile.deleteOnExit();

        } else {
            System.out.println(fileName);
            System.out.println("Downloaded file");
        }

    }

    ///FOR FILES DOWNLOADED WITH CURRENT DATE
    public void VerifyDownloadnoDATE(String fileDownloadpath, String searchFileName) {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", fileDownloadpath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        File getLatestFile = getLatestFileFromDir(fileDownloadpath);
        String fileName = getLatestFile.getName();

        //if file name = fileName print success
        if ((searchFileName).equalsIgnoreCase(fileName)) {
            System.out.println("Downloaded file: " + fileName + " and the file is located at -" + fileDownloadpath);
            getLatestFile.deleteOnExit();

        } else {
            System.out.println(fileName);
            System.out.println("Downloaded file");
        }

    }


    //Quit from browser
    @AfterClass
    public void closebrowser() {
        driver.quit();
    }


}
