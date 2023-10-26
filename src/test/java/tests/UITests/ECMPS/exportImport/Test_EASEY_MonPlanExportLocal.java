package tests.UITests.ECMPS.exportImport;

import org.testng.annotations.Test;
import pages.ExportPage;
import pages.MonitoringPlansPage;
import tests.utils.CommonExport;
//This test launches from MP, logs in, selects facility, navigates to the export tab, and exports the MP data(checks user's downloads folder for file)

public class Test_EASEY_MonPlanExportLocal extends CommonExport {
    //set download path
    //TODO rework file path
    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";
    private static String username = System.getenv("TESTING_USERNAME");
    private static String password = System.getenv("TESTING_PASSWORD");

    @Test()
    public void tests() throws InterruptedException {
        // Navigate to EASEY In
       //https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps","/monitoring-plans");
        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        waitFor(monitoringPlansPage.title);
        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");


        verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        click(monitoringPlansPage.logInButtonOpenModal);

        verifyEquals(monitoringPlansPage.usernameLabelModal.getText(), "Username");
        input(monitoringPlansPage.usernameFieldModal, username);

        verifyEquals(monitoringPlansPage.passwordLabelModal.getText(), "Password");
        input(monitoringPlansPage.passwordFieldModal, password);

        verifyEquals(monitoringPlansPage.logInButtonSubmit, "Log In");
        click(monitoringPlansPage.logInButtonSubmit);

        waitFor(monitoringPlansPage.dashWorkspace);
        verifyEquals(monitoringPlansPage.dashWorkspace, "Workspace");

        verifyEquals(monitoringPlansPage.workspaceMonPlan, "Monitoring Plans");
        click(monitoringPlansPage.workspaceMonPlan);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        waitFor(monitoringPlansPage.filterByKeywordBox);

        //Search for facility
        input(monitoringPlansPage.filterByKeywordBox,"Smith Generating");
        click(monitoringPlansPage.filterByKeywordButton);

        // Clicks on first search result
        click(monitoringPlansPage.facilityCaret.get(0));

        //waits for return
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);
        //verifies at least one search result returns
        verifyEquals(monitoringPlansPage.configOpenButton.get(1), "Open");
        //clicks "open" button for first result
        //add wait to let build TODO
        click(monitoringPlansPage.configOpenButton.get(0));
        waitFor(monitoringPlansPage.configTabSmith1);

        // Clicks on Smith
        //configTabSmith
        click(monitoringPlansPage.configTabSmith1);
        //Wait for load
        waitFor(driver -> monitoringPlansPage.configOpenButton.size() > 1);

        waitFor(monitoringPlansPage.exportBTN);
        click(monitoringPlansPage.exportBTN);

        String searchFile = "MP Export - Smith Generating Facility, SCT1";
        //check if downloaded file
        VerifyDownload(fileDownloadpath, searchFile);



        closebrowser();




    }

}
