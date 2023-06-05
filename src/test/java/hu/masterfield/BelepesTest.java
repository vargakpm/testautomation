package hu.masterfield;

import hu.masterfield.pages.BelepesiOldal;
import hu.masterfield.pages.KezdoOldal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BelepesTest extends BaseTest {

    @Test
    @DisplayName("Tesco webáruház teszt")
    public void vasarlasTeszt() throws InterruptedException {

        // Tesco Webshop kezdőoldal megnyitasa
        KezdoOldal kezdoOldal = new KezdoOldal(driver);
        kezdoOldal.megnyito();
        kezdoOldal.belepteto();

        // belépés a Tesco Webshopba
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.megnyito();

        /*

        // A Belépési oldal után következő Termékválasztás oldal objektumának létrehozása a balépési oldalban lévő függcénnyel
        TermekvalasztasOldal termekvalasztasOldal = belepesiOldal.belepteto();
        // oldal betöltődésének ellenőrzése
        assertTrue(termekvalasztasOldal.isLoaded());
        // a termékkiválasztás oldal fejléce alapján ellenőrizni, hogy megfelelő oldal nyilt-e meg.
        assertEquals("Products", termekvalasztasOldal.getProductsFejlec());
        // termék kiválasztása és kosárba rakása
        termekvalasztasOldal.kosarbaRako();
        termekvalasztasOldal.kosarMegnyit();

        Kosar kosar = termekvalasztasOldal.kosarMegnyit();
        assertTrue(kosar.isLoaded());
        assertEquals("Your Cart", kosar.getKosarFejlec());

        VasarloiAdatok vasarloiAdatok = kosar.penztarhozUgras();
        assertTrue(vasarloiAdatok.isLoaded());
        assertEquals("Checkout: Your Information", vasarloiAdatok.getVasarloiAdatokFejlec());

        Ellenoriz ellenoriz = vasarloiAdatok.lastCheckoutUgras();
        assertTrue(vasarloiAdatok.isLoaded());
        assertEquals("Checkout: Overview", ellenoriz.getOverviewFejlec());

        SikeresRendeles sikeresrendeles = ellenoriz.rendelesFeladas();
        assertTrue(sikeresrendeles.isLoaded());
        assertEquals("Checkout: Complete!", sikeresrendeles.getCompleteFejlec());


        Thread.sleep(8000);
 */   }


}
