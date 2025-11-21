package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement btnYalla;
    @FindBy(xpath = "//div[text()=\"It'snot look like email\"]")
    WebElement wrongEmail;
    @FindBy(xpath = "//h1[text()=\"Login failed\"]")
    WebElement divLoginFailed;
    public void typeLoginForm(User user){
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnYalla.click();
    }
    public boolean emailWrong(){
        return elementIsPresent(wrongEmail);
    }
    public boolean loginFailedIsPresent(){
        return elementIsPresent(divLoginFailed);
    }


}
