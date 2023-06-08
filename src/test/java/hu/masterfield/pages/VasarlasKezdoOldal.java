package hu.masterfield.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VasarlasKezdoOldal extends BasePage {

// A weboldalon lévő elemek kikeresése és példányositása
    @FindBy(id = "utility-header-greetings")
    WebElement udvozles;

    @FindBy(id = "search-input")
    WebElement keresoMezo;




// konstruktor
    public VasarlasKezdoOldal(WebDriver driver) {   // ez a konstruktor
        super(driver);
    }

// Műveleteket végző függvények

    public void belepesSikeres() {
        assertTrue(isLoaded(udvozles));
    }

    public KeresesiEredmenyOldal kereses(String keresendo) {
        keresoMezo.sendKeys(keresendo + Keys.ENTER);
        assertTrue(isLoaded(keresoMezo));
        return new KeresesiEredmenyOldal(driver);
    }

}
