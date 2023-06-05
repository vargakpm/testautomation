package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BelepesiOldal extends BasePage {

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

    public void belepes() {
        emailCimMezo.sendKeys("");
        jelszoMezo.sendKeys("");
        belepesGomb.click();
        assertTrue(isLoaded(belepesGomb));
    }

 /*   public TermekvalasztasOldal belepteto() {  // cookie elfogadó függvény
        usernameMezo.sendKeys("standard_user");
        passwordMezo.sendKeys("secret_sauce");
        loginGomb.click();

        return new TermekvalasztasOldal(driver);  // navigate to termék lista
    }
*/

}
