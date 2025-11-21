package ui_tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class SearchCarTests extends ApplicationManager {
    HomePage homePage;
    @BeforeMethod
    public void goToHome(){
        homePage= new HomePage(getDriver());

    }
    @Test
    public void searchCarPositiveTest(){
        String city ="Haifa";
        LocalDate dateFrom=LocalDate.of(25,12,12);
        LocalDate dateTo=LocalDate.of(25,12,18);
        homePage.typeSearchForm(city,dateFrom,dateTo);
        Assert.assertTrue(homePage.noAvailableCarIsPresent());
    }
    @Test
    public void searchCarNegativeCityIsEmptyTest(){
        String city ="";
        LocalDate dateFrom=LocalDate.of(25,12,12);
        LocalDate dateTo=LocalDate.of(25,12,18);
        homePage.typeSearchFormWOJs(city,dateFrom,dateTo);
        Assert.assertTrue(homePage.cityISRequiredIsPresent());

    }
}
