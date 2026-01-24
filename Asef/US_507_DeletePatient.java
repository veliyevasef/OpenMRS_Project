package Asef;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US_507_DeletePatient extends BaseDriver {

    @Test
    public void DeletePatient(){
        driver.get("https://o2.openmrs.org/openmrs/login.htm");

        WebElement username= driver.findElement(By.id("username"));
        username.clear();
        username.sendKeys("admin");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Admin123");
        WebElement location= driver.findElement(By.id("Inpatient Ward"));
        location.click();

        WebElement loginBtn=driver.findElement(By.id("loginButton"));
        loginBtn.click();
        WebElement msg=driver.findElement(By.xpath(
                "//div[@class='col-12 col-sm-12 col-md-12 col-lg-12']/h4"));
        Assert.assertEquals(msg.getText(),
                "Logged in as Super User (admin) at Inpatient Ward.","Eyni deyil");


        WebElement findPatient=driver.findElement(By.xpath
                ("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']"));
        findPatient.click();

        List<WebElement> table=driver.findElements(By.xpath("//tbody[@aria-relevant='all']"));
        for(WebElement e : table){
            System.out.println(e.getText());
        }
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='patient-search']"));
        searchBox.clear();
        searchBox.sendKeys("Jo");
        Tools.Wait(2);
        WebElement raw1=driver.findElement(By.xpath(
                "(//tbody[@aria-relevant='all']/tr/td)[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(raw1));
        raw1.click();

        WebElement DeletePatient=driver.findElement(By.xpath(
                "//*[@id='org.openmrs.module.coreapps.deletePatient']/div/div[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(DeletePatient));

        DeletePatient.click();
        Tools.Wait(2);
        WebElement inputReason=driver.findElement(By.xpath("//input[@id='delete-reason']"));
        wait.until(ExpectedConditions.visibilityOf(inputReason));
        inputReason.sendKeys("Just Delete");

        WebElement confirmBtn=driver.findElement(By.xpath(
                "//*[@id='delete-patient-creation-dialog']/div[2]/button[@class='confirm right']"));
        confirmBtn.click();

        WebElement assertDeletedPatient=driver.findElement(By.xpath("//*[text()='No matching records found']"));
        wait.until(ExpectedConditions.visibilityOf(assertDeletedPatient));
        System.out.println(assertDeletedPatient.getText());

        //Assert.assertEquals(assertDeletedPatient.getText(),"No matching records found","Eyni deyil");






    }
}
