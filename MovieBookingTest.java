// MovieBookingTest.java
package com.bookmyshow.tests;

import com.bookmyshow.base.BaseTest;
import com.bookmyshow.pages.HomePage;
import com.bookmyshow.pages.LoginPage;
import com.bookmyshow.pages.MoviePage;
import com.bookmyshow.pages.TheaterPage;
import com.bookmyshow.utils.ExcelDataProvider;
import org.testng.annotations.Test;

public class MovieBookingTest extends BaseTest {
    
    @Test(dataProvider = "movieBookingData", dataProviderClass = ExcelDataProvider.class)
    public void testMovieBooking(String mobileNumber, String otp, String movieName, String location, String date) {
        HomePage homePage = new HomePage(driver);
        homePage.closeLocationPopup();
        homePage.clickSignIn();
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterMobileNumber(mobileNumber);
        loginPage.clickContinue();
        loginPage.enterOTP(otp);
        loginPage.clickVerify();
        
        homePage.searchForMovie(movieName);
        
        MoviePage moviePage = new MoviePage(driver);
        moviePage.selectLocation(location);
        moviePage.selectDate(date);
        moviePage.bookTickets();
        
        TheaterPage theaterPage = new TheaterPage(driver);
        theaterPage.selectTheater();
        theaterPage.selectShowTime();
        
        // Continue with seat selection and payment pages
    }
}