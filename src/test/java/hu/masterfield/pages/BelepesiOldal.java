package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BelepesiOldal extends BasePage {

  //  String emailcim = "vargakpm@freemail.hu";
  //  String jelszo = "Tesco0000";

// A weboldalon lévő elemek kikeresése és példányositása

    @FindBy(id = "email")
    WebElement emailCimMezo;   // username mező

    @FindBy(id = "password")
    WebElement jelszoMezo;   // jelszó mező

    @FindBy(className = "smart-submit-button")
    WebElement belepesGomb;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/span/div/div/div[2]/form[1]/button/span/span")
    WebElement acceptAllCookies;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[1]/section/div/form/ul/li[1]/div/div/ul/li")
    WebElement hibauziHianyzoEmail;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[1]/section/div/div/span/text()")
    WebElement hibauziEmailVagyJelszoRossz;


    // konstruktor
    public BelepesiOldal(WebDriver driver) {   // ez a konstruktor
        super(driver);
    }

// Műveleteket végző függvények

    public void oldalMegnyito() {   // Belépési oldalra navigálás
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU/login");
        assertTrue(isLoaded(jelszoMezo));
    }

    public void cookieElfogado() {   //  cookiek elfogadása a Belépési oldalon
        acceptAllCookies.click();
        // assertTrue(isLoaded(acceptAllCookies));
    }

    public void belepesOldalEllenorzes() {   // a Belépési oldalon vagyok? ellenőrzése
        assertTrue(isLoaded(jelszoMezo));
    }

    public void hibauzenetEllenorzesHianyzoEmail(String vartHibaUzenet) {    // hiányzó email cim esetén helyes hibaüzenet jelenik meg?
        assertEquals(hibauziHianyzoEmail.getText(), vartHibaUzenet);
    }

    public void hibauzenetEllenorzesHibasEmailJelszo(String vartHibaUzenet) {    // hibás email cim vagy jelszó esetén helyes hibaüzenet jelenik meg?
        assertEquals(hibauziHianyzoEmail.getText(), vartHibaUzenet);
    }

    public VasarlasKezdoOldal belepes(String emailcim, String jelszo) {  // A Webáruházba való belépés végrehajtása
        assertTrue(isLoaded(belepesGomb));
        emailCimMezo.sendKeys(emailcim);
        jelszoMezo.sendKeys(jelszo);
        belepesGomb.click();

        return new VasarlasKezdoOldal(driver);  //
    }

}
