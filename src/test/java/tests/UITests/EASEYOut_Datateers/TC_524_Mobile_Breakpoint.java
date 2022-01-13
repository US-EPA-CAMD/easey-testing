package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit ;


    public class TC_524_Mobile_Breakpoint extends UITestBase {
        @Test
        public void test() {

            // Navigate to EASEY Out

            goTo("https://campd-dev.app.cloud.gov/");
            Actions action = new Actions(driver);
            Dimension dimension = new Dimension(480, 1080);
            CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);
            driver.manage().window().setSize(dimension);
            waitFor(customDataDownloadPage.mobilemenu);
            click(customDataDownloadPage.mobilemenu);

            waitFor(customDataDownloadPage.mobilemenulinks.get(0));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(0).getText().contains("HOME"));

            System.out.println(customDataDownloadPage.mobilemenulinks.get(0).getText());

            waitFor(customDataDownloadPage.mobilemenulinks.get(1));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(1).getText().contains("DATA"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(2));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(2).getText().contains("VISUALIZATION & ANALYSIS"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(3));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(3).getText().contains("Resources"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(4));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(4).getText().contains("Help/Support"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(5));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(5).getText().contains("Regulatory Partners"));

            click(customDataDownloadPage.mobilemenu);

            Dimension dimension2 = new Dimension(640, 1080);
            driver.manage().window().setSize(dimension2);
            waitFor(customDataDownloadPage.mobilemenu);
            click(customDataDownloadPage.mobilemenu);

            waitFor(customDataDownloadPage.mobilemenulinks.get(0));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(0).getText().contains("HOME"));

            System.out.println(customDataDownloadPage.mobilemenulinks.get(0).getText());

            waitFor(customDataDownloadPage.mobilemenulinks.get(1));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(1).getText().contains("DATA"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(2));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(2).getText().contains("VISUALIZATION & ANALYSIS"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(3));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(3).getText().contains("Resources"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(4));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(4).getText().contains("Help/Support"));

            waitFor(customDataDownloadPage.mobilemenulinks.get(5));
            verifyTrue(customDataDownloadPage.mobilemenulinks.get(5).getText().contains("Regulatory Partners"));
        }
    }



