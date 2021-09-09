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

    @FindBy(css = "li.paginate_button.active")
    public WebElement currentPage;

    @FindBy(id = "pagination-next-page")
    public WebElement nextPageButton;

    @FindBy(id = "pagination-previous-page")
    public WebElement previousPageButton;

    @FindBy(id = "pagination-last-page")
    public WebElement lastPageButton;

    @FindBy(id = "pagination-first-page")
    public WebElement firstPageButton;

    @FindBy(css = "div[role='row']")
    public List<WebElement> rowsPerPage;

    @FindBy(css = "select[aria-label='Rows per page:']")
    public WebElement rowsPerPageButton;

    @FindBy(css = "select[aria-label='Rows per page:'] > option")
    public List<WebElement> rowsPerPageOptions;

    @FindBy(css = "span[class='sc-ezzafa sc-bYwzuL feVODd boStqG']")
    public WebElement facilitiesOutOf;

    @FindBy(css = "h2[epa-testid='monPlansTitle']")
    public WebElement title;

    @FindBy(css = "div.tabContent > div > div > div > div > header > div > div")
    public WebElement selectConfigurationLabel;

    @FindBy(css = "button[aria-label='open Select Configurations tab']")
    public WebElement selectConfigurationsButton;

    @FindBy(css = "ul.usa-button-group.usa-button-group--segmented > li")
    public List<WebElement> tabs;

    @FindBy(css = "div.selectedMPTab.padding-top-4 > div > div > h2")
    public WebElement facilityTitle;

    @FindBy(css = "div[data-testid='checkbox']")
    public WebElement showInactiveCheckbox;

    @FindBy(css = "label[for='checkbox']")
    public WebElement showInactiveLabel;

    @FindBy(css = "optgroup > option")
    public List<WebElement> configurationsField;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "#\\33")
    public WebElement inactiveConfigurations;

    @FindBy(id = "Locations")
    public WebElement locationsField;

    @FindBy(css = "select[data-testid='Locations'] > option")
    public List<WebElement> location;

    @FindBy(css = "img[alt='Official EPA Logo']")
    public WebElement epaHeaderLogoAndHyperlink;

    @FindBy(css = "button[data-testid='navMenuButton']")
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
    public WebElement searchBox;

    @FindBy(css = "button[type='submit']")
    public WebElement searchButton;

    @FindBy(css = "em[class='usa-logo__text epa-active-element'] > h1")
    public WebElement ecmpsHeaderImage;

    @FindBy(css = "em[class='usa-logo__text epa-active-element'] > span")
    public WebElement ecmpsHeaderLabel;

    @FindBy(css = "button[aria-controls='menu-[object Object]'] > span")
    public List<WebElement> ecmpsHeaderResourcesLabel;

    @FindBy(css = "button[aria-controls='menu-[object Object]'] > span")
    public List<WebElement> ecmpsHeaderHelpAndSupportLabel;

    @FindBy(css = "button[aria-controls='menu-[object Object]'] > span")
    public List<WebElement> ecmpsHeaderRegulatoryPartnersLabel;

    @FindBy(css = "a[title='[object Object]'] > span")
    public WebElement ecmpsHeaderSiteMapLabel;

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

    @FindBy (css = "option[data-testid='Methods']")
    public WebElement monitoringMethods;

    @FindBy (css = "option[data-testid='Systems']")
    public WebElement monitoringSystems;

    @FindBy (css = "div.modal-header.modal-color > div > h3")
    public WebElement monPlanModalHeaderLabel;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h4")
    public WebElement monPlanModalSysSecondTableHeaderLabel;

    @FindBy (css = "div.methodTable > div > div > div > h4")
    public WebElement monPlanAnalyzerRangesHeaderLabel;

    @FindBy (id = "collapseBTN")
    public WebElement accordionButtonMonPlan;

    @FindBy (css = "span[epa-testid='Methods']")
    public WebElement accordionMethodsLabel;

    @FindBy (css = "span[epa-testid='Systems']")
    public WebElement accordionSystemsLabel;

    @FindBy (css = "span[epa-testid='SupplementalMethods']")
    public WebElement accordionSupplementalMethodsLabel;

    @FindBy (css = "div:nth-child(3) > div > div:nth-child(2) > div.text-bold.font-body-xl.display-block.height-auto")
    public WebElement accordionButtonMATS;

    @FindBy(css = "div[class='cursor-pointer']")
    public List<WebElement> systemTableButtonList;

    @FindBy(id = "closeModalBtn")
    public WebElement xOutModal;

    @FindBy(css = "button.cancelBTN.modal-color")
    public WebElement cancelModal;

    @FindBy(css = "button.saveCloseBTN")
    public WebElement saveCloseModal;

    @FindBy(css = "button[epa-testid='closeBtn']")
    public WebElement closeModal;

    @FindBy (id = "column-col1")
    public WebElement systemIDTitle;

    @FindBy(css = "div.modalDetails > h2")
    public WebElement modalTitle;

    @FindBy (css = "div.grid-col.padding-bottom-2.padding-right-3 > div > label")
    public WebElement modalSystemID;

    @FindBy (css = "label[for='sysdes']")
    public WebElement modalSystemDesignation;

    @FindBy (css = "label[for='systype']")
    public WebElement modalSystemType;

    @FindBy (css = "label[for='fueltype']")
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

    // This is for the label Log In on the Log In modal pop up
    @FindBy(xpath = "//legend[contains(text(),'Log In')]")
    public WebElement logInLabel;

    @FindBy(css = "button[epa-testid='openModalBTN']")
    public WebElement logInButton;

    @FindBy(css = "button[data-test='component-login-submit-button']")
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

    @FindBy(css = "button[epa-testid='logoutBtn']")
    public WebElement logOutButton;

    @FindBy(css = "div.bg-base-lighter > div > div > form > fieldset > legend")
    public WebElement logInLabelHomePage;

    @FindBy (css = "div.methodTable.react-transition.fade-in > div > div:nth-child(1) > div > div > h4")
    public WebElement systemComponentsHeader;

    @FindBy (css = "#column-col1")
    public List<WebElement> componentIdHeader;

    @FindBy (css = "#column-col2")
    public List<WebElement> componentTypeCodeHeader;

    @FindBy (css = "#column-col3")
    public List<WebElement> componentBeginToEndDateHeader;

    @FindBy (css = "#column-undefined > div")
    public List<WebElement> componentActionsHeader;

    @FindBy (id = "btnOpen")
    public List<WebElement> viewButton;

    @FindBy (id = "btnOpenSystemComponents")
    public List<WebElement> viewButtonSystemComponents;

    @FindBy (id = "btnOpenFuelFlows")
    public List<WebElement> viewButtonFuelFlow;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h4")
    public WebElement systemComponentModal;

    @FindBy (css = "div.sc-jrsJWt.khlPsW.rdt_TableRow > div:nth-child(4)")
    public List<WebElement> componentsViewButton;

    @FindBy (id = "btnOpenAnalyzerRanges")
    public List<WebElement> analyzerRangesViewButton;

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

    @FindBy (css = "div.methodTable.react-transition.fade-in > div > div:nth-child(2) > div > div > h4")
    public WebElement systemFuelFlowsHeader;

    @FindBy (css = "div.padding-top-4.padding-left-2 > h2 > button")
    public WebElement addFuelFlowButton;

    // fuelFlowCodeModal, fuelFlowTypeModal and fuelFlowBeginToEndDateHeader are
    // all the same locator differentiated by a different index number with .get()
    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowCodeModal;

    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowTypeModal;

    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowBeginToEndDateHeader;

    @FindBy (css = "#column-undefined")
    public List<WebElement> fuelFlowActionsHeader;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div:nth-child(4)")
    public List<WebElement> FuelFlowViewButton;

    @FindBy (css ="button[epa-testid='searchDataTableBTN']")
    public WebElement filterByKeywordButton;

    @FindBy (css ="input[id='txtSearchData']")
    public WebElement filterByKeywordBox;

    @FindBy (css = "#column-col1 > div")
    public List<WebElement> monPlanOrisHeader;

    @FindBy (css = "#column-col2 > div")
    public List<WebElement> monPlanFacilityHeader;

    @FindBy (css = "#column-col3 > div")
    public List<WebElement> monPlanStateHeader;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div > button")
    public List<WebElement> openFacilityConfigurations;

    @FindBy (css = "#column-col1 > div")
    public List<WebElement> monPlanConfigHeader;

    @FindBy (css = "#column-col2 > div")
    public List<WebElement> monPlanStatusHeader;

    @FindBy (css = "#column-undefined")
    public WebElement monPlanActionsHeader;

    @FindBy (css = "#btnOpenConfiguration")
    public List<WebElement> monPlanOpenButton;

    @FindBy (css ="button[data-testid='expander-button-3']")
    public WebElement facilityCaretBarry;

    @FindBy (css ="button[aria-label='Expand Row']")
    public WebElement facilityCaretFirst;

    @FindBy (css = "button[epa-testid='btnOpen']")
    public List<WebElement> configOpenButton;

    @FindBy (id ="tabBtn")
    public List<WebElement> configTabs;

    @FindBy (css ="li[title='Barry (1, 2, CS0AAN) ']")
    public WebElement configTabBarry12CS0AAN;

    @FindBy (css ="div:nth-child(1) > span")
    public WebElement homePgAboutEcmpsHeader;

    @FindBy (css ="div:nth-child(2) > h2")
    public WebElement homePgMonPlansHeader;

    @FindBy (css ="div:nth-child(2) > a#MonitoringPlans")
    public WebElement homePgViewMonPlansLink;

    @FindBy (css ="div:nth-child(3) > h2")
    public WebElement homePgQaCertHeader;

    @FindBy (css ="div:nth-child(3) > a#QA\\&Certifications")
    public WebElement homePgViewQaCertLink;

    @FindBy (css ="div:nth-child(4) > h2")
    public WebElement homePgEmissionsHeader;

    @FindBy (css ="div:nth-child(4) > a#Emissions")
    public WebElement homePgViewEmissionsLink;

    @FindBy (css ="div.box__title")
    public WebElement homePgWhatsNewHeader;

    @FindBy (css ="li:nth-child(2) > button > span > span")
    public WebElement resourcesMenuHeader;

    @FindBy (css ="a[href='/ecmps/resources']")
    public WebElement resourcesButton;

    @FindBy (css ="div:nth-child(1) > span")
    public WebElement resourcesPageHeader;

    @FindBy (css ="div.grid-row > div:nth-child(1) > h2")
    public WebElement resourcesPageGlossaryHeader;

    @FindBy (id ="Glossary")
    public WebElement resourcesPageGlossaryLink;

    @FindBy (css ="div.grid-row > div:nth-child(2) > h2")
    public WebElement resourcesPageReportInstructionsHeader;

    @FindBy (id ="ReportingInstructions")
    public WebElement resourcesPageReportInstructionsLink;

    @FindBy (css ="div.grid-row > div:nth-child(3) > h2")
    public WebElement resourcesPageCamApiHeader;

    @FindBy (id ="CAMAPI")
    public WebElement resourcesPageCamApiLink;

    @FindBy (css ="div:nth-child(3) > span")
    public WebElement resourcesPageAdditionalResourcesHeader;

    @FindBy (id ="CDX")
    public WebElement resourcesPageCdxLink;

    @FindBy (id ="Tutorials")
    public WebElement resourcesPageTutorialsLink;

    @FindBy (css ="a[href='/ecmps/faqs']")
    public WebElement faqsButton;

    @FindBy (css ="#faqPage > div > div:nth-child(1) > span")
    public WebElement faqsPageHeader;

    @FindBy (css ="#faqPage > div > div:nth-child(2) > h2")
    public WebElement faqsPageMonPanHeader;

    @FindBy (css ="#faqPage > div > div:nth-child(3) > h2")
    public WebElement faqsPageQAandCertificationsHeader;

    @FindBy (css ="#faqPage > div > div:nth-child(4) > h2")
    public WebElement faqsPageEmissionsHeader;

    @FindBy (css ="div[class='grid-col-9 fit-content'] > div > div > h2")
    public List<WebElement> faqsPageAccordionButton;

    @FindBy (css ="div[class='usa-accordion__content usa-prose']")
    public List<WebElement> faqsPageAccordionContent;

    @FindBy (css ="li:nth-child(3) > button > span > span")
    public WebElement helpSupportMenuHeader;

    @FindBy (css ="a[href='/ecmps/help-support']")
    public WebElement helpSupportButton;

    @FindBy (css ="div:nth-child(1) > span")
    public WebElement helpSupportPageHeader;

    @FindBy (css ="div:nth-child(2) > span")
    public WebElement helpSupportPageFaqsHeader;

    @FindBy (css ="a[title='Go to FAQ page']")
    public WebElement helpSupportPageVisitFaqsButton;

    @FindBy (css ="div:nth-child(3) > span")
    public WebElement helpSupportPageTutorialsHeader;

    @FindBy (css ="button[data-testid='linkCDXHelp']")
    public WebElement helpSupportPageCdxHelpLink;

    @FindBy (css ="div:nth-child(4) > span")
    public WebElement helpSupportPageContactUsHeader;

    @FindBy (id ="btnSubmit")
    public WebElement helpSupportPageSubmitButton;

}
