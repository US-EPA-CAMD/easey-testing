package tests.UITests.ECMPS.exportImport;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;

public class Test_EASEY_MonPlanExportALLGlobal extends CommonExport {
    @Test
    public void test() throws InterruptedException {
    //        Navigate to EASEY In
    //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");




        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        //check if page is MP
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");
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


        waitFor(monitoringPlansPage.exportBTN);

        click(monitoringPlansPage.exportBTN);

        //formula

        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.exportBTN);

        //loads
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.formulaOption);

        click(monitoringPlansPage.exportBTN);

        //location attributes
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.locationAttributesOption);

        click(monitoringPlansPage.locationAttributesOption);

        click(monitoringPlansPage.exportBTN);

        //methods
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.methodsOption);

        click(monitoringPlansPage.methodsOption);

        click(monitoringPlansPage.exportBTN);
        //Qualifications
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.qualificationsOption);

        click(monitoringPlansPage.qualificationsOption);

        click(monitoringPlansPage.exportBTN);
        //rectangular duct wafs
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.rectangularDuctWAFSOption);

        click(monitoringPlansPage.rectangularDuctWAFSOption);

        click(monitoringPlansPage.exportBTN);

        //spans
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.spansOption);

        click(monitoringPlansPage.spansOption);

        click(monitoringPlansPage.exportBTN);

        //systems
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.systemsOption);

        click(monitoringPlansPage.systemsOption);

        click(monitoringPlansPage.exportBTN);
        //unit info
        click(monitoringPlansPage.sectionsDropdown);

        waitFor(monitoringPlansPage.unitInformationOption);

        click(monitoringPlansPage.unitInformationOption);

        click(monitoringPlansPage.exportBTN);


        closebrowser();
    }


}
