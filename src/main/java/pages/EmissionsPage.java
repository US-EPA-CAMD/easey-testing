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


    //VIEW TEMPLATE DROPDOWN OPTIONS

    //option[contains(text(),'Emissions View Counts')]
    @FindBy (xpath = "//option[contains(text(),'Emissions View Counts')]")
    public WebElement emissionsViewCountOption;

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

    //option[contains(text(),'Heat Input for Unit/Stack View')]
    @FindBy (xpath = "//option[contains(text(),'Heat Input for Unit/Stack View')]")
    public WebElement heatInputOption;

    //option[contains(text(),'Hourly Heat Input Appendix D View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly Heat Input Appendix D View')]")
    public WebElement hourlyHeatInputOption;

    //option[contains(text(),'Hourly SO2 Appendix D View')]
    @FindBy (xpath = "//option[contains(text(),'Hourly SO2 Appendix D View')]")
    public WebElement hourlyS02AppendixOption;

    //option[contains(text(),'Hourly CO2 Appendix D View')]
    @FindBy (xpath = " //option[contains(text(),'Hourly CO2 Appendix D View')]")
    public WebElement hourlyC02AppendixOption;

    //option[contains(text(),'NOX Appendix E Individual Fuel Curve View')]
    @FindBy (xpath = " //option[contains(text(),'NOX Appendix E Individual Fuel Curve View')]")
    public WebElement hourlyNOxAppendixOption;

    //option[contains(text(),'Unit Level Fuel Curve View')]
    @FindBy (xpath = " //option[contains(text(),'Unit Level Fuel Curve View')]")
    public WebElement unitLevelFuelCurveOption;

    //option[contains(text(),'Daily Calibration View')]
    @FindBy (xpath = "//option[contains(text(),'Daily Calibration View')]")
    public WebElement dailyCalibrationOption;

    //option[contains(text(),'Other Daily Tests View')]
    @FindBy (xpath = "//option[contains(text(),'Other Daily Tests View')]")
    public WebElement otherDailyTestsOption;

    //option[contains(text(),'MATS HG View')]
    @FindBy (xpath = "//option[contains(text(),'MATS HG View')]")
    public WebElement matsHGOption;

    //option[contains(text(),'MATS HCL View')]
    @FindBy (xpath = "//option[contains(text(),'MATS HCL View')]")
    public WebElement matsHCLOption;

    //option[contains(text(),'MATS HF View')]
    @FindBy (xpath = "//option[contains(text(),'MATS HF View')]")
    public WebElement matsHFOption;

    //option[contains(text(),'MATS SO2 View')]
    @FindBy (xpath = "//option[contains(text(),'MATS SO2 View')]")
    public WebElement matsSO2Option;

    //option[contains(text(),'MATS weekly View')]
    @FindBy (xpath = "//option[contains(text(),'MATS weekly View')]")
    public WebElement matsWeeklyOption;

    //option[contains(text(),'MATS Sorbent View')]
    @FindBy (xpath = "//option[contains(text(),'MATS Sorbent View')]")
    public WebElement matsSorbentOption;

    //option[contains(text(),'Moisture View')]
    @FindBy (xpath = "//option[contains(text(),'Moisture View')]")
    public WebElement moistureOption;

    //option[contains(text(),'CO2 Daily Fuel Sampling View')]
    @FindBy (xpath = "//option[contains(text(),'CO2 Daily Fuel Sampling View')]")
    public WebElement co2DailyFuelOption;

    //option[contains(text(),'Long Term Fuel Flow View')]
    @FindBy (xpath = "//option[contains(text(),'Long Term Fuel Flow View')]")
    public WebElement longTermFuelFlowOption;

    //option[contains(text(),'LME View')]
    @FindBy (xpath = "//option[contains(text(),'LME View')]")
    public WebElement lmeOption;

    //option[contains(text(),'CO2 Calculation')]
    @FindBy (xpath = "//option[contains(text(),'CO2 Calculation')]")
    public WebElement co2CalculationOption;

    //option[contains(text(),'Mass Oil Calculation View')]
    @FindBy (xpath = "//option[contains(text(),'Mass Oil Calculation View')]")
    public WebElement massOilCalculationOption;

    //option[contains(text(),'NSPS4T Summary View')]
    @FindBy (xpath = "//option[contains(text(),'NSPS4T Summary View')]")
    public WebElement nsps4tSummaryOption;

    ///END View Template dropdown Options

    //select[@id='emissions-import-type-selector']
    @FindBy (xpath = "//select[@id='emissions-import-type-selector']")
    public WebElement importType;

    //option[contains(text(),'Import From File')]
    @FindBy (xpath = "//option[contains(text(),'Import From File')]")
    public WebElement importFromFileOption;

}