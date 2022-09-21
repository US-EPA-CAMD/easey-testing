package tests.UITests.EASEYIn_Emissioners.EmMonPlanReusables;

import org.openqa.selenium.JavascriptExecutor;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class emMonPlanReusables extends UITestBase {

    protected void logOutMethod() {

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", monitoringPlansPage.menuBtn);

        if (isDisplayed(monitoringPlansPage.logOutButton)) {
            click(monitoringPlansPage.logOutButton);
            waitFor(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        } else {
            isDisplayed(monitoringPlansPage.logInButtonOpenModal);
            verifyEquals(monitoringPlansPage.logInButtonOpenModal, "Log In");
        }
    }
}
