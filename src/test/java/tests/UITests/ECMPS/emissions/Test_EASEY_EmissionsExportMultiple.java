package tests.UITests.ECMPS.emissions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmissionsPage;
import tests.utils.CommonExport;

import java.util.List;

//This test will take a list of strings that are used in the facility search bar and then loops through and exports all of it's dropdown values - must have emissions dd values
//for Q4 2022
public class Test_EASEY_EmissionsExportMultiple extends CommonExport {

    // add "Robert Reid"
    String[] facilitiesList = {"Smith", "Moss Landing", "Summit Lake"};

    private static String fileDownloadpath = "C:\\Users\\mackenzieharwood\\Downloads";

    String reportingPeriodInput = "2022 Q4";


    @Test
    public void test() throws InterruptedException {

        WebDriverWait wt = new WebDriverWait(driver, 5);


        Actions actions = new Actions(driver);


        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goToo("ecmps", "/emissions");

        EmissionsPage emissionsPage = new EmissionsPage(driver);

        verifyEquals(emissionsPage.title, "Emissions");

        for (int i = 0; i < facilitiesList.length; i++) {
            //Print the current facility
            System.out.println(facilitiesList[i]);

            //wait for filter by keyword box
            waitFor(emissionsPage.filterByKeywordBox);

            //Search for facility
            input(emissionsPage.filterByKeywordBox, facilitiesList[i]);
            click(emissionsPage.filterByKeywordButton);

            // Clicks on First option
            click(emissionsPage.facilityCaret.get(0));

            //wait for an option to load
            waitFor(driver -> emissionsPage.configOpenButton.size() > 1);

            //click the first option
            click(emissionsPage.configOpenButton.get(0));

            //wait for the tab to load
            waitFor(emissionsPage.configTab1);

            // clicks on Tab
            click(emissionsPage.configTab1);

            //wait for the spinner to disappear
            waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

            //wait for the export button
            waitFor(emissionsPage.exportBTN);

            waitFor(emissionsPage.xOutReportingPeriod);

            //clear current reporting period
            click(emissionsPage.xOutReportingPeriod);

            //input 2022 q4
            input(emissionsPage.reportingPeriodInput, reportingPeriodInput);

            //wait for and click 2022 q4 option
            waitFor(emissionsPage.q4button);

            click(emissionsPage.q4button);

            //wait for the spinner to disappear
            waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));


            //create a list of webElements named <options> for each facility in the array
            List<WebElement> options = emissionsPage.ReadDropdownValues("viewtemplate");
            System.out.println(options + "\n" + "WebElement LIST HERE!!!!!");


            //wait for the apply filter button to be clickable
            wt.until(ExpectedConditions.elementToBeClickable(emissionsPage.applyFilterButton));
            actions.moveToElement(emissionsPage.applyFilterButton).click().perform();

            waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

            for (int v = 0; v < options.size(); v++) {
                int currentOption = options.indexOf(v);

                //If it is not the first option do the following
                if (currentOption > 0) {

                    //wait for the spinner to disappear
                    waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

                    int previousOption = v - 1;
                    //wait for and click the PREVIOUS OPTION
                    waitFor(options.get(previousOption));
                    click(options.get(previousOption));

                    //wait for and click the CURRENT OPTION
                    waitFor(options.get(v));
                    click(options.get(v));

                    wt.until(ExpectedConditions.elementToBeClickable(emissionsPage.applyFilterButton));

                    click(emissionsPage.applyFilterButton);

                    waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

                    //wait for and click export btn
//                    waitFor(emissionsPage.exportBTN);
//                    click(emissionsPage.exportBTN);
                    v++;
                }
                //Else it's the first option
                else {

                    waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

                    //wait for and click export btn
                    waitFor(emissionsPage.exportBTN);
                    click(emissionsPage.exportBTN);

                    waitFor(driver -> !isDisplayed(emissionsPage.stopAnimationButton));

                    v++;
                }

            }

            click(emissionsPage.closeConfigTabBTN);
        }

        String searchFile = "Emissions _ Export - Smith Generating Facility (SCT1) ";
        //check if downloaded file
        VerifyDownloadnoDATE(fileDownloadpath, searchFile);

        closebrowser();
    }
}
