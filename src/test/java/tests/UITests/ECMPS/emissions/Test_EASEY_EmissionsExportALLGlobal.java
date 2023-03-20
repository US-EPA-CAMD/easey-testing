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
        click(emissionsPage.viewTemplateDropDown);

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

        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1) ";
        //check if downloaded file
        VerifyDownloadnoDATE(fileDownloadpath, searchFile);

        closebrowser();


    }
}
