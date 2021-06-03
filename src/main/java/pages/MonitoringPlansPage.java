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

    @FindBy(css = "optgroup[label='Inactive']")
    public WebElement inactiveLabel;

    @FindBy(css = "optgroup > option")
    public List<WebElement> configurationsField;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "#\\33")
    public WebElement inactiveConfigurations;

    @FindBy(css = "select[name='optionList'] > option")
    public List<WebElement> locationsField;

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

    @FindBy(css = "div[class='cursor-pointer']")
    public List<WebElement> systemTableButtonList;

    @FindBy(css = "#close > i")
    public WebElement xOutModal;

    @FindBy(css = "button.cancelBTN.modal-color")
    public WebElement cancelModal;

    @FindBy(css = "button.saveCloseBTN")
    public WebElement saveCloseModal;

    @FindBy (id = "column-col1")
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

    @FindBy (css = "a[title='Go to Home page']")
    public WebElement dashHomeTitle;

    @FindBy (css = "a[title='Go to the workspace page']")
    public WebElement dashWorkspace;

    @FindBy (css = "a[title='Go to Monitoring Plans page']")
    public List<WebElement> dashMonPlan;

    @FindBy (css = "a[title='Go to QA & Certifications page']")
    public List<WebElement> dashQaCert;

    @FindBy (css = "a[title='Go to Emissions page']")
    public List<WebElement> dashEmissions;

    @FindBy (css = "a[title='Go to the  CAMD Apps page']")
    public WebElement dashCamdApps;

    @FindBy (css = "a[title='Go to the Profile page']")
    public WebElement dashProfile;

    @FindBy (css = "a[title='Go to the Account Management page']")
    public WebElement dashAccountMan;

    @FindBy (css = "a[title='Go to the help page']")
    public WebElement dashHelpContact;

    @FindBy (css = "div.text-center > h1")
    public WebElement pageDoesntExist;

    @FindBy(xpath = "//legend[contains(text(),'Log In')]")
    public WebElement logInLabel;

    @FindBy(css = "div.padding-bottom-4.position-absolute.bottom-0 > button")
    public WebElement logInButton;

    @FindBy(css = "div.modal-wrapper.modal-color > div > div > div > div > form > fieldset > button")
    public WebElement logInButtonModal;

    @FindBy (css ="label[for='username']")
    public WebElement usernameLabel;

    @FindBy (id ="username")
    public WebElement usernameField;

    @FindBy (css ="label[for='password']")
    public WebElement passwordLabel;

    @FindBy (id ="password")
    public WebElement passwordField;

    @FindBy (css = "div.padding-bottom-4.position-absolute.bottom-0 > div > div:nth-child(1) > div:nth-child(1)")
    public WebElement welcomeMessage;

    @FindBy(css = "div.accessoryLink > button")
    public WebElement logOutButton;

    @FindBy (css = "div.systemsCompTable > div.container > div.tableHead > h3.float-left")
    public WebElement systemComponentsHeader;

    @FindBy (css = "table.usa-table.usa-table--borderless:nth-child(2) > thead > tr > th:nth-child(1)")
    public WebElement componentIdHeader;

    @FindBy (css = "table.usa-table.usa-table--borderless:nth-child(2) > thead > tr > th:nth-child(2)")
    public WebElement componentTypeCodeHeader;

    @FindBy (css = "table.usa-table.usa-table--borderless:nth-child(2) > thead > tr > th:nth-child(3)")
    public WebElement componentBeginToEndDateHeader;

    @FindBy (css = "table.usa-table.usa-table--borderless:nth-child(2) > thead > tr > th:nth-child(4)")
    public WebElement componentActionsHeader;

    @FindBy (css = "button[aria-label*='View']")
    public List<WebElement> componentsViewButton;

    @FindBy (css = "button[class='usa-button addCompBTN align-right']")
    public WebElement addComponentButton;

    @FindBy (css = "label[for='ComponentID']")
    public WebElement componentIdModal;

    @FindBy (css = "label[for='SampleAcquisitionMethod']")
    public WebElement componentSampleAcquisitionMethodModal;

    @FindBy (css = "label[for='ComponentType']")
    public WebElement ComponentTypeModal;

    @FindBy (css = "label[for='BasisDescription']")
    public WebElement componentBasisDescriptionModal;

    @FindBy (css = "label[for='Manufacturer']")
    public WebElement componentManufacturerModal;

    @FindBy (css = "label[for='ModelOrVersion']")
    public WebElement componentModelOrVersionModal;

    @FindBy (css = "label[for='SerialNumber']")
    public WebElement componentSerialNumberModal;

    @FindBy (css = "fieldset[class='usa-fieldset  display-inline-flex'] > legend.usa-legend")
    public WebElement componentHgConverterIndicatorModal;

    @FindBy (id = "StartDateAndTime")
    public WebElement componentStartDateAndTimeModal;

    @FindBy (id = "EndDateAndTime")
    public WebElement componentEndDateAndTimeModal;

    @FindBy (css = "label[for='startTime']")
    public WebElement componentStartDateModal;

    @FindBy (css = "label[for='startHour']")
    public WebElement componentStartHourModal;

    @FindBy (css = "label[for='endDate']")
    public WebElement componentEndDateModal;

    @FindBy (css = "label[for='endHour']")
    public WebElement componentEndHourModal;

    @FindBy (css = "button[aria-label='go back to systems details']")
    public WebElement componentBackButton;

    @FindBy (css = "")
    public WebElement systemFuelFlowsHeader;

    @FindBy (css = "")
    public WebElement addFuelFlowButton;

    @FindBy (css = "")
    public WebElement fuelFlowCodeModal;

    @FindBy (css = "")
    public WebElement fuelFlowTypeModal;

    @FindBy (css = "")
    public WebElement fuelFlowBeginToEndDateHeader;

    @FindBy (css = "")
    public List<WebElement> FuelFlowViewButton;



}
