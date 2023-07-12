package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

    // Define page driver object
    protected WebDriver driver;

    // Select the browser based on the system property
//    protected String browser = System.getProperty("browser");

    // Constructor and initialize elements
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "openModalBTN")
    public WebElement logInButtonOpenModal;

    @FindBy(css = "button[data-test='component-login-submit-button']")
    public WebElement logInButtonSubmit;

    @FindBy (css ="label[for='modal-username']")
    public WebElement usernameLabelModal;

    @FindBy (id ="modal-username")
    public WebElement usernameFieldModal;

    @FindBy (css ="label[for='modal-password']")
    public WebElement passwordLabelModal;

    @FindBy (id ="modal-password")
    public WebElement passwordFieldModal;

    @FindBy (css = "a[title='Go to the workspace page']")
    public WebElement dashWorkspace;
}
