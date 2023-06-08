package hu.masterfield.steps;

import hu.masterfield.Utils;
import hu.masterfield.pages.BelepesiOldal;
import hu.masterfield.pages.KeresesiEredmenyOldal;
import hu.masterfield.pages.VasarlasKezdoOldal;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class TESCOTesztSteps {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public static Logger log = LogManager.getLogger();

    String screenshootFileName;

    @Before // cucumber annotáció
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = TESCOTesztSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After  // böngésző bezárása
    public static void cleanup() {
        driver.quit();
    }

    @AfterStep   // lépések előtt
    public void screenshot() {
        log.info("Take screenshot");   // log-ba irni ezt
        Utils.takeSnapShot(driver, screenshootFileName);   // képernyőkép készitése
    }


    // Step-ek definiálása:

    @Given("A belepesi oldalon vagyok")
    public void aBelepesiOldalonVagyok() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.oldalMegnyito();
        screenshootFileName = "BelepesiOldal";
    }

    @And("cookie-k el vannak fogadva")
    public void cookiekElVannakFogadva() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.cookieElfogado();
        screenshootFileName = "CookieElfogadva";
    }

    @When("Megadom emailCim {string} es jelszo {string}")
    public void megadomEmailCimEsJelszo(String emailCim, String jelszo) {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.belepes(emailCim, jelszo);
        screenshootFileName = "EmailEsJelszoMegadva";
    }

    @Then("A rendszer beleptetet a fiokomba")
    public void aRendszerBeleptetetAFiokomba() {
        VasarlasKezdoOldal vasarlasKezdoOldal = new VasarlasKezdoOldal(driver);
        vasarlasKezdoOldal.belepesSikeres();
        screenshootFileName = "BelepveFiokba";
    }

    @Then("A rendszer {string} hibauzenetet ad")
    public void aRendszerHibauzenetetAd(String elvartHibauzi) {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        if (elvartHibauzi.contains("Sajnos")) {
            belepesiOldal.hibauzenetEllenorzesHibasEmailJelszo(elvartHibauzi);
        }
        if (elvartHibauzi.contains("adj meg egy")) {
            belepesiOldal.hibauzenetEllenorzesHianyzoEmail(elvartHibauzi);
        }
        screenshootFileName = "oladlonHibauzenet";
    }

    @And("a belepesi adatok megadasanal maradok")
    public void aBelepesiAdatokMegadasanalMaradok() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.belepesOldalEllenorzes();
        screenshootFileName = "BelepesiOldalnalMarad";
    }

    @Given("A belepes utani nyito oldalon vagyok")
    public void aBelepesUtaniNyitoOldalonVagyok(String emailCim, String jelszo) {
       VasarlasKezdoOldal vasarlasKezdoOldal = new VasarlasKezdoOldal(driver);
       vasarlasKezdoOldal.belepesSikeres();
       //
        aBelepesiOldalonVagyok();
        cookiekElVannakFogadva();
        megadomEmailCimEsJelszo(emailCim, jelszo);
        //  ???????????????????????????????????????
        aRendszerBeleptetetAFiokomba();
        screenshootFileName = "BelepveFiokba2";
    }

    @When("A keresoben megadom {string} termeknev")
    public void aKeresobenMegadomTermeknev(String keresendo) {
        VasarlasKezdoOldal vasarlasKezdoOldal = new VasarlasKezdoOldal(driver);
        vasarlasKezdoOldal.kereses(keresendo);


        screenshootFileName = "KeresokiefejezesMegadva";
    }

    @Then("Megjelenik a talalati lista")
    public void megjelenikATalalatiLista() {
        KeresesiEredmenyOldal keresesiEredmenyOldal= new KeresesiEredmenyOldal(driver);
        keresesiEredmenyOldal.keresesSikeres();

        screenshootFileName = "TalalatiLista";
    }

    @Then("Megjelenik nem letezo termeknev uzenet")
    public void megjelenikNemLetezoTermeknevUzenet() {


        screenshootFileName = "UresTalalatiLista";
    }
}
