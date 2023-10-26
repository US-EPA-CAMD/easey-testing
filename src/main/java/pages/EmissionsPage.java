package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EmissionsPage extends MonitoringPlansPage {

    public EmissionsPage(WebDriver driver) {
        super(driver);
    }

    //h2[contains(text(),'Emissions')]
    @FindBy(xpath = "//h2[contains(text(),'Emissions')]")
    public WebElement title;

    //Amanda adding buttons and stuff
    @FindBy(xpath = "//a[@id='Emissions']")
    public WebElement emissionsTab;

    @FindBy(xpath = "//button[contains(text(),'Export Data')]")
    public WebElement emissionsExportButton;


    //VIEW TEMPLATE DROPDOWN OPTIONS

    //option[contains(text(),'Emissions View Counts')]
    @FindBy(xpath = "//option[contains(text(),'Emissions View Counts')]")
    public WebElement emissionsViewCountOption;

    //option[contains(text(),'Hourly Combined Parameters View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly Combined Parameters View')]")
    public WebElement hourlyCombinedOption;

    //option[contains(text(),'Hourly Heat Input CEMS View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly Heat Input CEMS View')]")
    public WebElement hourlyHeatOption;

    //option[contains(text(),'Hourly SO2 CEMS View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly SO2 CEMS View')]")
    public WebElement hourlySO2Option;

    //option[contains(text(),'Hourly NOx Mass CEMS View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly NOx Mass CEMS View')]")
    public WebElement hourlyNOxOption;

    //option[contains(text(),'Hourly NOx Rate CEMS View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly NOx Rate CEMS View')]")
    public WebElement hourlyNOxRateOption;

    //option[contains(text(),'Hourly CO2 CEMS View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly CO2 CEMS View')]")
    public WebElement hourlyCO2cemsOption;

    //option[contains(text(),'Heat Input for Unit/Stack View')]
    @FindBy(xpath = "//option[contains(text(),'Heat Input for Unit/Stack View')]")
    public WebElement heatInputOption;

    //option[contains(text(),'Hourly Heat Input Appendix D View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly Heat Input Appendix D View')]")
    public WebElement hourlyHeatInputOption;

    //option[contains(text(),'Hourly SO2 Appendix D View')]
    @FindBy(xpath = "//option[contains(text(),'Hourly SO2 Appendix D View')]")
    public WebElement hourlyS02AppendixOption;

    //option[contains(text(),'Hourly CO2 Appendix D View')]
    @FindBy(xpath = " //option[contains(text(),'Hourly CO2 Appendix D View')]")
    public WebElement hourlyC02AppendixOption;

    //option[contains(text(),'NOX Appendix E Individual Fuel Curve View')]
    @FindBy(xpath = " //option[contains(text(),'NOX Appendix E Individual Fuel Curve View')]")
    public WebElement hourlyNOxAppendixOption;

    //option[contains(text(),'Unit Level Fuel Curve View')]
    @FindBy(xpath = " //option[contains(text(),'Unit Level Fuel Curve View')]")
    public WebElement unitLevelFuelCurveOption;

    //option[contains(text(),'Daily Calibration View')]
    @FindBy(xpath = "//option[contains(text(),'Daily Calibration View')]")
    public WebElement dailyCalibrationOption;

    //option[contains(text(),'Other Daily Tests View')]
    @FindBy(xpath = "//option[contains(text(),'Other Daily Tests View')]")
    public WebElement otherDailyTestsOption;

    //option[contains(text(),'MATS HG View')]
    @FindBy(xpath = "//option[contains(text(),'MATS HG View')]")
    public WebElement matsHGOption;

    //option[contains(text(),'MATS HCL View')]
    @FindBy(xpath = "//option[contains(text(),'MATS HCL View')]")
    public WebElement matsHCLOption;

    //option[contains(text(),'MATS HF View')]
    @FindBy(xpath = "//option[contains(text(),'MATS HF View')]")
    public WebElement matsHFOption;

    //option[contains(text(),'MATS SO2 View')]
    @FindBy(xpath = "//option[contains(text(),'MATS SO2 View')]")
    public WebElement matsSO2Option;

    //option[contains(text(),'MATS weekly View')]
    @FindBy(xpath = "//option[contains(text(),'MATS weekly View')]")
    public WebElement matsWeeklyOption;

    //option[contains(text(),'MATS Sorbent View')]
    @FindBy(xpath = "//option[contains(text(),'MATS Sorbent View')]")
    public WebElement matsSorbentOption;

    //option[contains(text(),'Moisture View')]
    @FindBy(xpath = "//option[contains(text(),'Moisture View')]")
    public WebElement moistureOption;

    //option[contains(text(),'CO2 Daily Fuel Sampling View')]
    @FindBy(xpath = "//option[contains(text(),'CO2 Daily Fuel Sampling View')]")
    public WebElement co2DailyFuelOption;

    //option[contains(text(),'Long Term Fuel Flow View')]
    @FindBy(xpath = "//option[contains(text(),'Long Term Fuel Flow View')]")
    public WebElement longTermFuelFlowOption;

    //option[contains(text(),'LME View')]
    @FindBy(xpath = "//option[contains(text(),'LME View')]")
    public WebElement lmeOption;

    //option[contains(text(),'CO2 Calculation')]
    @FindBy(xpath = "//option[contains(text(),'CO2 Calculation')]")
    public WebElement co2CalculationOption;

    //option[contains(text(),'Mass Oil Calculation View')]
    @FindBy(xpath = "//option[contains(text(),'Mass Oil Calculation View')]")
    public WebElement massOilCalculationOption;

    //option[contains(text(),'NSPS4T Summary View')]
    @FindBy(xpath = "//option[contains(text(),'NSPS4T Summary View')]")
    public WebElement nsps4tSummaryOption;

    ///END View Template dropdown Options

    //select[@id='emissions-import-type-selector']
    @FindBy(xpath = "//select[@id='emissions-import-type-selector']")
    public WebElement importType;

    //option[contains(text(),'Import From File')]
    @FindBy(xpath = "//option[contains(text(),'Import From File')]")
    public WebElement importFromFileOption;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]/*[1]")
    public WebElement xOutReportingPeriod;

    //input[@id='reportingPeriod-searchbox']
    @FindBy (xpath ="//input[@id='reportingPeriod-searchbox']")
    public WebElement reportingPeriodBox;

    @FindBy(id = "reportingPeriod-searchbox")
    public WebElement reportingPeriodInput;
//    css = "select[id='Fuel Type'] > option"
    @FindBy(css = "select[id='viewtemplate'] > option")
    public List<WebElement>  viewtemplateBox;

    //button[contains(text(),'Apply Filter(s)')]
    @FindBy(xpath = "//button[contains(text(),'Apply Filter(s)')]")
    public WebElement applyFilterButton;

    //span[contains(text(),'2022 Q4')]
    @FindBy(xpath = "//span[contains(text(),'2022 Q4')]")
    public WebElement q4button;

    @FindBy(xpath = "//span[contains(text(),'2022 Q3')]")
    public WebElement q3button;

    //body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]")
    public WebElement xbutton;



    public List<WebElement> ReadDropdownValues(String elementID) {
        Select select = new Select(driver.findElement(By.id(elementID)));
        List<WebElement> options = select.getOptions();

        for (int i = 0; i < options.size(); i++) {
            String currentValue = options.get(i).getText();

            System.out.println(currentValue + "!!!!!" + "\n");

            WebElement setter;

            switch (currentValue) {

                case "Hourly Combined Parameters View":
                    setter = hourlyCombinedOption;
                    options.set(i, setter);
                    break;
                case "Hourly NOx Rate CEMS View":
                    setter = hourlyNOxOption;
                    options.set(i, setter);
                    break;
                case "Heat Input for Unit/Stack View":
                    setter = heatInputOption;
                    options.set(i, setter);
                    break;
                case "Hourly Heat Input Appendix D View":
                    setter = hourlyHeatInputOption;
                    options.set(i, setter);
                    break;
                case "Hourly SO2 Appendix D View":
                    setter = hourlySO2Option;
                    options.set(i, setter);
                    break;
                case "Hourly CO2 Appendix D View":
                    setter = hourlyC02AppendixOption;
                    options.set(i, setter);
                    break;
                case "Daily Calibration View":
                    setter = dailyCalibrationOption;
                    options.set(i, setter);
                    break;
                case "Mass Oil Calculation View":
                    setter = massOilCalculationOption;
                    options.set(i, setter);
                    break;
                case "Hourly Heat Input CEMS View":
                    setter = hourlyHeatOption;
                    options.set(i, setter);
                    break;
                case "Hourly CO2 CEMS View":
                    setter = hourlyCO2cemsOption;
                    options.set(i, setter);
                    break;
                case "NOX Appendix E Individual Fuel Curve View":
                    setter = hourlyNOxAppendixOption;
                    options.set(i, setter);
                    break;
                case "Unit Level Fuel Curve View":
                    setter = unitLevelFuelCurveOption;
                    options.set(i, setter);
                    break;
                case "Other Daily Tests View":
                    setter = otherDailyTestsOption;
                    options.set(i, setter);
                    break;
                case "MATS HG View":
                    setter = matsHGOption;
                    options.set(i, setter);
                    break;
                case "MATS HCL View":
                    setter = matsHCLOption;
                    options.set(i, setter);
                    break;
                case "MATS HF View":
                    setter = matsHFOption;
                    options.set(i, setter);
                    break;
                case "MATS SO2 View":
                    setter = matsSO2Option;
                    options.set(i, setter);
                    break;
                case "MATS weekly View":
                    setter = matsWeeklyOption;
                    options.set(i, setter);
                    break;
                case "MATS Sorbent View":
                    setter = matsSorbentOption;
                    options.set(i, setter);
                    break;
                case "Moisture View":
                    setter = moistureOption;
                    options.set(i, setter);
                    break;
                case "CO2 Daily Fuel Sampling View":
                    setter = co2DailyFuelOption;
                    options.set(i, setter);
                    break;
                case "Long Term Fuel Flow View":
                    setter = longTermFuelFlowOption;
                    options.set(i, setter);
                    break;
                case "LME View":
                    setter = lmeOption;
                    options.set(i, setter);
                    break;
                case "CO2 Calculation":
                    setter = co2CalculationOption;
                    options.set(i, setter);
                    break;
                case "NSPS4T Summary View":
                    setter = nsps4tSummaryOption;
                    options.set(i, setter);
                    break;
            }


        }

        return options;
    }
}