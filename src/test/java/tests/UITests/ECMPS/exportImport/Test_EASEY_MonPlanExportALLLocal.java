package tests.UITests.ECMPS.exportImport;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import pages.QaCertificationPage;
import tests.utils.CommonExport;

public class Test_EASEY_MonPlanExportALLLocal extends CommonExport {

    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");

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

        //logOn
        logOn(username,password,monitoringPlansPage);


        //verify on the correct page
        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        //wait for search bar to load
        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350)", "");

        // Clicks on Smith
        click(monitoringPlansPage.facilityCaret.get(0));

        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
//        verifyEquals(monitoringPlansPage.configOpenButton.get(0), "Open");


        click(monitoringPlansPage.configOpenButton.get(0));


        //wait for the tab to load
        waitFor(monitoringPlansPage.configTab1);

        // Clicks on Smith Tab
        click(monitoringPlansPage.configTab1);

       //export Methods - first option
        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //Qualifications
        waitFor(monitoringPlansPage.methodsOption);
        click(monitoringPlansPage.methodsOption);

        waitFor(monitoringPlansPage.qualificationsOption);

        click(monitoringPlansPage.qualificationsOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //rectangular duct wafs
        waitFor(monitoringPlansPage.qualificationsOption);
        click(monitoringPlansPage.qualificationsOption);

        waitFor(monitoringPlansPage.rectangularDuctWAFSOption);

        click(monitoringPlansPage.rectangularDuctWAFSOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //spans
        waitFor(monitoringPlansPage.rectangularDuctWAFSOption);
        click(monitoringPlansPage.rectangularDuctWAFSOption);

        waitFor(monitoringPlansPage.spansOption);

        click(monitoringPlansPage.spansOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //systems
        waitFor(monitoringPlansPage.spansOption);
        click(monitoringPlansPage.spansOption);

        waitFor(monitoringPlansPage.systemsOption);

        click(monitoringPlansPage.systemsOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);
        //unit info
        waitFor(monitoringPlansPage.systemsOption);
        click(monitoringPlansPage.systemsOption);

        waitFor(monitoringPlansPage.unitInformationOption);

        click(monitoringPlansPage.unitInformationOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

//        formula
        waitFor(monitoringPlansPage.unitInformationOption);
        click(monitoringPlansPage.unitInformationOption);

        waitFor(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.exportBTN);

        //loads
        waitFor(monitoringPlansPage.formulaOption);
        click(monitoringPlansPage.formulaOption);

        waitFor(monitoringPlansPage.loadsOption);

        click(monitoringPlansPage.loadsOption);

        click(monitoringPlansPage.exportBTN);

//        location attributes
        waitFor(monitoringPlansPage.loadsOption);
        click(monitoringPlansPage.loadsOption);

        waitFor(monitoringPlansPage.locationAttributesOption);

        click(monitoringPlansPage.locationAttributesOption);

        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

       ;


        String searchFile = "MP Export - Smith Generating Facility, SCT1 ";
        //check if downloaded file
        VerifyDownload(fileDownloadpath, searchFile);
        //closing out
        logOutMethod();


        closebrowser();
    }
}
