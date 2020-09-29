package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageBase;

public class CVPPage extends PageBase {

    public CVPPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="logo")
    public WebElement logo;

}
