package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class ReactAppHomePage extends PageBase {

    public ReactAppHomePage(WebDriver driver) { super(driver); }

    @FindBy(css="table")
    public WebElement table;


}
