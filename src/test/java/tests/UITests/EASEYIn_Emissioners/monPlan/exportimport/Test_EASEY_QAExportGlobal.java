package tests.UITests.EASEYIn_Emissioners.monPlan.exportimport;

import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;

//This test launches from MP, selects facility, navigates to the export tab, and exports the QA data(checks user's downloads folder for file)
public class Test_EASEY_QAExportGlobal extends CommonExport {
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    @Test
    public void test() throws InterruptedException {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox, "Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);
        //waits for return
        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //verifies at least one search result returns
        //verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        waitFor(monitoringPlansPage.configOpenButton);
        click(monitoringPlansPage.configOpenButton.get(5));
        waitFor(monitoringPlansPage.configTab1);
        click(monitoringPlansPage.configTab1);
        waitFor(monitoringPlansPage.exportTab);
        //clicks the export tab on the left menu  column
        click(monitoringPlansPage.exportTab);
        //creates new export page object to access properties specific to export
        ExportPage exportPage = new ExportPage(driver);
        Thread.sleep(5000);
        waitFor(exportPage.title);
        //verify on export page
        verifyEquals(exportPage.title, "Export Data");

        //EXPORT BUTTON GREYED OUT UNTIL MP BUTTON SELECTED
        click(exportPage.MPButton);
        click(exportPage.qaButton);

        waitFor(exportPage.exportButton);
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
