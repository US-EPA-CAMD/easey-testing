package tests.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class UITestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {

        // set path of Chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/home/yefim/drivers/chromedriver");

        // initialize new WebDriver session
        driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(4920,0)); // specific to my situation
        driver.manage().window().maximize();

        sleep(1000);
    }

    @AfterMethod
    public void afterMethod() {

        // close and quit the browser
        driver.quit();
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected boolean isDisplayed(WebElement ele) {
        try {
            return ele.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element Not Found!");
            System.err.println(e.getMessage());
            return false;
        }
    }

    protected boolean waitFor(ExpectedCondition<Boolean> isTrue, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(isTrue);
            return true;
        } catch (RuntimeException e) {
            System.err.println("condition hasn't been met");
            return false;
        }
    }

    protected boolean waitFor(ExpectedCondition<Boolean> isTrue) {
        return waitFor(isTrue, 30);
    }

    protected boolean waitFor(WebElement element) {
        ExpectedCondition<Boolean> displayed = driver -> element.isDisplayed();
        return waitFor(displayed);
    }

    protected boolean waitFor(WebElement element, int seconds) {
        ExpectedCondition<Boolean> displayed = driver -> element.isDisplayed();
        return waitFor(displayed, seconds);
    }

    protected void input(WebElement ele, String input){
        try {
            ele.sendKeys(input);
        } catch(NoSuchElementException e) {
            Assert.assertTrue(false, "Element not Found!");
        }
    }

    protected void enter(WebElement ele){
        try {
            ele.sendKeys(Keys.ENTER);
        } catch(NoSuchElementException e) {
            Assert.assertTrue(false, "Element not Found!");
        }
    }

    protected void search(WebElement ele, String input) {
        input(ele, input);
        enter(ele);
    }

    protected void click(WebElement ele) {
        try {
            ele.click();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false, "Element not Found!");
        }
    }

    protected void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (java.lang.InterruptedException e) {
            System.out.println("Did not finish sleep!");
        }
    }

}
