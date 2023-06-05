package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BelepesiOldal extends BasePage {

    String emailcim = "vargakpm@freemail.hu";
    String jelszo = "Tesco0000";

// A weboldalon lévő elemek kikeresése és példányositása

    @FindBy(id = "email")
    WebElement emailCimMezo;   // username mező

    @FindBy(id = "password")
    WebElement jelszoMezo;   // jelszó mező

    @FindBy(className = "smart-submit-button")
    WebElement belepesGomb;

// konstruktor
    public BelepesiOldal(WebDriver driver) {   // ez a konstruktor
        super(driver);
    }

// Műveleteket végző függvények

    public VasarlasKezdoOldal belepes() {
        assertTrue(isLoaded(belepesGomb));
        emailCimMezo.sendKeys(emailcim);
        jelszoMezo.sendKeys(jelszo);
        belepesGomb.click();

        return new VasarlasKezdoOldal(driver);  // navigate to termék lista
    }

}
