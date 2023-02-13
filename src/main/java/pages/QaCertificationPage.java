package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QaCertificationPage extends MonitoringPlansPage {

    public QaCertificationPage(WebDriver driver) { super(driver); }

    @FindBy(css = "h2[epa-testid='QACertificationsTestDataTitle']")
    public WebElement title;

    @FindBy (xpath = "//tbody/tr[1]/td[2]/form[1]/input[1]")
    public WebElement filterByKeywordBoxQa;

    @FindBy (xpath = "//tbody/tr[1]/td[2]/form[1]/button[1]/span[1]")
    public WebElement filterByKeywordBTNQa;


    @FindBy ( id="Test Type Group")
    public WebElement testTypeGroupBox;
    //option[contains(text(),'Linearity Summary')]


    @FindBy (css = "option[data-testid='Linearity Summary']")
    public WebElement linearitySummary;


    @FindBy (id="btnEditViewTest-Summary-Data1")
    public WebElement viewLS;


    @FindBy (xpath = "//h2[contains(text(),'Test Summary Data')]")
    public WebElement testSummaryModalTitle;


    @FindBy (xpath = "//button[contains(text(),'Close')]")
    public WebElement closeModal;

    //option[contains(text(),'Relative Accuracy')]
    @FindBy (xpath = "//option[contains(text(),'Relative Accuracy')]")
    public WebElement rataOption;

    //button[@id='btnEditViewTest-Summary-Data1']
    //#btnEditViewTest-Summary-Data1
    @FindBy (xpath = "//button[@id='btnEditViewTest-Summary-Data1']")
    public WebElement viewTestData1;

    //*[@id='expandRowTest-Summary-DataRATA1']
    @FindBy (xpath = "//[@id='expandRowTest-Summary-DataRATA1']")
    public WebElement expandTestData1;

    //h2[contains(text(),'Test Summary Data')]
    @FindBy (xpath = " //h2[contains(text(),'Test Summary Data')]")
    public WebElement summaryModalTitle;

    //div[contains(text(),'RATA Data')]
    @FindBy (xpath = " //div[contains(text(),'RATA Data')]")
    public WebElement tableRATAHeader;

    //button[@id='btnEditViewTest-Summary-Data2']
    @FindBy (xpath = "//button[@id='btnEditViewTest-Summary-Data2']")
    public WebElement viewTestData2;

    //button[@id='checkInBTN']
    @FindBy(xpath = "//button[@id='btnStopAnimation'")
    public WebElement checkInBTN;

    //button[@id='btnCheckBackIn']
    @FindBy(xpath = "//button[@id='btnCheckBackIn']")
    public WebElement checkBACKINBTN;


    //button[@id='showRevertModal']
    @FindBy(xpath = "//button[@id='showRevertModal']")
    public WebElement revertToOfficailBTN;
    //button[@id='saveBtn']
    @FindBy(xpath = "//button[@id='saveBtn']")
    public WebElement yesSaveBTN;

    //button[@id='btnStopAnimation']
    @FindBy(xpath = "//button[@id='btnStopAnimation'")
    public WebElement stopAnimationBTN;

    //h3[contains(text(),'Select Configurations')]
    @FindBy(xpath = "//h3[contains(text(),'Select Configurations')]")
    public WebElement selectConfigTitle;

    //button[@id='btnAddTest-Summary-Data']
    @FindBy(xpath = "//button[@id='btnAddTest-Summary-Data']")
    public WebElement addTestDataBTN;

    //input[@id='Unit or Stack Pipe ID']
    @FindBy(xpath = "//input[@id='Unit or Stack Pipe ID']")
    public WebElement UnitIdBox;
    //select[@id='Test Type Code']
    @FindBy(xpath = "//select[@id='Test Type Code']")
    public WebElement testTypeCodeBox;

    @FindBy(css = "select[id='Component ID'] > option")
    public List<WebElement> componentIDDropdown;

    @FindBy(xpath = "//select[@id='Component ID']")
    public WebElement componentIDBox;
    //option[contains(text(),'700')]
    @FindBy(css = "option[data-testid='Linearity Summary']")
    public WebElement componentID700option;

    //select[@id='Span Scale Code']
    @FindBy(xpath = "//select[@id='Span Scale Code']")
    public WebElement spanScaleCodeBox;
    //option[contains(text(),'High')]
    @FindBy(xpath = "//option[contains(text(),'High')]")
    public WebElement spanScaleCodeHigh;
    //input[@id='Test Number']
    @FindBy(xpath = "//input[@id='Test Number']")
    public WebElement testNumberBox;

    //select[@id='Test Reason Code']
    @FindBy(xpath = "//select[@id='Test Reason Code']")
    public WebElement testReasonCodeBox;

    @FindBy(css = "select[id='Test Reason Code'] > option")
    public List<WebElement> testReasonCodeCodeDropdown;

    //option[contains(text(),'Quality Assurance')]
    @FindBy(xpath = "//option[contains(text(),'Quality Assurance')]")
    public WebElement qaSelectionTestReasonCode;

    //option[contains(text(),'Diagnostic')]
    @FindBy(xpath = "//option[contains(text(),'Diagnostic')]")
    public WebElement selectionTestReasonCode;

    //select[@id='Test Result Code']
    @FindBy(xpath = "//select[@id='Test Result Code']")
    public WebElement testResultCodeBox;

    @FindBy(css = "select[id='Test Result Code'] > option")
    public List<WebElement> testResultsCodeCodeDropdown;


    //option[contains(text(),'Does Not Fulfill Testing Requirement')]
    @FindBy(xpath = "//option[contains(text(),'Test Passed Alt Spec')]")
    public WebElement testResultCodeBoxEntry;

    //input[@id='Begin Date']
    @FindBy(xpath = "//input[@id='Begin Date']")
    public WebElement beginDate;

    //select[@id='Begin Hour']
    @FindBy(xpath = "//select[@id='Begin Hour']")
    public WebElement beginHour;

    @FindBy(css = "select[id='Begin Hour'] > option")
    public List<WebElement> beginHourDropdown;

    //select[@id='Begin Minute']
    @FindBy(xpath = "//select[@id='Begin Minute']")
    public WebElement beginMinute;

    @FindBy(css = "select[id='Begin Minute'] > option")
    public List<WebElement> beginMinDropdown;

    //input[@id='End Date']
    @FindBy(xpath = "//input[@id='End Date']")
    public WebElement endDate;

    //select[@id='End Hour']
    @FindBy(xpath = "//select[@id='End Hour']")
    public WebElement endHour;

    @FindBy(css = "select[id='End Hour'] > option")
    public List<WebElement> endHourDropdown;

    //select[@id='End Minute']
    @FindBy(xpath = "//select[@id='End Minute']")
    public WebElement endMinute;

    @FindBy(css = "select[id='End Minute'] > option")
    public List<WebElement> endMinDropdown;

    //a[@id='MonitoringPlans_wks']
    @FindBy(xpath = "//a[@id='MonitoringPlans_wks']")
    public WebElement mpTabWKSPC;

    @FindBy(xpath = "//button[contains(text(),'Save and Close')]")
    public WebElement saveBTN1;

    //button[@id='openModalBTN']
    @FindBy(xpath = "//button[@id='openModalBTN']")
    public WebElement login;

    @FindBy(xpath = "//input[@id='modal-username']")
    public WebElement usernameFieldModalQA;

    @FindBy(xpath = "//label[contains(text(),'Username')]")
    public WebElement usernameModalQA;

    //select[@id='Monitoring System ID']
    @FindBy(xpath = "//select[@id='Monitoring System ID']")
    public WebElement monitoringSystemIDBox;

    //select[@id='Monitoring System ID']
    @FindBy(css = "select[id='Monitoring System ID'] > option")
    public List<WebElement> monitoringSystemIDDropdown;

    //option[contains(text(),'500')]
    //*[@id='expandRowTest-Summary-DataRATA1']

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/svg[1]/path[1]")
    public WebElement plusBTN;

    @FindBy(xpath = "//[@id='expandRowTest-Summary-DataRATA1']")
    public WebElement expandRow;

    @FindBy(xpath = "//[@id='expandRowRATA-Data11']")
    public WebElement expandDataRow;

    //*[@id='expandRowRATA-SummaryM1']
    @FindBy(xpath = "//*[@id='expandRowRATA-SummaryM1']")
    public WebElement expandRataDataRow;

}
