package tests.UITests.ECMPS.reviewSubmit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import pages.ReviewAndSubmitPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;

public class Test_ECMPS_Review_Submit_Home extends UITestBase {
    @Test
    public void test() {
        //Navigate to ECMPS
        goTo("https://ecmps-dev.app.cloud.gov/");

        Actions action = new Actions(driver);
        ReviewAndSubmitPage reviewSubmit = new ReviewAndSubmitPage(driver);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("scroll(0, 500);");
//login
        waitFor(reviewSubmit.username);
        input(reviewSubmit.username, "jsmith-dp");
        waitFor(reviewSubmit.password);
        input(reviewSubmit.password, "CVPt3ster@05");

        waitFor(reviewSubmit.login);
        click(reviewSubmit.login);
//Navigate to Review & Submit
        waitFor(reviewSubmit.ReviewSubmitMenuItem);
        click(reviewSubmit.ReviewSubmitMenuItem);

// Make sure radio buttons function correctly

//        waitFor(reviewSubmit.criticalErrorsRadio.get(1));
//        click(reviewSubmit.criticalErrorsRadio.get(1));
//
//        waitFor(reviewSubmit.criticalErrorsRadio.get(0));
//        click(reviewSubmit.criticalErrorsRadio.get(0));

// Select Facilty
        waitFor(reviewSubmit.facilitiesSearchbox);
        click(reviewSubmit.facilitiesSearchbox);

        waitFor(reviewSubmit.facilitiesListItem.get(0));
        click(reviewSubmit.facilitiesListItem.get(0));
        click(reviewSubmit.facilitiesListItem.get(1));

// Apply Filters

        waitFor(reviewSubmit.filterSubmitButton.get(0));

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        click(reviewSubmit.filterSubmitButton.get(0));

// Scroll and Select the Available plans
        jse.executeScript("scroll(0, 1000);");

        waitFor(reviewSubmit.chevronArrows.get(0));
        click(reviewSubmit.chevronArrows.get(0));

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        jse.executeScript("arguments[0].click();", reviewSubmit.configSelect.get(1));


// Scroll and Select Submit

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        click(reviewSubmit.filterSubmitButton.get(1));


// Interact with modal
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(reviewSubmit.modal);

        waitFor(reviewSubmit.username);
        input(reviewSubmit.username, "jsmith-dp");
        waitFor(reviewSubmit.password);
        input(reviewSubmit.password, "CVPt3ster@05");

        waitFor(reviewSubmit.verify);
        click(reviewSubmit.verify);
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        reviewSubmit.password.sendKeys(Keys.END);


        waitFor(reviewSubmit.answer);
        input(reviewSubmit.answer, "test");

        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }

        waitFor(reviewSubmit.verify);
        click(reviewSubmit.verify);



    }
}
