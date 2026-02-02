package Nihad;

import Nihad.Utility.Tools;
import org.openqa.selenium.WebDriver;

public class LoginOpenMRS{

    public void Login(String username, String password, WebDriver driver){
        OpenMRSElements elements = new OpenMRSElements();

        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        elements.usernameInput.sendKeys(username);
        Tools.Wait(2);
        elements.passwordInput.sendKeys(password);
        Tools.Wait(2);

        elements.location.click();
        Tools.Wait(2);
        elements.loginButton.click();


    }

}
