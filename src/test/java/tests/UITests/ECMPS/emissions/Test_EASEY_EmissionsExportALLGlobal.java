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


        //TODO: Possible improvement- Add options to an array and loop through them: update in one place
        // The pattern for cycling through dropdowns is - wait for OptionA, click OptionA, export, wait for OptionA, click OptionB..
        //This pattern works the dropdown from first to last. After exporting it keeps the last option exported. By following the order and
        //waiting for the previously exported option you don't have to scroll through the dropdown.

        //heat input
        waitFor(emissionsPage.emissionsViewCountOption);
        click(emissionsPage.emissionsViewCountOption);

        waitFor(emissionsPage.hourlyHeatOption);

        click(emissionsPage.hourlyHeatOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //SO2 cems
        waitFor(emissionsPage.hourlyHeatOption);
        click(emissionsPage.emissionsViewCountOption);

        waitFor(emissionsPage.hourlySO2Option);

        click(emissionsPage.hourlySO2Option);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //NOx Mass
        waitFor(emissionsPage.hourlySO2Option);
        click(emissionsPage.hourlySO2Option);

        waitFor(emissionsPage.hourlyNOxOption);

        click(emissionsPage.hourlyNOxOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //NOx rate
        waitFor(emissionsPage.hourlyNOxOption);
        click(emissionsPage.hourlyNOxOption);

        waitFor(emissionsPage.hourlyNOxRateOption);

        click(emissionsPage.hourlyNOxRateOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //CO2 cems
        waitFor(emissionsPage.hourlyNOxRateOption);
        click(emissionsPage.hourlyNOxRateOption);

        waitFor(emissionsPage.hourlyCO2cemsOption);

        click(emissionsPage.hourlyCO2cemsOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //heat input
        waitFor(emissionsPage.hourlyCO2cemsOption);
        click(emissionsPage.hourlyCO2cemsOption);

        waitFor(emissionsPage.heatInputOption);

        click(emissionsPage.heatInputOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly heat input
        waitFor(emissionsPage.heatInputOption);
        click(emissionsPage.heatInputOption);

        waitFor(emissionsPage.hourlyHeatInputOption);

        click(emissionsPage.hourlyHeatInputOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly so2 appendix
        waitFor(emissionsPage.hourlyHeatInputOption);
        click(emissionsPage.hourlyHeatInputOption);

        waitFor(emissionsPage.hourlyS02AppendixOption);

        click(emissionsPage.hourlyS02AppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly co2 appendix
        waitFor(emissionsPage.hourlyS02AppendixOption);
        click(emissionsPage.hourlyS02AppendixOption);

        waitFor(emissionsPage.hourlyC02AppendixOption);

        click(emissionsPage.hourlyC02AppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //hourly nox appendix
        waitFor(emissionsPage.hourlyC02AppendixOption);
        click(emissionsPage.hourlyC02AppendixOption);

        waitFor(emissionsPage.hourlyNOxAppendixOption);

        click(emissionsPage.hourlyNOxAppendixOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //unit level fuel curve
        waitFor(emissionsPage.hourlyNOxAppendixOption);
        click(emissionsPage.hourlyNOxAppendixOption);

        waitFor(emissionsPage.unitLevelFuelCurveOption);

        click(emissionsPage.unitLevelFuelCurveOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //daily calibration
        waitFor(emissionsPage.unitLevelFuelCurveOption);
        click(emissionsPage.unitLevelFuelCurveOption);

        waitFor(emissionsPage.dailyCalibrationOption);

        click(emissionsPage.dailyCalibrationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //other daily tests
        waitFor(emissionsPage.dailyCalibrationOption);
        click(emissionsPage.dailyCalibrationOption);

        waitFor(emissionsPage.otherDailyTestsOption);

        click(emissionsPage.otherDailyTestsOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats hcl
        waitFor(emissionsPage.otherDailyTestsOption);
        click(emissionsPage.otherDailyTestsOption);

        waitFor(emissionsPage.matsHCLOption);

        click(emissionsPage.matsHCLOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats hf
        waitFor(emissionsPage.matsHCLOption);
        click(emissionsPage.matsHCLOption);

        waitFor(emissionsPage.matsHFOption);

        click(emissionsPage.matsHFOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats so2
        waitFor(emissionsPage.matsHFOption);
        click(emissionsPage.matsHFOption);

        waitFor(emissionsPage.matsSO2Option);

        click(emissionsPage.matsSO2Option);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats weekly
        waitFor(emissionsPage.matsSO2Option);
        click(emissionsPage.matsSO2Option);

        waitFor(emissionsPage.matsWeeklyOption);

        click(emissionsPage.matsWeeklyOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mats sorbent
        waitFor(emissionsPage.matsWeeklyOption);
        click(emissionsPage.matsWeeklyOption);

        waitFor(emissionsPage.matsSorbentOption);

        click(emissionsPage.matsSorbentOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //moisture
        waitFor(emissionsPage.matsSorbentOption);
        click(emissionsPage.matsSorbentOption);

        waitFor(emissionsPage.moistureOption);

        click(emissionsPage.moistureOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //co2 daily fuel
        waitFor(emissionsPage.moistureOption);
        click(emissionsPage.moistureOption);

        waitFor(emissionsPage.co2DailyFuelOption);

        click(emissionsPage.co2DailyFuelOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //long term fuel flow
        waitFor(emissionsPage.co2DailyFuelOption);
        click(emissionsPage.co2DailyFuelOption);

        waitFor(emissionsPage.longTermFuelFlowOption);

        click(emissionsPage.longTermFuelFlowOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //lme
        waitFor(emissionsPage.longTermFuelFlowOption);
        click(emissionsPage.longTermFuelFlowOption);

        waitFor(emissionsPage.lmeOption);

        click(emissionsPage.lmeOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //co2 calculation
        waitFor(emissionsPage.lmeOption);
        click(emissionsPage.lmeOption);

        waitFor(emissionsPage.co2CalculationOption);

        click(emissionsPage.co2CalculationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //mass oil calculation
        waitFor(emissionsPage.co2CalculationOption);
        click(emissionsPage.co2CalculationOption);

        waitFor(emissionsPage.massOilCalculationOption);

        click(emissionsPage.massOilCalculationOption);

        waitFor(emissionsPage.exportBTN);

        click(emissionsPage.exportBTN);

        //nsps4t
        waitFor(emissionsPage.massOilCalculationOption);
        click(emissionsPage.massOilCalculationOption);

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
