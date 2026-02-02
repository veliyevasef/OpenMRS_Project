package Farid;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Objects;

public class Us_504_registration extends BaseDriver {

    @Test
    public void testRegistration() {
        Farid_Elements elements = new Farid_Elements();

        driver.get("https://o2.openmrs.org/");

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.username))).sendKeys("admin");
        elements.password.sendKeys("Admin123");
        elements.location.click();
        elements.loginBtn.click();

        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.registerPatientBtn))).click();

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.firstName))).sendKeys("Random");
        elements.lastName.sendKeys("Random");
        elements.nextBtn.click();

        new Select(Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.genderSelect)))).selectByVisibleText("Male");
        elements.nextBtn.click();

        elements.birthDay.sendKeys("15");
        new Select(elements.birthMonth).selectByVisibleText("May");
        elements.birthYear.sendKeys("1995");
        elements.nextBtn.click();

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.address1))).sendKeys("Nizami str. 10");
        elements.city.sendKeys("Baku");
        elements.state.sendKeys("Absheron");
        elements.country.sendKeys("Azerbaijan");
        elements.postalCode.sendKeys("AZ1000");
        elements.nextBtn.click();

        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOf(elements.phoneNumber))).sendKeys("+994501234567");
        elements.nextBtn.click();

        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.nextBtn))).click();

        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(elements.confirmBtn))).click();

        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("patientId")), "Xeste yaradilmadi!");
        Assert.assertTrue(elements.registeredName.getText().contains("Farid"), "Ad tapilmadi!");
    }
}