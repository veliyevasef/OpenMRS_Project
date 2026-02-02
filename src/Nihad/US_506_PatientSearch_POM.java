package Nihad;

import Nihad.Utility.BaseDriver;
import Nihad.Utility.Tools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_506_PatientSearch_POM extends BaseDriver {

    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void SearchPatientByID(String username,String password){
        BaseDriver.logAdd.info("US_506 Testi (ID'ye gore axtarma) basladi.");
        OpenMRSElements elements = new OpenMRSElements();
        LoginOpenMRS login = new LoginOpenMRS();
        login.Login(username,password,driver);

        wait.until(ExpectedConditions.elementToBeClickable(elements.findPatientRecord));
        elements.findPatientRecord.click();

        wait.until(ExpectedConditions.visibilityOf(elements.searchInput));
        elements.searchInput.sendKeys("1000YY");

        wait.until(ExpectedConditions.visibilityOf(elements.foundPatient));
        elements.foundPatient.click();
        Tools.Wait(3);

        wait.until(ExpectedConditions.visibilityOf(elements.patientName));
        Assert.assertTrue(elements.patientName.getText().contains("Robert"));


        BaseDriver.logAdd.info("US_505 Testi yekunlasdi.");
    }
    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void SearchPatientByName(String username,String password){
        BaseDriver.logAdd.info("US_506 Testi (ada gore axtarma) basladi.");
        OpenMRSElements elements = new OpenMRSElements();
        LoginOpenMRS login = new LoginOpenMRS();
        login.Login(username,password,driver);

        wait.until(ExpectedConditions.elementToBeClickable(elements.findPatientRecord));
        elements.findPatientRecord.click();
        Tools.Wait(3);
        wait.until(ExpectedConditions.visibilityOf(elements.searchInput));
        elements.searchInput.sendKeys("Robert Thomas");

        wait.until(ExpectedConditions.visibilityOf(elements.foundPatient));
        elements.foundPatient.click();
        Tools.Wait(3);

        wait.until(ExpectedConditions.visibilityOf(elements.patientName));
        Assert.assertTrue(elements.patientName.getText().contains("Robert"));
        BaseDriver.logAdd.info("US_505 Testi yekunlasdi.");
    }
}
