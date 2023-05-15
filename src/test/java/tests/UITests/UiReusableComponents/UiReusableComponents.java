package tests.UITests.UiReusableComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UiReusableComponents extends UITestBase {

    protected void revertToOfficial() {
        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        waitFor(monitoringPlansPage.monPlanWorkSpaceBtn);
        verifyEquals(monitoringPlansPage.monPlanWorkSpaceBtn, "Monitoring Plans");
        click(monitoringPlansPage.monPlanWorkSpaceBtn);

        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertOfficialRecordButton);
        verifyEquals(monitoringPlansPage.revertOfficialRecordButton, "Revert to Official Record");
        click(monitoringPlansPage.revertOfficialRecordButton);

        waitFor(monitoringPlansPage.revertModalYesButton);
        verifyEquals(monitoringPlansPage.revertModalYesButton, "Yes");
        click(monitoringPlansPage.revertModalYesButton);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.revertModalYesButton), 180);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton), 180);
        waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationImage), 180);

        // These steps Checks Back In the configuration
        js.executeScript("arguments[0].scrollIntoView(true);",
                monitoringPlansPage.configcheckBackInButton);
        waitFor(monitoringPlansPage.configcheckBackInButton);
        click(monitoringPlansPage.configcheckBackInButton);

        waitFor(monitoringPlansPage.configcheckOutButton);
        verifyEquals(monitoringPlansPage.configcheckOutButton, "Check Out");
    }

    protected void logOutMethod() {

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.menuBtn);

        if (isDisplayed(monitoringPlansPage.logOutButton)) {
            js.executeScript("arguments[0].click();", monitoringPlansPage.logOutButton);
            waitFor(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        } else {
            isDisplayed(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        }
    }

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



      public void ReadDropdownValues(String elementID){
          Select select = new Select(driver.findElement(By.id(elementID)));
          List<WebElement> options = select.getOptions();

          for(int i =0; i< options.size() ; i++){
              String currentValue = options.get(i).getText();
              System.out.println(currentValue + "/n" + "!!!!!");
          }

      }

}
