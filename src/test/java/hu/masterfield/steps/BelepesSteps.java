package hu.masterfield.steps;

import hu.masterfield.pages.BelepesiOldal;
import hu.masterfield.pages.VasarlasKezdoOldal;
import io.cucumber.java.After;
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

public class BelepesSteps {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public static Logger log = LogManager.getLogger();

    @Before // cucumber annotáció
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();

        // loading arguments, properties
        Properties props = new Properties(); // java.util
        InputStream is = BelepesSteps.class.getResourceAsStream("/browser.properties");
        props.load(is);

        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @After
    public static void cleanup() {
        driver.quit();
    }



// *******************************************************************

    @Given("A belepesi oldalon vagyok")
    public void aBelepesiOldalonVagyok() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.oldalMegnyito();
    }

    @And("cookie-k el vannak fogadva")
    public void cookiekElVannakFogadva() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.cookieElfogado();
    }

    @When("Megadom emailCim {string} es jelszo {string}")
    public void megadomEmailCimEsJelszo(String emailCim, String jelszo) {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.belepes("vargakpm@freemail.hu","Tesco0000");
    }

    @Then("A rendszer beleptetet a fiokomba")
    public void aRendszerBeleptetetAFiokomba() {
        VasarlasKezdoOldal vasarlasKezdoOldal = new VasarlasKezdoOldal(driver);
        vasarlasKezdoOldal.belepesSikeres();
    }

    @Then("A rendszer {string} hibauzenetet ad")
    public void aRendszerHibauzenetetAd(String arg0) {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
    }

    @And("a belepesi adatok megadasanal maradok")
    public void aBelepesiAdatokMegadasanalMaradok() {
        BelepesiOldal belepesiOldal = new BelepesiOldal(driver);
        belepesiOldal.belepesOldalEllenorzes();
    }


}
