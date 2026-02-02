package Aysu.Utility;


import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.awt.*;
import java.time.Duration;

public class Basedriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Bashlangic() throws InterruptedException, AWTException {


        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        Login();
    }

    @AfterClass
    public void Baglanish() {
        Tools.Wait(3);
        driver.quit();

    }

    public void Login() throws AWTException, InterruptedException {
        driver.navigate().to("https://o2.openmrs.org/openmrs/login.htm");


    }

}
