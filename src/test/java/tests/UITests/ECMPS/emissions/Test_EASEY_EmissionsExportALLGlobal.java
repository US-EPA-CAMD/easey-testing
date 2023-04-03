package tests.UITests.ECMPS.emissions;

import org.testng.annotations.Test;
import pages.EmissionsPage;
import tests.utils.CommonExport;

public class Test_EASEY_EmissionsExportALLGlobal extends CommonExport {
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

        //export first file
        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //heat input
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyHeatOption);

        click(emissionsPage.hourlyHeatOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //SO2 cems
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlySO2Option);

        click(emissionsPage.hourlySO2Option);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //NOx Mass
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyNOxOption);

        click(emissionsPage.hourlyNOxOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //NOx rate
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyNOxRateOption);

        click(emissionsPage.hourlyNOxRateOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //CO2 cems
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyCO2cemsOption);

        click(emissionsPage.hourlyCO2cemsOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //heat input
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.heatInputOption);

        click(emissionsPage.heatInputOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly heat input
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyHeatInputOption);

        click(emissionsPage.hourlyHeatInputOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly so2 appendix
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyS02AppendixOption);

        click(emissionsPage.hourlyS02AppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly co2 appendix
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyC02AppendixOption);

        click(emissionsPage.hourlyC02AppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly nox appendix
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.hourlyNOxAppendixOption);

        click(emissionsPage.hourlyNOxAppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //unit level fuel curve
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.unitLevelFuelCurveOption);

        click(emissionsPage.unitLevelFuelCurveOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //daily calibration
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.dailyCalibrationOption);

        click(emissionsPage.dailyCalibrationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //other daily tests
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.otherDailyTestsOption);

        click(emissionsPage.otherDailyTestsOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats hcl
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.matsHCLOption);

        click(emissionsPage.matsHCLOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats hf
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.matsHFOption);

        click(emissionsPage.matsHFOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats so2
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.matsSO2Option);

        click(emissionsPage.matsSO2Option);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats weekly
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.matsWeeklyOption);

        click(emissionsPage.matsWeeklyOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats sorbent
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.matsSorbentOption);

        click(emissionsPage.matsSorbentOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //moisture
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.moistureOption);

        click(emissionsPage.moistureOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //co2 daily fuel
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.co2DailyFuelOption);

        click(emissionsPage.co2DailyFuelOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //long term fuel flow
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.longTermFuelFlowOption);

        click(emissionsPage.longTermFuelFlowOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //lme
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.lmeOption);

        click(emissionsPage.lmeOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //co2 calculation
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.co2CalculationOption);

        click(emissionsPage.co2CalculationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mass oil calculation
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.massOilCalculationOption);

        click(emissionsPage.massOilCalculationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //nsps4t
        click(emissionsPage.viewTemplateDropdown);

        waitFor(emissionsPage.nsps4tSummaryOption);

        click(emissionsPage.nsps4tSummaryOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);



        //check and close out


        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1) ";
        //check if downloaded file
        VerifyDownloadnoDATE(fileDownloadpath, searchFile);

        closebrowser();


    }
}
