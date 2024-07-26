package com.axterior.base;

import com.axterior.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupAndLogin() {
        String browser = PropertyReader.readProperties("browser");
        if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incongnito");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(PropertyReader.readProperties("url"));

        WebElement usernameField = driver.findElement(By.cssSelector("input[id='Email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[id='Password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys(PropertyReader.readProperties("username"));
        passwordField.sendKeys(PropertyReader.readProperties("password"));
        loginButton.click();
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
