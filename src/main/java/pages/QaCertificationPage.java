package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaCertificationPage extends MonitoringPlansPage {

    public QaCertificationPage(WebDriver driver) { super(driver); }

    @FindBy(css = "h2[epa-testid='QACertificationsTestDataTitle']")
    public WebElement title;

    @FindBy (css = "#txtSearchData")
    public WebElement filterByKeywordBoxQa;

    @FindBy (xpath = "//tbody/tr[1]/td[3]/button[1]")
    public WebElement filterByKeywordBTNQa;
}
