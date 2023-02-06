package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QaCertificationPage extends MonitoringPlansPage {

    public QaCertificationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2[epa-testid='QACertificationsTestDataTitle']")
    public WebElement title;
    //tbody/tr[1]/td[2]/form[1]/input[1]
    @FindBy(xpath = "//tbody/tr[1]/td[2]/form[1]/input[1]")
    public WebElement filterByKeywordBoxQa;

    //h3[contains(text(),'Select Configurations')]
    @FindBy(xpath = "//h3[contains(text(),'Select Configurations')]")
    public WebElement selectConfigTitle;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/form[1]/button[1]")
    public WebElement filterByKeywordBTNQa;

    //a[@id='MonitoringPlans_wks']
    @FindBy(xpath = "//a[@id='MonitoringPlans_wks']")
    public WebElement mpTabWKSPC;

    //label[contains(text(),'Username')]
    @FindBy(xpath = "//label[contains(text(),'Username')]")
    public WebElement usernameModalQA;
    //input[@id='modal-username']
    @FindBy(xpath = "//input[@id='modal-username']")
    public WebElement usernameFieldModalQA;

    @FindBy(id = "Test Type Group")
    public WebElement testTypeGroupBox;
    //option[contains(text(),'Linearity Summary')]


    @FindBy(css = "option[data-testid='Linearity Summary']")
    public WebElement linearitySummary;


    @FindBy(id = "btnEditViewTest-Summary-Data1")
    public WebElement viewLS;


    @FindBy(xpath = "//h2[contains(text(),'Test Summary Data')]")
    public WebElement testSummaryModalTitle;

    //b[contains(text(),"Changing the selection for the 'Test Type Code' field shall update the dropdown options available for other fields.")]
    @FindBy(xpath = "//b[contains(text(),'Changing the selection for the 'Test Type Code' field shall update the dropdown options available for other fields.')]")
    public WebElement testSummaryModalText;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    public WebElement closeModal;

    //button[@id='openModalBTN']
    @FindBy(xpath = "//button[@id='openModalBTN']")
    public WebElement login;

    //button[contains(text(),'Test Data Report')]
    @FindBy(xpath = " //button[contains(text(),'Test Data Report')]")
    public WebElement testDataReportBTN;

    //label[contains(text(),'Username')]
    @FindBy(xpath = "//label[contains(text(),'Username')]")
    public WebElement usernameModal;

    //button[@id='btnAddTest-Summary-Data']
    @FindBy(xpath = "//button[@id='btnAddTest-Summary-Data']")
    public WebElement addTestDataBTN;

    //add test data MODAL section

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

    //body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]
    @FindBy(xpath = "//body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")
    public WebElement beginHourSelection;

    @FindBy(xpath = "//option[contains(text(),'0')]")
    public WebElement zeroEntry;

    //select[@id='Begin Minute']
    @FindBy(xpath = "//select[@id='Begin Minute']")
    public WebElement beginMinute;

    @FindBy(css = "select[id='Begin Minute'] > option")
    public List<WebElement> beginMinDropdown;

    //body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]
    @FindBy(xpath = "//body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")
    public WebElement beginMinuteSelection;

    //input[@id='End Date']
    @FindBy(xpath = "//input[@id='End Date']")
    public WebElement endDate;

    //select[@id='End Hour']
    @FindBy(xpath = "//select[@id='End Hour']")
    public WebElement endHour;

    @FindBy(css = "select[id='End Hour'] > option")
    public List<WebElement> endHourDropdown;

    @FindBy(xpath = "//body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[5]/div[3]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")
    public WebElement endHourSelection;

    //select[@id='End Minute']
    @FindBy(xpath = "//select[@id='End Minute']")
    public WebElement endMinute;

    @FindBy(css = "select[id='End Minute'] > option")
    public List<WebElement> endMinDropdown;

    @FindBy(xpath = "//body/div[@id='portal']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]/option[2]")
    public WebElement endMinuteSelection;

    //button[@id='saveBtn']
    @FindBy(xpath = "//button[@id='saveBtn']")
    public WebElement saveBTN;

    //END SELECTIONS

    //button[@id='btnEditViewTest-Summary-Data1']
    @FindBy(xpath = "//button[@id='btnEditViewTest-Summary-Data1']")
    public WebElement editDataBTN;

    //button[contains(text(),'Remove')]
    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeDataBTN;

    //button[contains(text(),'Yes')]
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    public WebElement yesRemoveDataBTN;

    @FindBy(xpath = "//button[contains(text(),'Save and Close')]")
    public WebElement saveBTN1;
    //div[contains(text(),'Test Type Code')]
    @FindBy(xpath = "//div[contains(text(),'Test Type Code')]")
    public WebElement testTypeCodeTableHeader;

    //div[contains(text(),'LINE')]
    @FindBy(xpath = "//div[contains(text(),'LINE')]")
    public WebElement testTypeCodeTableContents;

    //button[contains(text(),'Cancel')]
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelBTN;
    //button[@id='btnCheckBackIn']
    @FindBy(xpath = "//button[@id='btnCheckBackIn']")
    public WebElement checkBACKINBTN;

    @FindBy(xpath = "//div[contains(text(),'Smith Generating Facility')]")
    public WebElement facilityName;

    // div.react-transition.fade-in.padding-bottom-5 div.grid-row:nth-child(4) div.grid-col.minh-tablet-lg main.mainContent div.react-transition.fade-in.padding-x-3 div.tabContent.border-top-1px.border-base-lighter.margin-top-4.padding-top-4 div.selectedTabsBox div.padding-top-0 div.padding-3 div.sc-hHLeRK.cDZNJS.data-display-table.react-transition.fade-in div.sc-kgflAQ.jOHgfL div.sc-bczRLJ.jNMKxq.rdt_Table div.sc-dIouRR.gtmhjP.rdt_TableBody div.sc-jqUVSM.jDzTPE.rdt_TableRow div.sc-hKMtZM.sc-eCYdqJ.sc-jSMfEi.cLRkKo.gbjUDS.fccfpj.rdt_TableCell:nth-child(1) div:nth-child(1) div.editViewExpandGroup > button.usa-button.usa-button--outline:nth-child(3)\
    @FindBy(css = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[3]")
    public WebElement removeBTN;

    //button[@id='showRevertModal']
    @FindBy(xpath = "//button[@id='showRevertModal']")
    public WebElement revertToOfficailBTN;
    //button[@id='saveBtn']
    @FindBy(xpath = "//button[@id='saveBtn']")
    public WebElement yesSaveBTN;

    //button[@id='btnStopAnimation']
    @FindBy(xpath = "//button[@id='btnStopAnimation'")
    public WebElement stopAnimationBTN;

    //button[@id='checkInBTN']
    @FindBy(xpath = "//button[@id='btnStopAnimation'")
    public WebElement checkInBTN;
}
