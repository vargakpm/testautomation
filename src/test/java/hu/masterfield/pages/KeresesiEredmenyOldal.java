package hu.masterfield.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeresesiEredmenyOldal extends BasePage {

    // A weboldalon lévő elemek kikeresése és példányositása
    @FindBy(className = "instructions-label")  // "Rendezés szempontja:" szöveg
    WebElement rendezes;

    @FindBy(className = "empty-section--empty-text")  // "Sajnos nem található ..." szövegRÉSZ
    WebElement sajnosSzoveg;

    // konstruktor
    public KeresesiEredmenyOldal(WebDriver driver) {   // ez a konstruktor
        super(driver);
    }

// Műveleteket végző függvények

    public void keresesSikeres() {
        assertTrue(isLoaded(rendezes));
    }

    public void nincsTalalat() {
        assertTrue(isLoaded(sajnosSzoveg));
    }


}
