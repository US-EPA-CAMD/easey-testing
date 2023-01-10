package tests.UITests.EASEYIn_Emissioners.monPlan.export;

import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;

public class Test_EASEY_QAExportGlobal extends CommonExport{
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
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
        //waits for return
        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);
        sleep(90000);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));
        sleep(90000);

        //verifies at least one search result returns
        //verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
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
        click(exportPage.qaButton);
        sleep(900000000);


        //click export button
        click(exportPage.exportButton);

        //give time
        Thread.sleep(5000);

        String searchFile = "QA & Certification _ Export - Smith Generating Facility (SCT5)";
        //check if downloaded file
        VerifyDownloadWithFileExtension(fileDownloadpath, searchFile);

        closebrowser();
    }

}
