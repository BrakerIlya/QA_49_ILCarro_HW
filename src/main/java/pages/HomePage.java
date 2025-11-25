package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement calendarBtnYear;
    private String monthCreate(String month){
        StringBuilder result =new StringBuilder();
        return result.append(month.substring(0,1).toUpperCase())
                .append(month.substring(1).toLowerCase()).toString();

    }
    private void typeCalendar(LocalDate date){
        calendarBtnYear.click();
        String year = Integer.toString(date.getYear());  //2025   2026
        WebElement btnYear = driver.findElement(By.xpath("//td[@aria-label='"+year+"']"));
        //  "//td[@aria-label='"+year+"']" --> "//td[@aria-label='"   "2026"   "']" -->  //td[@aria-label='2026']
        btnYear.click();
        String month = date.getMonth().toString();
        month=monthCreate(month);
        WebElement btnMonth = driver.findElement(By.xpath("//td[@aria-label='"+month+" "+year+"']"));
        btnMonth.click();
        String day= String.valueOf(date.getDayOfMonth());
        String date1= month+" "+day+", " + year;
        WebElement btnDay = driver.findElement(
                By.xpath("//td[@aria-label='"+date1+"']"));
        btnDay.click();

    }
    public void typeSearchFormCalendar(String city, LocalDate dateFrom,LocalDate dateTo) {
        inputCity.sendKeys(city);
        inputDates.click();
        typeCalendar(dateFrom);
        typeCalendar(dateTo);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        btnYalla.click();

    }
}
