package tests.UITests.ECMPS.emissions;

import org.testng.annotations.Test;
import pages.EmissionsPage;
import pages.MonitoringPlansPage;
import tests.UITests.ECMPS.exportImport.CommonExport;

public class Test_EASEY_EmissionsExportGlobal extends CommonExport {
    private static String fileDownloadpath = "C:\\Users\\amandanelson\\Downloads";

    @Test
    public void test() throws InterruptedException {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/emissions
        goToo("ecmps", "/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        //verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
        //wait for search bar to load
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);
        //waits for return
        waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);
        sleep(90000);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //verifies at least one search result returns
//        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");
        waitFor(monitoringPlansPage.configOpenButton);
        //clicks "open" button for first result
        //add wait to let build TODO
        click(monitoringPlansPage.configOpenButton.get(5));
        Thread.sleep(9000);
        click(monitoringPlansPage.configTab1);
        sleep(9000);
        //clicks the export tab on the left menu  column
        EmissionsPage emissionsPage = new EmissionsPage(driver);

        click(emissionsPage.emissionsTab);
        //creates new export page object to access properties specific to export
        Thread.sleep(5000);
        Thread.sleep(5000);
        //verify on export page
        //verifyEquals(monitoringPlansPage.title, "Export Data");
        waitFor(emissionsPage.emissionsExportButton);
        //EXPORT BUTTON GREYED OUT UNTIL MP BUTTON SELECTED
        click(emissionsPage.emissionsExportButton);
        sleep(900000000);

        //click export button
        // click(exportPage.exportButton);

        //give time
        Thread.sleep(5000);

        String searchFile = "Emissions _ Export - Barry (1, 2, CS0AAN)  (19)";
        //check if downloaded file
        VerifyDownload(fileDownloadpath, searchFile);

    }
}