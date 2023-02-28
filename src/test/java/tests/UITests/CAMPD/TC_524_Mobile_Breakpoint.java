package tests.UITests.CAMPD;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.Dimension;


public class TC_524_Mobile_Breakpoint extends UITestBase {
        @Test
        public void test() {

            // Navigate to EASEY Out

            goTo("https://campd-dev.app.cloud.gov/");
            Actions action = new Actions(driver);
            Dimension dimension = new Dimension(480, 1080);
            CampdElements campdElements = new CampdElements(driver);
            driver.manage().window().setSize(dimension);
            waitFor(campdElements.mobilemenu);
            click(campdElements.mobilemenu);

            waitFor(campdElements.mobilemenulinks.get(0));
            verifyTrue(campdElements.mobilemenulinks.get(0).getText().contains("HOME"));

            System.out.println(campdElements.mobilemenulinks.get(0).getText());

            waitFor(campdElements.mobilemenulinks.get(1));
            verifyTrue(campdElements.mobilemenulinks.get(1).getText().contains("DATA"));

            waitFor(campdElements.mobilemenulinks.get(2));
            verifyTrue(campdElements.mobilemenulinks.get(2).getText().contains("VISUALIZATION & ANALYSIS"));

            waitFor(campdElements.mobilemenulinks.get(3));
            verifyTrue(campdElements.mobilemenulinks.get(3).getText().contains("Resources"));

            waitFor(campdElements.mobilemenulinks.get(4));
            verifyTrue(campdElements.mobilemenulinks.get(4).getText().contains("Help/Support"));

            waitFor(campdElements.mobilemenulinks.get(5));
            verifyTrue(campdElements.mobilemenulinks.get(5).getText().contains("Regulatory Partners"));

            click(campdElements.mobilemenu);

            Dimension dimension2 = new Dimension(640, 1080);
            driver.manage().window().setSize(dimension2);
            waitFor(campdElements.mobilemenu);
            click(campdElements.mobilemenu);

            waitFor(campdElements.mobilemenulinks.get(0));
            verifyTrue(campdElements.mobilemenulinks.get(0).getText().contains("HOME"));

            System.out.println(campdElements.mobilemenulinks.get(0).getText());

            waitFor(campdElements.mobilemenulinks.get(1));
            verifyTrue(campdElements.mobilemenulinks.get(1).getText().contains("DATA"));

            waitFor(campdElements.mobilemenulinks.get(2));
            verifyTrue(campdElements.mobilemenulinks.get(2).getText().contains("VISUALIZATION & ANALYSIS"));

            waitFor(campdElements.mobilemenulinks.get(3));
            verifyTrue(campdElements.mobilemenulinks.get(3).getText().contains("Resources"));

            waitFor(campdElements.mobilemenulinks.get(4));
            verifyTrue(campdElements.mobilemenulinks.get(4).getText().contains("Help/Support"));

            waitFor(campdElements.mobilemenulinks.get(5));
            verifyTrue(campdElements.mobilemenulinks.get(5).getText().contains("Regulatory Partners"));
        }
    }



