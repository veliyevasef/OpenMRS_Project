package Nihad;

import Nihad.Utility.BaseDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_505_MyAccounts_POM extends BaseDriver {

    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void MyAccounts(String username,String password){
        BaseDriver.logAdd.info("US_505 Testi basladi.");
        OpenMRSElements elements = new OpenMRSElements();
        LoginOpenMRS login = new LoginOpenMRS();
        login.Login(username,password,driver);

        wait.until(ExpectedConditions.elementToBeClickable(elements.profileIcon));
        new Actions(driver).moveToElement(elements.profileIcon).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(elements.myAccount));
        elements.myAccount.click();

        Assert.assertTrue(elements.changePassword.isDisplayed() && elements.changePassword.isEnabled());
        Assert.assertTrue(elements.myLanguages.isDisplayed() && elements.myLanguages.isEnabled());
        BaseDriver.logAdd.info("US_505 Testi yekunlasdi.");
    }
}
