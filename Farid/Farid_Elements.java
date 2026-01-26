package Farid;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Farid_Elements {
    public Farid_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "Inpatient Ward")
    public WebElement location;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;

    @FindBy(css = "h4")
    public WebElement msg;

    @FindBy(linkText = "Logout")
    public WebElement logoutBtn;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    public WebElement registerPatientBtn;

    @FindBy(name = "givenName")
    public WebElement firstName;

    @FindBy(name = "familyName")
    public WebElement lastName;

    @FindBy(id = "next-button")
    public WebElement nextBtn;

    @FindBy(id = "gender-field")
    public WebElement genderSelect;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    public WebElement birthMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement birthYear;

    @FindBy(id = "submit")
    public WebElement confirmBtn;

    @FindBy(className = "given_name")
    public WebElement registeredName;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "cityVillage")
    public WebElement city;

    @FindBy(id = "stateProvince")
    public WebElement state;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "postalCode")
    public WebElement postalCode;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;
}