package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

import java.util.List;

public class SamplePage extends PageBase {
    public SamplePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="input[name='q']")
    public WebElement searchBar;

    @FindBy(css="div[class='r'] > a > h3")
    public List<WebElement> results;
}
