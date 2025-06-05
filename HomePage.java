// HomePage.java
package com.bookmyshow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(css = "div.sc-1vmod7e-2.fJQoxh")
    private WebElement locationPopup;
    
    @FindBy(xpath = "//button[contains(text(),'Not Now')]")
    private WebElement notNowButton;
    
    @FindBy(css = "input[placeholder='Search for Movies, Events, Plays, Sports and Activities']")
    private WebElement searchBox;
    
    @FindBy(css = "div.sc-133848s-2.cDnOQy")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void closeLocationPopup() {
        if(locationPopup.isDisplayed()) {
            notNowButton.click();
        }
    }

    public void searchForMovie(String movieName) {
        searchBox.sendKeys(movieName);
        // Add code to select from suggestions
    }

    public void clickSignIn() {
        signInButton.click();
    }
}