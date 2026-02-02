package Aysu;

import Aysu.Utility.Basedriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class US_502 extends Basedriver {
    US_501 elements;

    @Test(dataProvider = "loginLocation")
    void test502(String user,String passw,String location) {
        elements = new US_501();
        elements.username.clear();
        elements.password.clear();

        if(user!=null) {
            elements.username.sendKeys(user);
        }if(passw!=null) {
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
            case "outpatientw":
                elements.outpatientclinic.sendKeys(location);
                break;
            case "pharmcy":
                elements.pharmacy.sendKeys(location);
                break;
            case "registrationd":
                elements.registrationdesk.sendKeys(location);
                break;
        }

        elements.loginbtn.click();
    }

    @DataProvider
    Object[][] loginLocation() {
        return new Object[][]{
                {"admin", "Admin123", "inpatientw"},
                {"admin", "Admin123", "isolationw"},
                {"admin", "Admin123", "labor"},
                {"admin", "Admin123", "outpatientw"},
                {"admin", "Admin123", "pharmcy"},
                {"admin", "Admin123", "resgistrationd"},
        };
    }




@AfterMethod
void logout() {
    try {
        elements.logoutbtn.click();
    } catch (Exception e) {

    }
}}

