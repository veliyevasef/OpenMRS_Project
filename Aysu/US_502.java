package Aysu;

import Aysu.Utility.Basedriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class US_502 extends Basedriver {
    US_501 elements;

    @Test(dataProvider = "loginLocation")
    void test502(String user, String passw, String location) {
        elements = new US_501();
        elements.username.clear();
        elements.password.clear();
        elements.username.sendKeys(user);
        elements.password.sendKeys(passw);


        switch (location) {
            case "inpatientw":
                elements.inpatientward.click();
                break;
            case "isolationw":
                elements.isolationward.click();
                break;
            case "labor":
                elements.laboratory.click();
                break;
            case "outpatientw":
                elements.outpatientclinic.click();
                break;
            case "pharmcy":
                elements.pharmacy.click();
                break;
            case "registrationd":
                elements.registrationdesk.click();
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
    }
}

