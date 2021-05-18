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
//    @FindBy(css = "table.usa-table.usa-table--borderless > tbody > tr > td:nth-child(4) > button")
//    public List<WebElement> openTab;
    @FindBy(css = "table.usa-table.usa-table--borderless > tbody > tr > td:nth-child(4) > button")
    public List<WebElement> openFacilityTab;

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

    @FindBy(css = "h1.display-inline-block")
    public WebElement title;

    @FindBy(css = "ul.usa-button-group.usa-button-group--segmented > li")
    public List<WebElement> tabs;

    @FindBy(css = "div.selectedMPTab > div > div > h2")
    public WebElement facilityTitle;

    @FindBy(css = "div.selectedMPTab.padding-top-4 div.header:nth-child(1) > div.display-inline-block")
    public WebElement facilityName;

    @FindBy(id = "showInactive")
    public WebElement showInactiveCheckbox;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "optgroup[label='Inactive']")
    public WebElement inactiveConfigurations;

    @FindBy(css = "button.display-block.usa-button.radius-md.bg-white.text-primary")
    public WebElement menuBtn;

    @FindBy(css = "nav.usa-nav.is-visible")
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

    @FindBy(css = "form.usa-search.usa-search--small.search-field > button.usa-button")
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

    @FindBy (id = "Sections3")
    public WebElement sectionsDropdown;

    @FindBy (css = "#Sections3 > option:nth-child(4)")
    public WebElement monitoringMethods;

    @FindBy (css = "#Sections3 > option:nth-child(5)")
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

    @FindBy (css = "div.grid-col.padding-bottom-2.padding-right-3 > div > label")
    public WebElement modalSystemID;

//    @FindBy (css = "div.grid-row:nth-child(1) div.grid-col:nth-child(2) div:nth-child(1) div:nth-child(1) div.usa-form-group.margin-top-0 > label.usa-label")
//    public WebElement modalSystemDesignation;
    @FindBy (xpath = "//label[contains(text(),'System Designation')]")
    public WebElement modalSystemDesignation;

    @FindBy (css = "div.grid-col.padding-bottom-2.padding-right-3 > div > div > div > label")
    public WebElement modalSystemType;

//    @FindBy (css = "div.modal-body.modal-color > div > div > div > form > div:nth-child(2) > div:nth-child(2) > div > div > div > label")
//    public WebElement modalFuelType;
    @FindBy (xpath = "//label[contains(text(),'Fuel Type')]")
    public WebElement modalFuelType;

    @FindBy (id = "dateStart")
    public WebElement modalStartTimeDate;

    @FindBy (id = "dateEnd")
    public WebElement modalEndTimeDate;

    @FindBy (css = "h5.padding-0.padding-left-5px")
    public WebElement dashboardTitle;

    @FindBy (css = "div.text-underline")
    public WebElement dashWorkspace;

    @FindBy (css = "#MenuDropDown > li:nth-child(1) > a")
    public WebElement dashMonPlan;

    @FindBy (css = "#MenuDropDown > li:nth-child(2) > a")
    public WebElement dashQaCert;

    @FindBy (css = "#MenuDropDown > li:nth-child(3) > a")
    public WebElement dashEmissions;

    @FindBy (css = "div.accessoryLink:nth-child(1) > a.text-white:nth-child(2)")
    public WebElement dashCamdApps;

    @FindBy (css = "div.accessoryLink:nth-child(2) > a.text-white:nth-child(2)")
    public WebElement dashProfile;

    @FindBy (css = "div.text-white:nth-child(3) > a.text-white:nth-child(2)")
    public WebElement dashAccountMan;

    @FindBy (css = "div.accessoryLink:nth-child(4) > a.text-white:nth-child(2)")
    public WebElement dashHelpContact;

    @FindBy (css = "div.text-center > h1")
    public WebElement pageDoesntExist;

}
