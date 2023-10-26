package tests.UITests.ECMPS.emissions;

import org.testng.annotations.Test;
import pages.EmissionsPage;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

public class Test_EASEY_EmissionsExportGlobal extends CommonExport {
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

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
        EmissionsPage emissionsPage = new EmissionsPage(driver);

        click(emissionsPage.emissionsTab);

        //verify on export page
        //verifyEquals(monitoringPlansPage.title, "Export Data");
        waitFor(emissionsPage.emissionsExportButton);


        click(emissionsPage.xOutReportingPeriod);

        waitFor(emissionsPage.reportingPeriodBox);

        input(emissionsPage.reportingPeriodBox,"2022 Q3");

        waitFor(emissionsPage.q3button);
        click(emissionsPage.q3button);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        //EXPORT BUTTON GREYED OUT UNTIL MP BUTTON SELECTED
        waitFor(emissionsPage.emissionsExportButton);

        waitFor(emissionsPage.viewtemplateBox);

        click(emissionsPage.viewtemplateBox.get(14));

        waitFor(emissionsPage.applyFilterButton);
        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

//
//        waitFor(emissionsPage.dailyCalibrationOption);
//        click(emissionsPage.dailyCalibrationOption);

        waitFor(emissionsPage.emissionsExportButton);
        click(emissionsPage.emissionsExportButton);


        //give time
        Thread.sleep(5000);

        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1)  - 2022 - Q3";
        //check if downloaded file
        VerifyDownload(fileDownloadpath, searchFile);

    }
}