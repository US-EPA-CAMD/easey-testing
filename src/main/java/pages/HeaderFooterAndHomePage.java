package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class HeaderFooterAndHomePage extends PageBase {

    public HeaderFooterAndHomePage(WebDriver driver) { super(driver); }

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

    @FindBy (css ="div:nth-child(1) > div.text-bold.font-heading-2xl")
    public WebElement helpSupportPageHeader;

    @FindBy (css ="div:nth-child(2) > div.text-bold.font-heading-2xl")
    public WebElement helpSupportPageFaqsHeader;

    @FindBy (css ="a[title='Go to FAQ page']")
    public WebElement helpSupportPageVisitFaqsButton;

    @FindBy (css ="div:nth-child(3) > div.text-bold.font-heading-2xl")
    public WebElement helpSupportPageTutorialsHeader;

    @FindBy (css ="button[data-testid='linkCDXHelp']")
    public WebElement helpSupportPageCdxHelpLink;

    @FindBy (css ="div:nth-child(4) > div.text-bold.font-heading-2xl")
    public WebElement helpSupportPageContactUsHeader;

    @FindBy (id ="btnSubmit")
    public WebElement helpSupportPageSubmitButton;

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

}
