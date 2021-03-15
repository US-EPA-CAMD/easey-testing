package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class MonitoringPlansPage extends PageBase {

    public MonitoringPlansPage(WebDriver driver) { super(driver); }

    @FindBy(css = "table.usa-table.usa-table--borderless")
    public WebElement table;

    @FindBy(css = "table.usa-table.usa-table--borderless > tbody > tr")
    public List<WebElement> tableResults;

    @FindBy(id = "input-dropdown")
    public WebElement paginationDropdown;

    @FindBy(id = "input-button")
    public WebElement updatePaginationButton;

    @FindBy(css = "div.totalDisplay.col")
    public WebElement total;

    @FindBy(css = "#pagination > li.page-item-next > button")
    public WebElement nextPageButton;

    @FindBy(css = "li.paginate_button.active")
    public WebElement currentPage;

    @FindBy(css = "h1.title")
    public WebElement title;

    @FindBy(css = "button.usa-button.menuBTN")
    public WebElement menuBtn;

    @FindBy(css = "div.mainMenu > nav")
    public WebElement menuNav;

    @FindBy(css = "button[aria-controls='Environmental TopicsMenuDropDown']")
    public WebElement environmentalTopicsMenuDropDown;

    @FindBy(css = "a[title='Environmental Topics']")
    public List<WebElement> environmentalTopics;

    @FindBy(css = "button[aria-controls='Laws and RegulationsMenuDropDown']")
    public WebElement lawsAndRegulationsMenuDropDown;

    @FindBy(css = "a[title='Laws and Regulations']")
    public List<WebElement> lawsAndRegulations;

    @FindBy(css = "button[aria-controls='About EPAMenuDropDown']")
    public WebElement aboutEPAMenuDropDown;

    @FindBy(css = "a[title='About EPA']")
    public List<WebElement> aboutEPA;

    @FindBy(id = "search-field")
    public WebElement search;

    @FindBy(id = "input-button-search")
    public WebElement searchButton;

    @FindBy(id = "collapsable")
    public WebElement footerMenuBTN;

    @FindBy(id = "menuContent")
    public WebElement footerMenuContent;

    @FindBy(id = "AccessiblityLink")
    public WebElement footerAccessibility;

    @FindBy(id = "PrivacyLink")
    public WebElement footerPrivacy;

    @FindBy(id = "PrivacyandSecurityNoticeLink")
    public WebElement footerNotice;

    @FindBy(id = "close")
    public WebElement footerClose;
}
