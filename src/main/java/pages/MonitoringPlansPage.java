package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(css = "ul.usa-button-group.usa-button-group--segmented > li")
    public List<WebElement> tabs;

    @FindBy(css = "div.selectedMPTab > div > div > h2 ")
    public WebElement facilityTitle;

    @FindBy(id = "showInactive")
    public WebElement showInactiveCheckbox;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "optgroup[label='Inactive']")
    public WebElement inactiveConfigurations;

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

    @FindBy (id = "Sections")
    public WebElement sectionsDropdown;

    @FindBy (css = "#Sections > option:nth-child(5)")
    public WebElement monitoringSystems;

    @FindBy (css = "button.usa-accordion__button > div.methodHeader")
    public WebElement accordionButton;

    @FindBy(css = "table.usa-table.usa-table--borderless > tbody > tr > td > button")
    public List<WebElement> systemTableButtonList;

    @FindBy(css = "#close > i")
    public WebElement xOutModal;

    @FindBy(css = "button.cancelBTN.modal-color")
    public WebElement cancelModal;

    @FindBy(css = "button.saveCloseBTN")
    public WebElement saveCloseModal;

    @FindBy (css = "table.usa-table.usa-table--borderless > thead > tr > th")
    public WebElement systemIDTitle;

    @FindBy(css = "div.modalDetails > h2")
    public WebElement modalTitle;

    @FindBy (css = "div.usa-form-group.dateLabels")
    public WebElement modalSystemID;

    @FindBy (css = "div:nth-child(1) > div.modalColumnRight > div > div > div > label")
    public WebElement modalSystemDesignation;

    @FindBy (css = "div.modalColumn > div > div > div > label")
    public WebElement modalSystemType;

    @FindBy (css = "div:nth-child(2) > div.modalColumnRight > div > div > div > label")
    public WebElement modalFuelType;

    @FindBy (id = "dateStart")
    public WebElement modalStartTimeDate;

    @FindBy (id = "dateEnd")
    public WebElement modalEndTimeDate;

}
