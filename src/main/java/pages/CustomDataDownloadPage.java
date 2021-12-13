package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class CustomDataDownloadPage extends PageBase {

    public CustomDataDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.mainContent > div > div > h2")
    public WebElement title;

    @FindBy(css = "button[aria-controls='menu-Help/Support']")
    public WebElement navitem;

    @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(4) > a")
    public WebElement contactuslink;

    @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(3) > a")
    public WebElement faqlink;

    @FindBy(css=" nav.usa-nav:nth-child(1) > ul >li:nth-child(2) >ul > li:nth-child(2) > a")
    public WebElement tutorialslink;

    @FindBy(css = "div.mainContent > div > h1")
    public WebElement abouttitle;

    @FindBy(css = "header >  div:nth-child(2) > div > h2")
    public WebElement hometitle;

    @FindBy(css = "div.mainContent >  div > div > h1")
    public WebElement pagetitle;

    @FindBy(css = "div.usa-accordion > h4 > button")
    public WebElement accordion;

    @FindBy(id = "txtEmail")
    public WebElement email;

    @FindBy(css = "fieldset >div:nth-child(2)")
    public WebElement contactradio;

    @FindBy(id = "txtComment")
    public WebElement comment;

    @FindBy(id = "btnSubmit")
    public WebElement contactsubmit;

    @FindBy(css = "button[data-testid='selectable-card']")
    public List<WebElement> emissionsBtn;

    @FindBy(css = "button[class='usa-button usa-button--outline margin-right-0 desktop:grid-col-4']")
    public WebElement changebutton;

    @FindBy(id = "data-sub-type")
    public WebElement subtypeDropdown;

    @FindBy(css = "select[id='data-sub-type'] > option")
    public List<WebElement> subtypeoption;

    @FindBy(id = "multi-select-combobox")
    public WebElement accountNameSearch;

    @FindBy(id = "vintage-years-searchbox")
    public WebElement vintageyearssearch;

    @FindBy(id = "owners/operators-searchbox")
    public WebElement ownersearch;

    @FindBy(css = "ul[id='listbox'] > li > span")
    public List<WebElement> namenumber;

    @FindBy(css ="div.border-top-1px.border-base-light.padding-x-6.padding-y-3.minh-mobile-lg > button.usa-button.float-right.clearfix")
    public WebElement applyBtn;

    @FindBy(css = "div.filter-container > p > button")
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

    @FindBy(css= "div.mainContent > div > div:nth-child(2) > div > div > button")
    public WebElement previewdata;


    @FindBy(id= "facilities-searchbox")
    public WebElement facilitiesSearch;

    @FindBy(id= "source-categories-searchbox")
    public WebElement sourcesearch;

    @FindBy(css = "li[role='option']")
    public List <WebElement> searchoptions;

    @FindBy(css = "div[data-testid='checkbox'] > input")
    public List<WebElement> checkbox;

    @FindBy(css = "div[data-testid='checkbox'] > label")
    public List<WebElement> label;


    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[3]/button[1]")
    public WebElement state;







}