package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QaCertificationPage extends MonitoringPlansPage {

    public QaCertificationPage(WebDriver driver) { super(driver); }

    @FindBy(css = "h2[epa-testid='QACertificationsTestDataTitle']")
    public WebElement title;

    @FindBy (css = "#txtSearchData")
    public WebElement filterByKeywordBoxQa;

    @FindBy (xpath = "//tbody/tr[1]/td[3]/button[1]")
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

}
