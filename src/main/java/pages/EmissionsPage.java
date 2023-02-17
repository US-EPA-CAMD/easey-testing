package pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class EmissionsPage extends MonitoringPlansPage {

    public EmissionsPage(WebDriver driver) { super(driver); }

    //Amanda adding buttons and stuff
    @FindBy(xpath = "//a[@id='Emissions']")
    public WebElement emissionsTab ;

    @FindBy (xpath = "//button[contains(text(),'Export Data')]")
    public WebElement emissionsExportButton ;

}