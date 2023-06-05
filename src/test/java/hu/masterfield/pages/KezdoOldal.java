package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KezdoOldal extends BasePage {

// A weboldalon lévő elemek kikeresése és példányositása
    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button/span/span")
    WebElement acceptAllCookies;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div[1]/div[2]/a")
    WebElement BejelentkezesGomb;

// konstruktor
    public KezdoOldal(WebDriver driver) {   // ez a konstruktor
        super(driver);
    }

// Műveleteket végző függvények

    public void megnyito() {   // Belépési oldalra-re navigálás
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
        assertTrue(isLoaded(acceptAllCookies));
    }

    public BelepesiOldal belepteto() {
        acceptAllCookies.click();
        BejelentkezesGomb.click();
        return new BelepesiOldal(driver);
    }

}
