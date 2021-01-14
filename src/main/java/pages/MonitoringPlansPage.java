package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class MonitoringPlansPage extends PageBase {

    public MonitoringPlansPage(WebDriver driver) { super(driver); }

    @FindBy(css = "table.usa-table.usa-table--borderless")
    public WebElement table;

    @FindBy(css = "table.usa-table.usa-table--borderless > tbody > tr")
    public List<WebElement> tableResults;

    @FindBy(id = "input-dropdown")
    public WebElement paginationDropdown;

    @FindBy(id = "input-button")
    public WebElement updatePaginationButton;

    @FindBy(css = "div.totalDisplay.col")
    public WebElement total;

    @FindBy(css = "#pagination > li.page-item-next > button")
    public WebElement nextPageButton;

    @FindBy(css = "li.paginate_button.active")
    public WebElement currentPage;
}
