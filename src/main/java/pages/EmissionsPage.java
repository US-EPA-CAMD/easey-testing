package pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import java.util.List;

public class EmissionsPage extends MonitoringPlansPage {

    public EmissionsPage(WebDriver driver) { super(driver); }

    //h2[contains(text(),'Emissions')]
    @FindBy(xpath = "//h2[contains(text(),'Emissions')]")
    public WebElement title ;

    //Amanda adding buttons and stuff
    @FindBy(xpath = "//a[@id='Emissions']")
    public WebElement emissionsTab ;

    @FindBy (xpath = "//button[contains(text(),'Export Data')]")
    public WebElement emissionsExportButton ;

    //select[@id='viewtemplate']
    @FindBy (id = "viewtemplate")
    public WebElement viewTemplateDropdown;


    //VIEW TEMPLATE DROPDOWN OPTIONS

    //option[contains(text(),'Hourly Heat Input CEMS View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly Heat Input CEMS View')]")
    public WebElement hourlyHeatOption;

    //option[contains(text(),'Hourly SO2 CEMS View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly SO2 CEMS View')]")
    public WebElement hourlySO2Option;

    //option[contains(text(),'Hourly NOx Mass CEMS View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly NOx Mass CEMS View')]")
    public WebElement hourlyNOxOption;

    //option[contains(text(),'Hourly NOx Rate CEMS View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly NOx Rate CEMS View')]")
    public WebElement hourlyNOxRateOption;

    //option[contains(text(),'Hourly CO2 CEMS View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly CO2 CEMS View')]")
    public WebElement hourlyCO2cemsOption;


}