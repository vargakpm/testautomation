package hu.masterfield;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @BeforeAll
    public static void setup() throws IOException {
        WebDriverManager.chromedriver().setup();

        Properties props = new Properties();  // Java util
        InputStream is = BaseTest.class.getResourceAsStream("/browser.properties");
        props.load(is);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(props.getProperty("chrome.arguments"));
        //chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @AfterAll
    public static void cleanup() {
        driver.quit();  // drivek-t kilövi, a böngésző ablakot bezárja
    }


}
