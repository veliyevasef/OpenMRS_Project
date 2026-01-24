package Asef;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class US_507_DeletePatient_POM extends BaseDriver {

   @Test
           public void DeletePatient(){
       Delete_Patient_Elements elements=new Delete_Patient_Elements();
       driver.get("https://o2.openmrs.org/openmrs/login.htm");

       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys("admin");
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.password))).sendKeys("Admin123");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.location))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.loginBtn))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.msg))).getText();
       Assert.assertEquals(elements.msg.getText(),
               "Logged in as Super User (admin) at Inpatient Ward.","Title eyni deyil");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.findPatient))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.table))).getText();
       System.out.println(elements.table.getText());
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys("Jo");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).getText();
       String xeste= elements.raw1.getText().substring(0,6);
       System.out.println(xeste);
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.raw1))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.DeletePatient))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.inputReason))).sendKeys("Just Delete");
       Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.confirmBtn))).click();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).clear();
       Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.searchBox))).sendKeys(xeste);
       wait.until(ExpectedConditions.visibilityOf(elements.assertDeletedPatient));
       Assert.assertEquals(elements.assertDeletedPatient.getText(),"No matching records found","Eyni deyil");







   }

}
