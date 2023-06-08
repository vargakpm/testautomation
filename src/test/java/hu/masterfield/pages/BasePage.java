package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {   // ez a konstruktor
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // true: element is displayed
    public boolean isLoaded(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    // true: element is enabled and clickable
    public boolean isInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }

    // aktuális URL lekérő fgv.
    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
