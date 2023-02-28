package pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class EmissionsPage extends MonitoringPlansPage {

    public EmissionsPage(WebDriver driver) { super(driver); }


    @FindBy(xpath = "//h2[contains(text(),'Emissions')]")
    public WebElement title;

    @FindBy(xpath = "//button[contains(text(),'Apply Filter(s)')]")
    public WebElement applyFilter;

    @FindBy(xpath = "//button[contains(text(),'Export Data')]")
    public WebElement exportData;

    @FindBy ( id="viewtemplate")
    public WebElement viewTemplateBox;

    //VIEW TEMPLATE OPTIONS
    @FindBy (xpath = "//option[contains(text(),'Hourly SO2 CEMS View')]")
    public WebElement hourlyS02cemsViewOption;

    @FindBy (xpath = "//option[contains(text(),'Hourly Combined Parameters View')]")
    public WebElement hourlyCombinedParametersViewOption;

    @FindBy (xpath = "//option[contains(text(),'Hourly Heat Input CEMS View')]")
    public WebElement hourlyHeatInputcemsViewOption;

    @FindBy (xpath = "//option[contains(text(),'Hourly NOx Mass CEMS View')]")
    public WebElement hourlyN0xMasscemsViewOption;

    @FindBy (xpath = "//option[contains(text(),'Hourly CO2 CEMS View')]")
    public WebElement hourlyC02cemssViewOption;

    @FindBy (xpath = "//option[contains(text(),'Heat Input for Unit/Stack View')]")
    public WebElement heatInputViewOption;

    
    @FindBy(xpath = "//a[@id='Emissions']")
    public WebElement emissionsTab ;

    @FindBy (xpath = "//button[contains(text(),'Export Data')]")
    public WebElement emissionsExportButton ;


}