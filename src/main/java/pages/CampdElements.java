package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CampdElements extends PageBase {

    public CampdElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.mainContent > div > div > h2")
    public WebElement title;

// Navigation Items

    // Help/Support Links

        @FindBy(css = "button[aria-controls='menu-Help/Support']")
        public WebElement helpsupport;


            @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(1) > a")
            public WebElement aboutlink;

            @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(4) > a")
            public WebElement contactuslink;


            @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(3) > a")
            public WebElement faqlink;

            @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(2) > a")
            public WebElement tutorialslink;

    // Resources Links
        @FindBy(css = "button[aria-controls='menu-Resources']")
        public WebElement resources;

            @FindBy(css="nav.usa-nav:nth-child(1) > ul >li:nth-child(1) >ul > li:nth-child(2) > a")
            public WebElement resourceslinks;

            @FindBy(css="nav.usa-nav:nth-child(1) > ul >li:nth-child(1) >ul > li:nth-child(1) > a")
            public WebElement glossary;

     // Data Links
        @FindBy(css = "button[aria-controls='menu-DATA']")
        public WebElement datamenu;

            @FindBy(css="nav.usa-nav:nth-child(2) > ul >li:nth-child(2) >ul > li:nth-child(2) > a")
            public WebElement datadownload;

            @FindBy(css="nav.usa-nav:nth-child(2) > ul >li:nth-child(2) >ul > li:nth-child(3) > a")
            public WebElement bulkdata;

            @FindBy(css="nav.usa-nav:nth-child(2) > ul >li:nth-child(2) >ul > li:nth-child(1) > a")
            public WebElement datahome;

            @FindBy(css="nav.usa-nav:nth-child(2) > ul >li:nth-child(2) >ul > li:nth-child(4) > a")
            public WebElement camapi;

      // Related Resources Links

            @FindBy(css = "main > div  > div > div > a")
            public List<WebElement> rrlink;

// General Links

    @FindBy(css = "header >  div:nth-child(2) > div > h2")
    public WebElement hometitle;

    @FindBy(css = "main >  div > div > h1")
    public WebElement pagetitle;

    @FindBy(css = "div.usa-accordion > h3 > button")
    public List<WebElement> accordion;

    @FindBy(css = "div.usa-accordion > div")
    public List<WebElement> accordiontext;

// Contact Us Items
    @FindBy(id = "txtEmail")
    public WebElement email;

    @FindBy(css ="div.usa-alert__body > p ")
    public WebElement contactusalert;

    @FindBy(css = "fieldset >div:nth-child(2)")
    public WebElement contactradio;

    @FindBy(id = "txtComment")
    public WebElement comment;

    @FindBy(id = "btnSubmit")
    public WebElement contactsubmit;

    @FindBy(id = "data-type")
    public WebElement datadropdown;
// Data Home elements
    @FindBy(css = "div.grid-row > div > button")
    public List<WebElement> datahomebutton;

// Bulk Data
    @FindBy(id = "Allowances")
    public WebElement allowance;

    @FindBy(id = "Compliance")
    public WebElement compliance;

    @FindBy(id = "Emissions")
    public WebElement emissions;

    @FindBy(id = "RawEmissions(XML)")
    public WebElement rawemissions;

// Custom Data Download

    @FindBy(css = "button[data-testid='remove']")
    public List<WebElement> remove;

    @FindBy(css = "button[data-testid='Modify']")
    public List<WebElement> modify;

    @FindBy(css = "div.position-relative > div > div > div:nth-child(2) > div > button")
    public WebElement changebutton;

    @FindBy(id = "data-sub-type")
    public WebElement subtypeDropdown;

    @FindBy(css = "select[id='data-sub-type'] > option")
    public List<WebElement> subtypeoption;

    @FindBy(css = "select[id='data-type'] > option")
    public List<WebElement> dataoption;

    @FindBy(id = "multi-select-combobox")
    public WebElement searchbox;

    @FindBy(css = "ul[id='listbox'] > li > span")
    public List<WebElement> searchitem;

    @FindBy(css ="div.position-relative > div > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)")
    public WebElement applyBtn;

    @FindBy(css = "div.filter-container > p.padding-y-0 > button")
    public List<WebElement> filtercriteria;

    @FindBy(css = "input[id='event-date-start']")
    public WebElement datestart;

    @FindBy(css = "input[id='event-date-end']")
    public WebElement dateend;

    @FindBy(id = "event-year-input")
    public WebElement yearinput;

    @FindBy(css = "div.margin-bottom-3 >button")
    public List<WebElement> applyYear;

    @FindBy(css = "div.padding-top-6.padding-bottom-3.padding-x-1 > div > button")
    public List<WebElement> cancelApply;

    @FindBy(id= "previewDataButton")
    public WebElement previewdata;


    @FindBy(css = "div[data-testid='checkbox'] > label")
    public List<WebElement> label;

    @FindBy(css = "div[data-testid='alert']")
    public WebElement alert;

    @FindBy(css = "div[data-testid='alert'] > div > p > span > a")
    public WebElement alertlink;

    @FindBy(css ="div.Tooltip")
    public WebElement tooltip;

    @FindBy(css ="div.usa-checkbox > label")
    public WebElement ophours;

    @FindBy(css ="form > div:nth-child(1) > div")
    public WebElement datetooltipIcon;

    @FindBy(css ="div.panel-header:nth-child(3) > div")
    public WebElement tooltipIcon;

    @FindBy(css ="div.main-content > button")
    public List<WebElement> downloadbutton;

    @FindBy(css ="button[label='JSON']")
    public WebElement downloaddata;

    @FindBy(id ="json")
    public WebElement json;

    // Mobile Elements

    @FindBy(css ="div.usa-nav-container > div:nth-child(2) > button:nth-child(1)")
    public WebElement mobilemenu;

    @FindBy(css ="div.filter-container > p > button > svg")
    public WebElement materialui;

    @FindBy(css = "ul.usa-sidenav > li")
    public List<WebElement> mobilemenulinks;

    @FindBy(css = "div.width-full > div > div:nth-child(2) >button")
    public List<WebElement> mobilefilterbuttons;

    @FindBy(css = "div.position-relative > div > div > div:nth-child(3) > button")
    public List<WebElement> mobilepanelbuttons;

    @FindBy(css = "div.filter-container > p > button > svg")
    public List<WebElement> filtercriteriax;

    @FindBy(id ="validReportingQuarter")
    public WebElement warningmessage;

    @FindBy(css ="div.loading-modal")
    public WebElement loadingmodal;

    @FindBy(css ="div.width-full >div >div > div > button")
    public WebElement mobilepreviewdata;

    @FindBy(css ="div[id=data-table-title] > div> button")
    public WebElement mobiletablebackbutton;

    @FindBy(css ="div.main-content > p > strong  > a")
    public List<WebElement> tutorialspdfs;

    @FindBy(css ="main > div > p > a")
    public List<WebElement> firstparalinks;
 // Homepage and What's new

    @FindBy(id ="Data")
    public WebElement homepageData;

    @FindBy(css ="div.what-is-new-box > ul > li > strong > a")
    public List<WebElement> whatsnewlink;

 // Glossary Page

    @FindBy(css ="div[id='glossary-page'] > button")
    public List<WebElement> glossarylink;

}