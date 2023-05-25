package tests.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sun.jvm.hotspot.debugger.Page;
import utils.PageBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UITestBase extends TestBase {

    protected EventFiringWebDriver driver;
    WebDriver eventless_driver;
    protected String driverHome;
    private static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    private static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_PASSWORD");
    private static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private ExceptionListener listener;
    private String runMode = System.getProperty("runMode", "local");
    private boolean debug = System.getProperty("debug", "false").equalsIgnoreCase("true");

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();

        driverHome = System.getProperty("user.home");
//        System.setProperty("webdriver.chrome.silentOutput", "true");
//        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.WARNING);
//        System.out.println(driverHome);

        // set path of Chromedriver executable
        if (osHome.startsWith("/home/"))
            System.setProperty("webdriver.chrome.driver", driverHome + "/drivers/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", driverHome + "/drivers/chromedriver.exe");

        if (!runMode.equals("local")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1920x1080");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest-beta");
            caps.setCapability("os", "Windows");
            caps.setCapability("name", className); // test name
            if (!driverHome.contains("runner"))
                caps.setCapability("build", "Local Trigger: " + AUTOMATE_USERNAME + " @ " + java.time.LocalDate.now()); // CI/CD job or build name
            else
                caps.setCapability("build", "Github trigger @" + java.time.LocalDate.now());
            try {
                eventless_driver = new RemoteWebDriver(new URL(URL), caps);
                eventless_driver.manage().window().maximize();
            } catch (MalformedURLException e) {
                System.err.println("Bad URL");
            }
        } else {
            eventless_driver = new ChromeDriver();
            if (osHome.contains("yefim"))
                eventless_driver.manage().window().setPosition(new Point(4920, 0)); // specific to my situation
            eventless_driver.manage().window().maximize();

            sleep(1000);
        }
        driver = new EventFiringWebDriver(eventless_driver);
        
        listener = new ExceptionListener(className);
        driver.register(listener);
    }

    @AfterMethod
    public void afterMethod() {
        // close and quit the browser
        driver.quit();
        if (debug)
            listener.printError();
        super.afterMethod();
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected void goToo(String app, String url) {
        if (!url.startsWith("https:")) {
            url = String.format("https://%s-%s.app.cloud.gov%s", app, env, url);
        }
        else {
            System.out.print(className + " needs to have goto method updated");
        }
        driver.get(url);
    }

    protected void logOn(String username, String password, PageBase page){
        verifyEquals(page.logInButtonOpenModal, "Log In");
        click(page.logInButtonOpenModal);

        verifyEquals(page.usernameLabelModal.getText(), "Username");
        input(page.usernameFieldModal, username);

        verifyEquals(page.passwordLabelModal.getText(), "Password");
        input(page.passwordFieldModal, password);

        verifyEquals(page.logInButtonSubmit, "Log In");
        click(page.logInButtonSubmit);

        waitFor(page.dashWorkspace);
        verifyEquals(page.dashWorkspace, "Workspace");

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

    protected boolean contains(WebElement ele, String str) {
        try {
            return ele.getText().contains(str);
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

    protected boolean waitFor(List list) {
        return waitFor(list, 0, 30);
    }

    protected boolean waitFor(List list, int size) {
        return waitFor(list, size, 30);
    }

    protected boolean waitFor(List list, int size, int seconds) {
        ExpectedCondition<Boolean> condition = driver -> list.size() > size;
        return waitFor(condition, seconds);
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

    protected void changeTab() {
        waitFor(driver -> driver.getWindowHandles().size() > 1);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    protected void closeTab() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    protected void sleep(int time) {
        if (debug)
            try {
                Thread.sleep(time);
            } catch (java.lang.InterruptedException e) {
                System.out.println("Did not finish sleep!");
            }
    }

    protected void pause() { sleep (1000000); }
}

class ExceptionListener extends AbstractWebDriverEventListener {

    String className;
    private StackTraceElement[] stack;
    private Throwable excpetion;

    ExceptionListener(String className) {
        super();
        this.className = className;
    }

    public void onException(Throwable throwable, WebDriver driver) {
        stack = Thread.currentThread().getStackTrace();
        excpetion = throwable;
    }

    protected void printError() {
        if (stack != null) {
            String line = Arrays.asList(stack).toString();
            line = line.substring(line.indexOf(className));
            line = line.substring(line.indexOf(":") + 1, line.indexOf(")"));
            printError("Last found Exception:");
            printError("Test: " + className);
            printError("Line:" + line);
            System.err.println(excpetion.getMessage());
            printError("\tUnhandled Exception");
        }
    }
    private static void printError(String error) {
        System.err.println("[\u001B[31mERROR\u001B[0m] " + error);
    }


    protected void setChromeDownloadPath() {
        String fileDownloadPath = "C:\\EPA\\easey-testing\\src\\downloads";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory",fileDownloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

}
