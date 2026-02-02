package Aysu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Aysu.Utility.Basedriver.driver;

public class US_501 {
    public US_501() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath="//*[@id='loginButton']")
    public WebElement loginbtn;

    @FindBy(xpath="//*[@id='Inpatient Ward']")
    public WebElement inpatientward;

    @FindBy(xpath="//*[@id='Isolation Ward']")
    public WebElement isolationward;

    @FindBy(xpath="//*[@id='Laboratory']")
    public WebElement laboratory;

    @FindBy(xpath = "//*[@id='Outpatient Clinic']")
    public WebElement outpatientclinic;

    @FindBy(xpath="//*[@id='Pharmacy']")
    public WebElement pharmacy;

    @FindBy(xpath="//*[@id='Registration Desk']")
    public WebElement registrationdesk;

    @FindBy(xpath = "//*[@class='nav-item logout']")
    public WebElement logoutbtn;

    @FindBy(xpath = "//*[@id='error-message']")
    public WebElement errormessage;

}

