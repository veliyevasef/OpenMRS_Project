package Asef;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delete_Patient_Elements {
    public Delete_Patient_Elements() {

        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(id="username")
    public WebElement username;
//
    @FindBy(id="password")
    public WebElement password;


    @FindBy(id="Inpatient Ward")
    public WebElement location;

    @FindBy(id="loginButton")
    public WebElement loginBtn;

    @FindBy(xpath="//div[@class='col-12 col-sm-12 col-md-12 col-lg-12']/h4")
    public WebElement msg;

    @FindBy(xpath="//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
    public WebElement findPatient;

    @FindBy(xpath="//tbody[@aria-relevant='all']")
    public WebElement table;

    @FindBy(xpath="//input[@id='patient-search']")
    public WebElement searchBox;

    @FindBy(xpath="(//tbody[@aria-relevant='all']/tr/td)[1]")
    public WebElement raw1;

    @FindBy(xpath="//*[@id='org.openmrs.module.coreapps.deletePatient']/div/div[2]")
    public WebElement DeletePatient;

    @FindBy(xpath="//input[@id='delete-reason']")
    public WebElement inputReason;

    @FindBy(xpath="//*[@id='delete-patient-creation-dialog']/div[2]/button[@class='confirm right']")
    public WebElement confirmBtn;


    @FindBy(xpath = "//*[text()='No matching records found']")
    public WebElement assertDeletedPatient;




}
