package tests.UITests.ECMPS.exportImport;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

public class Test_EASEY_MonPlanExportALLGlobal extends CommonExport {

    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    private static String homeTitle = "About ECMPS 2.0 Beta";

    private static String facilitySearch = "Smith Generating";

    private static String expectedFileName = "MP Export - Smith Generating Facility, SCT1";
    @Test
    public void test() throws InterruptedException {
    //        Navigate to EASEY In
    //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://ecmps-dev.app.cloud.gov/");


        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        waitFor(monitoringPlansPage.homeTitle);

        verifyEquals(monitoringPlansPage.homeTitle, homeTitle);

        click(monitoringPlansPage.monPlanTab);
        //check if page is MP
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
        //wait for search bar to load
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,facilitySearch);
        click(monitoringPlansPage.filterByKeywordButton);


        // Clicks on Smith
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);


        click(monitoringPlansPage.configOpenButton.get(0));


        //wait for the tab to load
        waitFor(monitoringPlansPage.configTab1);

        // Clicks on Smith Tab
        click(monitoringPlansPage.configTab1);


        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //formula

        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.formulaOption);

//        click(monitoringPlansPage.sectionsDropdownlist.get(0));

        click(monitoringPlansPage.exportBTN);

        //loads
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.exportBTN);

        //location attributes
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.locationAttributesOption);

        click(monitoringPlansPage.locationAttributesOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //methods
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.methodsOption);

        click(monitoringPlansPage.methodsOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //Qualifications
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.qualificationsOption);

        click(monitoringPlansPage.qualificationsOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //rectangular duct wafs
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.rectangularDuctWAFSOption);

        click(monitoringPlansPage.rectangularDuctWAFSOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //spans
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.spansOption);

        click(monitoringPlansPage.spansOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //systems
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.systemsOption);

        click(monitoringPlansPage.systemsOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //unit info
        waitFor(monitoringPlansPage.sectionsDropDown);

        click(monitoringPlansPage.sectionsDropDown);

        waitFor(monitoringPlansPage.unitInformationOption);

        click(monitoringPlansPage.unitInformationOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);


        //check if downloaded file
        VerifyDownload(fileDownloadpath, expectedFileName);



        closebrowser();
    }


}
