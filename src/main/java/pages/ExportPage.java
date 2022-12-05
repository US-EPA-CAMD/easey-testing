package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExportPage extends HeaderFooterAndHomePage  {

    public ExportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "/export")
    public WebElement export;

    @FindBy (id ="qa-and-certification")
    public WebElement qaButton;

    @FindBy (id ="monitoring-plan")
    public WebElement mpButton;

    @FindBy (id ="emissions")
    public WebElement emissionsButton;

    @FindBy (id = "year-dropdown")
    public List<WebElement> YearDropdown;

    @FindBy(css = "select[data-testid='year-dropdown'] > option")
    public List<WebElement> YearDD;

    @FindBy (id = "quarter-dropdown")
    public List<WebElement> QuarterDropdown;

    @FindBy(css = "select[data-testid='quarter-dropdown'] > option")
    public List<WebElement> QuarterDD;

    @FindBy (css = "option[data-testid='Button']")
    public WebElement exportButton ;

}
