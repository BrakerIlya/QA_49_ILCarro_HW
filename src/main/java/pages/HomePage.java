package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.LocalDate;


public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get(PropertiesReader.getProperty("base.properties", "baseUrl"));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//a[@ng-reflect-router-link=\"login\"]")
    WebElement btnLoginHeader;
    @FindBy(id="city")
    WebElement inputCity;
    @FindBy(id="dates")
    WebElement inputDates;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//h3[@class=\"no-cars-label ng-star-inserted\"]")
    WebElement noAvailableCar;
    @FindBy(xpath = "//div[text()=\" City is required \"]")
    WebElement cityIsRequired;
    public void clickBtnLoginHeader(){
        btnLoginHeader.click();
    }
    public void typeSearchForm(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        System.out.println(dateFrom.toString());
        String dates=dateFrom.getMonthValue()+"/"
                +dateFrom.getDayOfMonth()+"/"
                +dateFrom.getYear()+" - "
                +dateTo.getMonthValue()+"/"
                +dateTo.getDayOfMonth()+"/"
                +dateTo.getYear();
        inputDates.sendKeys(dates);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        clickWait(btnYalla, 3);
    }
    public void typeSearchFormWOJs(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        System.out.println(dateFrom.toString());
        String dates=dateFrom.getMonthValue()+"/"
                +dateFrom.getDayOfMonth()+"/"
                +dateFrom.getYear()+" - "
                +dateTo.getMonthValue()+"/"
                +dateTo.getDayOfMonth()+"/"
                +dateTo.getYear();
        inputDates.sendKeys(dates);
        btnYalla.click();
    }
    public boolean noAvailableCarIsPresent(){
        return elementIsPresent(noAvailableCar);
    }
    public boolean cityISRequiredIsPresent(){
        return elementIsPresent(cityIsRequired);
    }
}
