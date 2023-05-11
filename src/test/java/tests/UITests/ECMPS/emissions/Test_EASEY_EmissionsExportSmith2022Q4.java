package tests.UITests.ECMPS.emissions;

import org.testng.annotations.Test;
import pages.EmissionsPage;
import tests.utils.CommonExport;

//This test will open on emissions page, select smith sct1, change reporting period to 2022 Q4, and export the following:(Hourly Combined Parameter View,hourly nox rate,
//heat input unit/stack, hourly heat input, hourly s02 appendix, hourly co2 appendix,  daily calibration, and mass oil)

public class Test_EASEY_EmissionsExportSmith2022Q4 extends CommonExport {

    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/emissions");

        EmissionsPage emissionsPage = new EmissionsPage(driver);

        verifyEquals(emissionsPage.title, "Emissions");

        waitFor(emissionsPage.filterByKeywordBox);

        //Search for facility
        input(emissionsPage.filterByKeywordBox,"Smith Generating");
        click(emissionsPage.filterByKeywordButton);

        // Clicks on Smith
        click(emissionsPage.facilityCaret.get(0));

        waitFor(driver -> emissionsPage.configOpenButton.size() > 1);

        click(emissionsPage.configOpenButton.get(0));


        //wait for the tab to load
        waitFor(emissionsPage.configTab1);

        // Clicks on Smith Tab
        click(emissionsPage.configTab1);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));


        //export first file
        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.xOutReportingPeriod);

        input(emissionsPage.reportingPeriodInput,"2022 Q4");

        waitFor(emissionsPage.q4button);

        click(emissionsPage.q4button);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.applyFilterButton);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));



        waitFor(emissionsPage.exportBTN);
        //Hourly Combined Parameter View - FIRST VIEW TEMPLATE OPTION
        click(emissionsPage.exportBTN);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        //hourly nox rate
        waitFor(emissionsPage.hourlyCombinedOption);
        click(emissionsPage.hourlyCombinedOption);

        waitFor(emissionsPage.hourlyNOxRateOption);

        click(emissionsPage.hourlyNOxRateOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //heat input unit/stack
        waitFor(emissionsPage.hourlyNOxRateOption);
        click(emissionsPage.hourlyNOxRateOption);

        waitFor(emissionsPage.heatInputOption);

        click(emissionsPage.heatInputOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //hourly heat input
        waitFor(emissionsPage.heatInputOption);
        click(emissionsPage.heatInputOption);

        waitFor(emissionsPage.hourlyHeatInputOption);

        click(emissionsPage.hourlyHeatInputOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //hourly so2 appendix
        waitFor(emissionsPage.hourlyHeatInputOption);
        click(emissionsPage.hourlyHeatInputOption);

        waitFor(emissionsPage.hourlyS02AppendixOption);

        click(emissionsPage.hourlyS02AppendixOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);

        //hourly co2 appendix
        waitFor(emissionsPage.hourlyS02AppendixOption);
        click(emissionsPage.hourlyS02AppendixOption);

        waitFor(emissionsPage.hourlyC02AppendixOption);

        click(emissionsPage.hourlyC02AppendixOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //daily calibration
        waitFor(emissionsPage.hourlyC02AppendixOption);
        click(emissionsPage.hourlyC02AppendixOption);

        waitFor(emissionsPage.dailyCalibrationOption);

        click(emissionsPage.dailyCalibrationOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //mass oil
        waitFor(emissionsPage.dailyCalibrationOption);
        click(emissionsPage.dailyCalibrationOption);

        waitFor(emissionsPage.massOilCalculationOption);

        click(emissionsPage.massOilCalculationOption);

        click(emissionsPage.applyFilterButton);

        waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

        waitFor(emissionsPage.exportBTN);
        click(emissionsPage.exportBTN);


        //check and close out


        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1) ";
        //check if downloaded file
        VerifyDownloadnoDATE(fileDownloadpath, searchFile);

        closebrowser();


    }
}
