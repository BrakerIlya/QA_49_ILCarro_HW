package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement checkBoxIAgree;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBoxIAgree2;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement btnYalla;
    public void typeLoginForm(User user) {
        inputName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
    }
    public void clickCheckBoxIAgree(){
        checkBoxIAgree2.click();
    }
    public void clickCheckBoxWithActions(){
        Actions actions=new Actions(driver);
        int x= checkBoxIAgree.getSize().getWidth();
        int y = checkBoxIAgree.getSize().getHeight();
        actions.moveToElement(checkBoxIAgree,-(x/10*4),-(y/4)).click().perform();
        System.out.println(x);
    }
    public boolean btnYallaIsEnabled(){
        return elementIsEnabled(btnYalla);
    }


}
