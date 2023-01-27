package tests.UITests.EASEYIn_Emissioners.QA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class Test_EASEY_QaLinearityViewLocal extends CommonExport {

    private static String username = System.getenv("MACKENZIE_TESTING_USERNAME");
    private static String password = System.getenv("MACKENZIE_TESTING_PASSWORD");


    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/qa-test");

        QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

        waitFor(qaCertificationPage.title);

        verifyEquals(qaCertificationPage.login, "Log In");
        click(qaCertificationPage.login);

        verifyEquals(qaCertificationPage.usernameModalQA.getText(), "Username");
        input(qaCertificationPage.usernameFieldModalQA, username);

        verifyEquals(qaCertificationPage.passwordLabelModal.getText(), "Password");
        input(qaCertificationPage.passwordFieldModal, password);

        verifyEquals(qaCertificationPage.logInButtonSubmit, "Log In");
        click(qaCertificationPage.logInButtonSubmit);

        waitFor(qaCertificationPage.dashWorkspace);
        verifyEquals(qaCertificationPage.dashWorkspace, "Workspace");

        waitFor(qaCertificationPage.title);
        waitFor(qaCertificationPage.filterByKeywordBox);

        verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");


        //wait for search bar to be visible
        waitFor(qaCertificationPage.filterByKeywordBox);

        //Search for facility
        input(qaCertificationPage.filterByKeywordBoxQa, "Smith Generating");
        click(qaCertificationPage.filterByKeywordBTNQa);

        // Clicks on first search result
        click(qaCertificationPage.facilityCaret.get(0));

        //verify the search returns the correct results
        //verifyEquals(qaCertificationPage.facilityName, "Smith Generating Facility");

        //waits for return
        waitFor(driver -> qaCertificationPage.facilityCaret.size() > 1);
//        sleep(90000);
//        sleep(90000);
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

        //Wait for load: "Test Type Box"
        waitFor(qaCertificationPage.testTypeGroupBox);

        //click check out btn here
        waitFor(qaCertificationPage.configcheckOutButton);

        //click check out facility
        click(qaCertificationPage.configcheckOutButton);

        waitFor(qaCertificationPage.testTypeGroupBox);

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
        sleep(90000);

        // makeModalSelections();


        //make modal selections: click into box and make selection or pass it the date
        waitFor(qaCertificationPage.componentIDBox);
        click(qaCertificationPage.componentIDBox);
        waitFor(qaCertificationPage.componentID700option);
        click(qaCertificationPage.componentID700option);

        waitFor(qaCertificationPage.spanScaleCodeBox);
        click(qaCertificationPage.spanScaleCodeBox);
        waitFor(qaCertificationPage.spanScaleCodeHigh);
        click(qaCertificationPage.spanScaleCodeHigh);

        waitFor(qaCertificationPage.testNumberBox);
        click(qaCertificationPage.testNumberBox);
        input(qaCertificationPage.testNumberBox, "1");

        waitFor(qaCertificationPage.testReasonCodeBox);
        click(qaCertificationPage.testReasonCodeBox);
        waitFor(qaCertificationPage.selectionTestReasonCode);
        click(qaCertificationPage.selectionTestReasonCode);


        waitFor(qaCertificationPage.testResultCodeBox);
        click(qaCertificationPage.testResultCodeBox);
        waitFor(qaCertificationPage.testResultCodeBoxEntry);
        click(qaCertificationPage.testResultCodeBoxEntry);

        waitFor(qaCertificationPage.beginDate);
        click(qaCertificationPage.beginDate);
        input(qaCertificationPage.beginDate, "01/01/2022");

        waitFor(qaCertificationPage.beginHour);
        click(qaCertificationPage.beginHour);
        click(qaCertificationPage.beginHourSelection);

        waitFor(qaCertificationPage.beginMinute);
        click(qaCertificationPage.beginMinute);
        click(qaCertificationPage.beginMinuteSelection);

        waitFor(qaCertificationPage.endDate);
        click(qaCertificationPage.endDate);
        input(qaCertificationPage.endDate, "01/01/2023");

        waitFor(qaCertificationPage.endHour);
        click(qaCertificationPage.endHour);
        waitFor(qaCertificationPage.endHourSelection);
        click(qaCertificationPage.endHourSelection);

        waitFor(qaCertificationPage.endMinute);
        click(qaCertificationPage.endMinute);
        waitFor(qaCertificationPage.endMinuteSelection);
        click(qaCertificationPage.endMinuteSelection);
        sleep(90000);

        //TODO verify and print selections somehow??!!
        // System.out.println("Unit or Stack Pipe ID:" + qaCertificationPage.UnitIdBox.getText());
        //System.out.println("Test Type Code:" + qaCertificationPage.testTypeCodeBox.getText());
        System.out.println("Component ID:" + qaCertificationPage.componentID700option.isDisplayed());
        System.out.println("Span Scale Code:" + qaCertificationPage.spanScaleCodeHigh.isDisplayed());
        //System.out.println("Test Number:" + qaCertificationPage.testNumberBox.getText());
        System.out.println("Test Reason:" + qaCertificationPage.qaSelectionTestReasonCode.isDisplayed());
        System.out.println("Test Result Code:" + qaCertificationPage.testResultCodeBoxEntry.isDisplayed());
//            System.out.println("Begin Date:" + qaCertificationPage.beginDate.getText());
//            System.out.println("Begin Hour:" + qaCertificationPage.beginHour.getText());
//            System.out.println("Begin Minute:" + qaCertificationPage.beginMinute.getText());
//            System.out.println("End Date:" + qaCertificationPage.endDate.getText());
//            System.out.println("End Hour:" + qaCertificationPage.endHour.getText());
//            System.out.println("End Minute:" + qaCertificationPage.endMinute.getText());

        waitFor(qaCertificationPage.saveBTN);
        System.out.println("Clicking submit");
        wait(999999999);
        clickSubmit();
        //click(qaCertificationPage.saveBTN);


        waitFor(qaCertificationPage.editDataBTN);
        waitFor(qaCertificationPage.removeDataBTN);
        //
        waitFor(qaCertificationPage.testTypeCodeTableHeader);
        waitFor(qaCertificationPage.testTypeCodeTableContents);
        //remove the data
        click(qaCertificationPage.removeDataBTN);
        System.out.println("Data entry was removed");
        //click check in
        waitFor(qaCertificationPage.checkInBTN);
        click(qaCertificationPage.checkInBTN);
        //wait for check out button to load to be sure it finished
        waitFor(qaCertificationPage.configcheckOutButton);
        System.out.println("Facility was checked back in!!");
        sleep(90000);

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
