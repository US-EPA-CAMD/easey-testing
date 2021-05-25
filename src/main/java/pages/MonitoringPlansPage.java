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

    @FindBy(css = "div[class='sc-dIvrsQ gkZcBD rdt_TableBody'] > div")
    public List<WebElement> tableResults;

    @FindBy(css = "div[class='sc-dIvrsQ gkZcBD rdt_TableBody'] > div > div:nth-child(4)")
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

    @FindBy(css = "div.selectedMPTab.padding-top-4 > div > div > h2")
    public WebElement facilityTitle;

    @FindBy(css = "label[for='1']")
    public WebElement showInactiveCheckbox;

    @FindBy(css = "optgroup > option")
    public List<WebElement> configurationsField;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "#\\33")
    public WebElement inactiveConfigurations;

    @FindBy(css = "#\\30")
    public WebElement locationsDropdown;

    @FindBy(css = "select[name='optionList']")
    public WebElement locationsField;

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

    @FindBy (id = "3")
    public WebElement sectionsDropdown;

    @FindBy (css = "#\\33 > option:nth-child(4)")
    public WebElement monitoringMethods;

    @FindBy (css = "#\\33 > option:nth-child(5)")
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

    @FindBy (css = "label[for='System DesignationP']")
    public WebElement modalSystemDesignation;

    @FindBy (css = "label[for='System TypeGAS']")
    public WebElement modalSystemType;

    @FindBy (css = "label[for='Fuel TypePNG']")
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
