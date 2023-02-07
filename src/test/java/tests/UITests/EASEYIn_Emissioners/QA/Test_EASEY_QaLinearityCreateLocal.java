package tests.UITests.EASEYIn_Emissioners.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

public class Test_EASEY_QaLinearityCreateLocal extends CommonExport {

    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");

    //This test will log in, select facility(Smith), select "Linearity Summary" from Test Type, and make modal selections to add a record
    @Test
    public void test() throws InterruptedException {
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
        //wait for drop down
        waitFor(qaCertificationPage.linearitySummary);
        //select "Linearity Summary" from drop down
        click(qaCertificationPage.linearitySummary);


        //click add test data
        waitFor(qaCertificationPage.addTestDataBTN);
        click(qaCertificationPage.addTestDataBTN);

        //wait for the modal to pop up
        waitFor(qaCertificationPage.testSummaryModalTitle);

        // waitFor(qaCertificationPage.testSummaryModalText);

        //try catch for modal selections
        //try {


        // makeModalSelections();


        //make modal selections: click into box and make selection or pass it the date
//        waitFor(qaCertificationPage.componentIDBox);
//        click(qaCertificationPage.componentIDBox);
        waitFor(qaCertificationPage.componentIDDropdown);
        click(qaCertificationPage.componentIDBox);
        click(qaCertificationPage.componentIDDropdown.get(1));

        waitFor(qaCertificationPage.spanScaleCodeBox);
        click(qaCertificationPage.spanScaleCodeBox);
        waitFor(qaCertificationPage.spanScaleCodeHigh);
        click(qaCertificationPage.spanScaleCodeHigh);

        waitFor(qaCertificationPage.testNumberBox);
        click(qaCertificationPage.testNumberBox);
        input(qaCertificationPage.testNumberBox, "8882");

        waitFor(qaCertificationPage.testReasonCodeBox);
        click(qaCertificationPage.testReasonCodeBox);
        //waitFor(qaCertificationPage.testReasonCodeCodeDropdown);
        //click(qaCertificationPage.selectionTestReasonCode);
        click(qaCertificationPage.testReasonCodeCodeDropdown.get(1));


        waitFor(qaCertificationPage.testResultCodeBox);
        click(qaCertificationPage.testResultCodeBox);
        //waitFor(qaCertificationPage.testResultCodeBoxEntry);
        //click(qaCertificationPage.testResultCodeBoxEntry);
        click(qaCertificationPage.testResultsCodeCodeDropdown.get(9));

        waitFor(qaCertificationPage.beginDate);
        click(qaCertificationPage.beginDate);
        input(qaCertificationPage.beginDate, "01/01/2022");

        waitFor(qaCertificationPage.beginHour);
        click(qaCertificationPage.beginHourDropdown.get(1));
        //click(qaCertificationPage.beginHourSelection);

        waitFor(qaCertificationPage.beginMinute);
        click(qaCertificationPage.beginMinDropdown.get(1));
        //click(qaCertificationPage.beginMinuteSelection);

        waitFor(qaCertificationPage.endDate);
        click(qaCertificationPage.endDate);
        input(qaCertificationPage.endDate, "01/01/2023");

        waitFor(qaCertificationPage.endHour);
        click(qaCertificationPage.endHourDropdown.get(1));
//        waitFor(qaCertificationPage.endHourSelection);
//        click(qaCertificationPage.endHourSelection);

        waitFor(qaCertificationPage.endMinute);
        click(qaCertificationPage.endMinDropdown.get(1));
//        waitFor(qaCertificationPage.endMinuteSelection);
//        click(qaCertificationPage.endMinuteSelection);


        waitFor(qaCertificationPage.saveBTN1);
        System.out.println("Clicking submit");

        //clickSubmit();
        click(qaCertificationPage.saveBTN1);

        waitFor(driver -> !isDisplayed(qaCertificationPage.saveBTN1));


        click(qaCertificationPage.mpTabWKSPC);

        waitFor(qaCertificationPage.revertToOfficailBTN);

        click(qaCertificationPage.revertToOfficailBTN);

        waitFor(qaCertificationPage.yesSaveBTN);
        click(qaCertificationPage.yesSaveBTN);

        waitFor(driver -> !isDisplayed(qaCertificationPage.stopAnimationBTN));

        logOutMethod();

        closebrowser();


    }

    private void makeModalSelections() {
        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);
        //make modal selections: click into box and make selection or pass it the date
        click(qaCertificationPage.componentIDBox);
        click(qaCertificationPage.componentID700option);

        click(qaCertificationPage.spanScaleCodeBox);
        click(qaCertificationPage.spanScaleCodeHigh);

        click(qaCertificationPage.testNumberBox);
        input(qaCertificationPage.testNumberBox, "1");

        click(qaCertificationPage.testReasonCodeBox);
        click(qaCertificationPage.qaSelectionTestReasonCode);

        click(qaCertificationPage.testResultCodeBox);
        click(qaCertificationPage.testResultCodeBoxEntry);

        click(qaCertificationPage.beginDate);
        input(qaCertificationPage.beginDate, "01/01/2022");

        click(qaCertificationPage.beginHour);
        click(qaCertificationPage.zeroEntry);

        click(qaCertificationPage.beginMinute);
        click(qaCertificationPage.zeroEntry);

        click(qaCertificationPage.endDate);
        input(qaCertificationPage.endDate, "01/01/2023");

        click(qaCertificationPage.endHour);
        click(qaCertificationPage.zeroEntry);

        click(qaCertificationPage.endMinute);
        click(qaCertificationPage.zeroEntry);
        sleep(90000);
        click(qaCertificationPage.saveBTN);

    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='saveBtn']"))).click();
        System.out.println("Submit was pressed");
    }

}
