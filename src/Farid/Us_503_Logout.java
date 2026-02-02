package Farid;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Objects;

public class Us_503_Logout extends BaseDriver {

    @DataProvider
    Object [][] ValidData() {
        return new Object[][]{ {"admin", "Admin123"} };
    }

    @Test(dataProvider = "ValidData")
    public void testLogout(String user, String pass) {
        Farid_Elements elements = new Farid_Elements();

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys(user);
        elements.password.sendKeys(pass);
        elements.location.click();
        elements.loginBtn.click();
        logAdd.info("Sistemə giriş edildi.");

        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.logoutBtn))).click();
        logAdd.info("Logout düyməsi klikləndi.");

        wait.until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Çıxış uğursuz oldu!");
        logAdd.info("Sistemdən uğurla çıxıldı.");
    }
}