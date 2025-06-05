// LoginPage.java
package com.bookmyshow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "mobileNo")
    private WebElement mobileNumberField;
    
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    private WebElement continueButton;
    
    @FindBy(id = "otp")
    private WebElement otpField;
    
    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    private WebElement verifyButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberField.sendKeys(mobileNumber);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void enterOTP(String otp) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(otpField)).sendKeys(otp);
    }

    public void clickVerify() {
        verifyButton.click();
    }
}