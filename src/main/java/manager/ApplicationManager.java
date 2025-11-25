package manager;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class ApplicationManager {
    public final static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = false)
    public void teatDown(){
        logger.info("Stop testing"+ LocalDate.now() + LocalTime.now());
        if(driver!=null){
            driver.quit();
        }

    }
}
