package tests.UITests.ECMPS.exportImport;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

import java.util.Arrays;

public class Test_EASEY_MonPlanExportALLMultipleFacilities extends CommonExport {

    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    private static String homeTitle = "About ECMPS 2.0 Beta";

    private static String facilitySearch = "Smith Generating";

    private static String expectedFileName = "MP Export - Smith Generating Facility, SCT1";


    String[] facilitiesList = {"Smith","Escalante"};
    String[] downloadedFacilityFiles = {"MP Export - Smith Generating Facility, SCT1", "MP Export - Escalante, 1"};
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


        for (int i = 0; i < facilitiesList.length; i++) {
            System.out.println(facilitiesList[i]);


            waitFor(monitoringPlansPage.selectConfigButton);
            //wait for search bar to load
            waitFor(monitoringPlansPage.filterByKeywordBox);



            //Search for facility
            input(monitoringPlansPage.filterByKeywordBox, facilitiesList[i]);
            click(monitoringPlansPage.filterByKeywordButton);

            //wait for search result to return
            waitFor(driver -> monitoringPlansPage.facilityCaret.size() > 1);
            // Clicks on first option caret
            click(monitoringPlansPage.facilityCaret.get(0));

            //wait for "open" button
            waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);

            //click first "open" button
            click(monitoringPlansPage.configOpenButton.get(0));


            //wait for the tab to load
            waitFor(monitoringPlansPage.configTab1);

            // Clicks on Smith Tab
            click(monitoringPlansPage.configTab1);

            //wait for stop animation button to disappear
            waitFor(driver -> !isDisplayed(monitoringPlansPage.stopAnimationButton));


            waitFor(monitoringPlansPage.exportBTN);

            click(monitoringPlansPage.exportBTN);

            ReadDropdownValues("sections");

            click(monitoringPlansPage.closeConfigTabBTN);
        }

    }
}
