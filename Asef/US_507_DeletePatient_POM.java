package Asef;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.tools.Tool;
import java.util.Objects;

public class US_507_DeletePatient_POM extends BaseDriver {

    @DataProvider
    Object [][] ValidData() {
        Object[][] Datas = {
                {"admin", "Admin123"}
        };

        return Datas;
    }

   @Test(dataProvider = "ValidData")
           public void DeletePatient(String username,String password){
       Delete_Patient_Elements elements=new Delete_Patient_Elements();


       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys(username);
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.password))).sendKeys(password);
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.location))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.loginBtn))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.msg))).getText();
       Assert.assertEquals(elements.msg.getText(),
               "Logged in as Super User (admin) at Inpatient Ward.","Title eyni deyil");
       logAdd.info("User login oldu");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.findPatient))).click();

       Tools.Wait(3);
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys("Jo");
       logAdd.info("Axtarilan xeste melumati daxil edildi.");
       Tools.Wait(3);
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.table))).getText();
       System.out.println(elements.table.getText());
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).getText();
       String xeste= elements.raw1.getText().substring(0,6);
       System.out.println("Sechilmish Xestenin ID-i: "+xeste);
       Tools.Wait(3);

       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).click();
       logAdd.info("Xeste sechildi.");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.DeletePatient))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.inputReason))).sendKeys("Just Delete");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.confirmBtn))).click();
       logAdd.info("Sechilmish xeste silindi.");
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys(xeste);
       System.out.println("Silinen xestenin ID-i: "+xeste);
       wait.until(ExpectedConditions.visibilityOf(elements.assertDeletedPatient));
       Assert.assertEquals(elements.assertDeletedPatient.getText(),"No matching records found","Eyni deyil");







   }

}
