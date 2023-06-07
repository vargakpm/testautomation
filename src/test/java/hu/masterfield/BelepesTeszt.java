package hu.masterfield;

import hu.masterfield.pages.BelepesiOldal;
import hu.masterfield.pages.KezdoOldal;
import hu.masterfield.pages.VasarlasKezdoOldal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BelepesTeszt extends BaseTest {

    @Test
    @DisplayName("Tesco webáruház teszt")
    public void belepesTeszt() throws InterruptedException {

        // Tesco Webshop kezdőoldal megnyitasa
        KezdoOldal kezdoOldal = new KezdoOldal(driver);
        kezdoOldal.megnyito();
        kezdoOldal.belepteto();

        // belépés a Tesco Webshopba
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.belepes("vargakpm@freemail.hu","Tesco0000");

        // belépés sikerességének ellenőrzése
        VasarlasKezdoOldal vasarlasKezdoOldal = new VasarlasKezdoOldal(driver);
        vasarlasKezdoOldal.belepesSikeres();
         }


}
