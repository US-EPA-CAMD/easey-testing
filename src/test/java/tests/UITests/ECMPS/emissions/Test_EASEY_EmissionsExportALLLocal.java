package tests.UITests.ECMPS.emissions;

import org.testng.annotations.Test;
import pages.EmissionsPage;
import tests.utils.CommonExport;

public class Test_EASEY_EmissionsExportALLLocal extends CommonExport {
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");

    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/emissions");

        EmissionsPage emissionsPage = new EmissionsPage(driver);

        verifyEquals(emissionsPage.title, "Emissions");

        verifyEquals(emissionsPage.logInButtonOpenModal, "Log In");
        click(emissionsPage.logInButtonOpenModal);

        verifyEquals(emissionsPage.usernameLabelModal.getText(), "Username");
        input(emissionsPage.usernameFieldModal, username);

        verifyEquals(emissionsPage.passwordLabelModal.getText(), "Password");
        input(emissionsPage.passwordFieldModal, password);

        verifyEquals(emissionsPage.logInButtonSubmit, "Log In");
        click(emissionsPage.logInButtonSubmit);



        waitFor(emissionsPage.title);

        verifyEquals(emissionsPage.title, "Emissions");


        waitFor(emissionsPage.filterByKeywordBox);

        //Search for facility
        input(emissionsPage.filterByKeywordBox,"Smith Generating");
        waitFor(emissionsPage.filterByKeywordButton);
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

        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1) ";
        //check if downloaded file
        VerifyDownloadnoDATE(fileDownloadpath, searchFile);

        //closing out
        logOutMethod();

        closebrowser();

    }


}
