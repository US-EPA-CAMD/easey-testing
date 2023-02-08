package tests.UITests.EASEYIn_Emissioners.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;
import tests.utils.UITestBase;

public class Test_EASEY_RataLocal extends CommonExport {
    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");

    @Test()
    public void tests() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/qa-test");

        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        waitFor(qaCertificationPage.title);

        click(qaCertificationPage.login);
        verifyEquals(qaCertificationPage.login, "Log In");


        verifyEquals(qaCertificationPage.usernameModalQA.getText(), "Username");
        input(qaCertificationPage.usernameFieldModalQA, username);

        verifyEquals(qaCertificationPage.passwordLabelModal.getText(), "Password");
        input(qaCertificationPage.passwordFieldModal, password);

        verifyEquals(qaCertificationPage.logInButtonSubmit, "Log In");
        click(qaCertificationPage.logInButtonSubmit);

        waitFor(driver -> !isDisplayed(qaCertificationPage.logInButtonSubmit));


        waitFor(qaCertificationPage.dashWorkspace);
        verifyEquals(qaCertificationPage.dashWorkspace, "Workspace");

        waitFor(qaCertificationPage.title);
        waitFor(qaCertificationPage.filterByKeywordBoxQa);

        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");


        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBoxQa);

        //Search for facility
        input(qaCertificationPage.filterByKeywordBoxQa, "Smith Generating");
        click(qaCertificationPage.filterByKeywordBTNQa);

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));

        //verify the search returns the correct results
        //verifyEquals(qaCertificationPage.facilityName, "Smith Generating Facility");

        //waits for return
        waitFor(driver -> qaCertificationPage.facilityCaret.size() > 1);

        //if "Check Back in" button is visible press it (handles if the facility was already checked out by a failed test)
        if (isDisplayed(qaCertificationPage.checkBACKINBTN)) {
            click(qaCertificationPage.checkBACKINBTN);
            waitFor(qaCertificationPage.configOpenButton.get(1));
        }

        //wait for an open button to load
        waitFor(qaCertificationPage.configOpenButton);

        //click smith generating SC5 or fifth "open" button
        click(qaCertificationPage.configOpenButton.get(5));

        //wait for the tab to load
        waitFor(qaCertificationPage.configTab1);

        // Clicks on Smith Tab
        click(qaCertificationPage.configTab1);


        waitFor(driver -> !isDisplayed(qaCertificationPage.selectConfigTitle));


        //click check out btn here
        waitFor(qaCertificationPage.configcheckOutButton);

        //click check out facility
        click(qaCertificationPage.configcheckOutButton);
        waitFor(driver -> !isDisplayed(qaCertificationPage.configcheckOutButton));

        //waitFor(qaCertificationPage.testTypeGroupBox);

        //click into test type box and make selection
        click(qaCertificationPage.testTypeGroupBox);


        click(qaCertificationPage.mpTabWKSPC);

        waitFor(qaCertificationPage.revertToOfficailBTN);

        click(qaCertificationPage.revertToOfficailBTN);

        waitFor(qaCertificationPage.yesSaveBTN);
        click(qaCertificationPage.yesSaveBTN);

        waitFor(driver -> !isDisplayed(qaCertificationPage.stopAnimationBTN));

        logOutMethod();

        closebrowser();


    }

}
