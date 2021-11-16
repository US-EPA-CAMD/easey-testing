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

    @FindBy(xpath = "/html/body/div/div/div/div[2]/div/div/h2")
    public WebElement title;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/button[1]")
    public WebElement emissionsBtn;



    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    public WebElement changebutton;

    @FindBy(id = "data-sub-type")
    public WebElement subtypeDropdown;

    @FindBy(css = "select[id='data-sub-type'] > option")
    public List<WebElement> subtypeoption;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]")
    public WebElement applyBtn;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[1]/button[1]")
    public WebElement timeperiod;

    @FindBy(css = "input[id='event-date-start']")
    public WebElement datestart;

    @FindBy(css = "input[id='event-date-end']")
    public WebElement dateend;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/label[1]")
    public WebElement january;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/label[1]")
    public WebElement q1;

    @FindBy(id = "event-year-input")
    public WebElement yearinput;

    @FindBy(xpath = "//button[contains(text(),'Apply Filter')]")
    public WebElement applyfilter;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    public WebElement previewdata;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[2]/button[1]")
    public WebElement program;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[5]/button[1]")
    public WebElement unitType;

    @FindBy(css = "div[data-testid='checkbox'] > input")
    public List<WebElement> checkbox;


    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/label[1]")
    public WebElement arp;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]")
    public WebElement pfb;


    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]")
    public WebElement propill;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[6]/button[1]")
    public WebElement fuelType;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[7]/button[1]")
    public WebElement controlTech;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[2]")
    public WebElement xout;


    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/p[3]/button[1]")
    public WebElement state;
    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
    public WebElement stateInput;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[31]")
    public WebElement nj;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]")
    public WebElement stateFilterButton;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/label[1]")
    public WebElement fuelTypeCoal;

    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]")
    public WebElement fuelTypeApplyFilters;




}