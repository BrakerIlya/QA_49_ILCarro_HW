package pages;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HeaderMenuItem;

import java.time.Duration;


public abstract class BasePage {
    @Setter
    static WebDriver driver;

    public static <T extends BasePage> T clickButtonHeader(HeaderMenuItem item){
        WebElement element= new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(item.getLocator())));
        element.click();
        switch (item){
            case IL_CARRO -> {
                return (T) new HomePage(driver);
            }
            case SEARCH -> {
                return (T) new SearchPage(driver);
            }
            case LET_THE_CAR_WORK -> {
                return (T) new LetTheWorkCarPage(driver);
            }
            case TERMS_OF_USE -> {
                return (T) new TermsOfUsePage(driver);
            }
            case SIGN_UP -> {
                return (T) new SignUpPage(driver);
            }
            case LOGIN -> {
                return (T) new LoginPage(driver);
            }
            default -> throw new IllegalArgumentException("Invalid parameter headerMenuItem");
        }
    }
    public static void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean elementIsPresent(WebElement element){
       return element.isDisplayed();
    }
    public static boolean elementIsEnabled(WebElement element){
        return element.isEnabled();
    }
}
