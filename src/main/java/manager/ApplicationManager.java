package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@Getter
public class ApplicationManager {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = false)
    public void teatDown(){
        if(driver!=null){
            driver.quit();
        }

    }
}
