package Nihad.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Logger logAdd = LogManager.getLogger();
    @BeforeClass
    public void Bashlangic() {
        logAdd.info("Loglama bashladildi");
        driver = new ChromeDriver();
        logAdd.info("Driver bashladildi");

        driver.manage().window().maximize(); // Ekrani max et
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterClass
    public void Baglanish() {
        if (driver != null) {
            Tools.Wait(3);
            driver.quit();
            logAdd.info("Browserden chixish edildi");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            logAdd.info("Driver bashladildi");
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logAdd.info("Browserden chixish edildi");
            driver = null;
        }
    }

}
