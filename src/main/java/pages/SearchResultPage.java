package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class SearchResultPage extends PageBase {

    public SearchResultPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#main-content > div.main-column.clearfix > div > div > div > div > div.col-md-8.col-lg-push-4.ng-scope > div:nth-child(8) > span > span")
    public WebElement searchResults;
}
