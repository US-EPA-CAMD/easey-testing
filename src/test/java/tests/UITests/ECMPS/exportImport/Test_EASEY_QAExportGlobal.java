package tests.UITests.ECMPS.exportImport;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

//This test launches from MP, selects facility, navigates to the export tab, and exports the QA data(checks user's downloads folder for file)
public class Test_EASEY_QAExportGlobal extends CommonExport {
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    @Test
    public void test() throws InterruptedException {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);
        //waits for return
        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);


        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));


        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");

        waitFor(monitoringPlansPage.configOpenButton.get(0));
        click(monitoringPlansPage.configOpenButton.get(0));

        waitFor(monitoringPlansPage.configTab1);
        click(monitoringPlansPage.configTab1);


        //clicks the export tab on the left menu  column
        click(monitoringPlansPage.exportTab);
        //creates new export page object to access properties specific to export
        ExportPage exportPage = new ExportPage(driver);

        waitFor(exportPage.title);
        //verify on export page
        verifyEquals(exportPage.title, "Export Data");

        waitFor(exportPage.yearQuarterDropdown);
        click(exportPage.yearq4Button);

        js.executeScript("window.scrollBy(0,350)", "");

        waitFor(exportPage.orisCodeBox);
        click(exportPage.orisCodeBox);

//        waitFor(exportPage.orisCodeTDBox);
//        click(exportPage.orisCodeTDBox);


        waitFor(exportPage.exportButton);
        //click export button
        click(exportPage.exportButton);


        String searchFile = "QA & Certification _ Export - Smith Generating Facility (SCT1)";
        //check if downloaded file
        VerifyDownload(fileDownloadpath, searchFile);

        closebrowser();
    }

}
