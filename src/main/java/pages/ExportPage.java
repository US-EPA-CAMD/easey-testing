package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExportPage extends HeaderFooterAndHomePage  {

    public ExportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2[epa-testid='ExportDataTitle']")
    public WebElement title;

    @FindBy(linkText = "/export")
    public WebElement export;

    @FindBy (xpath = "//strong[contains(text(),'QA & Certification')]")
    public WebElement qaButton;

    //body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/label[1]
    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/label[1]")
    public WebElement qaButtonL;

    @FindBy (id ="monitoring-plan")
    public WebElement mpButton;

    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/label[1]")
    public WebElement MPButton ;

    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/label[1]")
    public WebElement MPButtonL ;

    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/label[1]")
    public WebElement emissionsButton;

    @FindBy (id = "year-dropdown")
    public List<WebElement> YearDropdown;

    @FindBy(css = "select[data-testid='year-dropdown'] > option")
    public List<WebElement> YearDD;

    @FindBy (id = "quarter-dropdown")
    public List<WebElement> QuarterDropdown;

    @FindBy(css = "select[data-testid='quarter-dropdown'] > option")
    public List<WebElement> QuarterDD;

    @FindBy (xpath = "//button[contains(text(),'Export')]")
    public WebElement exportButton ;

    //body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]
    @FindBy (xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[4]/div[2]/main[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/button[1]")
    public WebElement exportButtonL ;

}
