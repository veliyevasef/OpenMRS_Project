package Aysu;


import Aysu.Utility.Basedriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_501_POM extends Basedriver {
    US_501 elements;

    @Test(dataProvider = "login")
    void test501(String user, String passw, String location) {
        elements = new US_501();

        elements.username.clear();
        elements.password.clear();
        elements.loginbtn.click();

        if (user != null) {
            elements.username.sendKeys(user);
        }
        if (passw != null) {
            elements.password.sendKeys(passw);

        }
        switch (location) {
            case "inpatientw":
                elements.inpatientward.sendKeys(location);
                break;
            case "isolationw":
                elements.isolationward.sendKeys(location);
                break;
            case "labor":
                elements.laboratory.sendKeys(location);
                break;
        }
        elements.loginbtn.click();


        String actualUrl = "https://o2.openmrs.org/openmrs/referenceapplication/login.page";
        String expectedUrl = driver.getCurrentUrl().toString();
        Assert.assertTrue(actualUrl.equals(expectedUrl), "ugurla login edildi");
    } //url-ni eyni verdiyim ucun eger actual ile expected beraber olarsa demeli login ugurlu olub ve url deyisib ona gore assert mesaji normaldan fergli yaziram
    //nezere alsaq ki negative testdir login olmasi failed hesab olunur


    @DataProvider
    Object[][] login() {
        return new Object[][]{
                {"", "Admin123", "isolationw"},       //yanlis //login olmur  //passed verilmelidi
                {"admin", "", "isolationw"},          //yanlis  //login olmur  //passed
                {"", "", ""},                         //yanlis  //login olmur  //passed
                {"admin", "abc", "inpatientw"},       //yanlis  //login olmur  //passed
                {"user", "Admin123", "isolationw"},   //yanlis  //login olmur  //passed
                {"user", "123", "inpatientw"},        //yanlis  //login olmur  //passed
                {"admin", "Admin123", "isolationw"},  //dogru  //login olur  //failed
        };


    }



    }


