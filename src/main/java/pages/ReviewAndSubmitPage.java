package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;
import java.util.List;

public class ReviewAndSubmitPage extends PageBase{

    public ReviewAndSubmitPage(WebDriver driver) { super(driver); }

// General

    @FindBy(css = "div[data-testid='alert']")
    public WebElement alert;

    // Log In
    @FindBy(id = "openModalBTN")
    public WebElement logInButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[data-test='component-login-submit-button']")
    public WebElement login;

    // Navigation Item
    @FindBy(id = "Review&Submit_wks")
    public WebElement ReviewSubmitMenuItem;

    //Workspace Filter Options
    @FindBy(css = "fieldset > div > label")
    public List<WebElement> criticalErrorsRadio;

    @FindBy(id = "Facilities-searchbox")
    public WebElement facilitiesSearchbox;

    @FindBy(css = "ul[id='Facilities-listbox'] > li ")
    public List<WebElement> facilitiesListItem;

    @FindBy(id = "Configurations-searchbox")
    public WebElement configSearchbox;

    @FindBy(css = "ul[id='Configurations-listbox'] > li ")
    public List<WebElement> configListItem;

    @FindBy(id = "Reporting-Periods-searchbox")
    public WebElement ReportingPeriodSearchbox;

    @FindBy(css = "ul[id='Reporting-Periods-listbox'] > li ")
    public List<WebElement> reportingPeriodsListItem;


    @FindBy(css = "div[id='submit-button-group'] > button")
    public List<WebElement> filterSubmitButton;

    // Workspace Tables
    @FindBy(css = "span> svg[data-prefix='fas']")
    public List<WebElement> chevronArrows;

    @FindBy(css = "div[data-testid='checkbox'] > input")
    public List<WebElement> configSelect;

    @FindBy(css = "button[data-testid='ViewButton']")
    public List<WebElement> configView;

    @FindBy(css = "div[role='columnheader'] > div")
    public List<WebElement> TableHeaders;

// Modal Selectors

    @FindBy(css = "div.modal-wrapper")
    public WebElement modal;

    @FindBy(id = "saveBtn")
    public WebElement verify;

    @FindBy(id = "saveBtn")
    public WebElement answer;

    @FindBy(css= "h4.usa-accordion__heading")
    public List<WebElement> CertStatementAccordion;

    @FindBy(css = "div.modal-footer > div > div> label")
    public WebElement CertStatementLabel;



}