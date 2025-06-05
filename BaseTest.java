// BaseTest.java
package com.bookmyshow.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.bookmyshow.utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setUp() {
        config = new ConfigReader();
        String browser = config.getProperty("browser");
        
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", config.getProperty("chrome.driver.path"));
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", config.getProperty("firefox.driver.path"));
            driver = new FirefoxDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}