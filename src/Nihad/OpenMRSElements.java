package Nihad;


import Nihad.Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMRSElements {

    public OpenMRSElements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//li[text()='Inpatient Ward']")
    public WebElement location;

    @FindBy(xpath = "//input[@id='loginButton']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='navbarSupportedContent']/ul/li[1]")
    public WebElement profileIcon;

    @FindBy(xpath = "//ul[@id='user-account-menu']/li/a")
    public WebElement myAccount;

    @FindBy(xpath = "(//div[@id='tasks']/a)[1]")
    public WebElement changePassword;

    @FindBy(xpath = "(//div[@id='tasks']/a)[2]")
    public WebElement myLanguages;

    @FindBy(xpath = "(//div[@class='col-12 col-sm-12 col-md-12 col-lg-12 homeList']/a)[1]")
    public WebElement findPatientRecord;

    @FindBy(xpath = "//form[@id='patient-search-form']/input")
    public WebElement searchInput;

    @FindBy(xpath = "(//tr[@class='odd']/td)[1]")
    public WebElement foundPatient;

    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    public WebElement patientName;

}
