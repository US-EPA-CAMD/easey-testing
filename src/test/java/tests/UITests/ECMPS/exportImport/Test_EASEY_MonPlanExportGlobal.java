package tests.UITests.ECMPS.exportImport;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

//This test launches from MP, selects facility, navigates to the export tab, and exports the MP data(checks user's downloads folder for file)
public class Test_EASEY_MonPlanExportGlobal extends CommonExport {

    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    @Test
    public void test() throws InterruptedException {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");




        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        //check if page is MP
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
        //wait for search bar to load
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        // Clicks on Smith
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        click(monitoringPlansPage.configOpenButton.get(0));

        click(monitoringPlansPage.configTabs.get(0));

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);


        click(monitoringPlansPage.sectionsDropdown);

        click(monitoringPlansPage.formulaOption);

//        waitFor(monitoringPlansPage.exportBTN);
//
//        click(monitoringPlansPage.exportBTN);
//
//        click(monitoringPlansPage.exportBTN);
//
//        String searchFile = "MP Export - Smith Generating Facility, SCT1";
//        //check if downloaded file
//        VerifyDownloadWithFileExtension(fileDownloadpath, searchFile);



        closebrowser();
    }



}
