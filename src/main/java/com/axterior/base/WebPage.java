package com.axterior.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibilityOfAllElements(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public void waitForClickabilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}