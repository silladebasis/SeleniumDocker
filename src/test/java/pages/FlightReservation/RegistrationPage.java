package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class RegistrationPage extends AbstractPage {
    @FindBy(id = "firstName")
    private WebElement txtFirstName;
    @FindBy(id = "lastName")
    private WebElement txtLastName;
    @FindBy(id = "email")
    private WebElement txtEmail;
    @FindBy(id = "password")
    private WebElement txtPassword;
    @FindBy(name = "street")
    private WebElement txtStreet;
    @FindBy(name = "city")
    private WebElement txtCity;
    @FindBy(name = "zip")
    private WebElement txtZip;
    @FindBy(id = "register-btn")
    private WebElement registerBtn;

    public RegistrationPage(WebDriver driver){
        super(driver);

    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(registerBtn));
        return registerBtn.isDisplayed();
    }
    public void navigateToApplication(String url){
        driver.get(url);
    }
    public RegistrationPage enterUserDetails(String firstName, String lastName){
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        return this;
    }
    public RegistrationPage enterCredentials(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        return this;
    }
    public RegistrationPage enterAddress(String street, String city, String zipcode){
        txtStreet.sendKeys(street);
        txtCity.sendKeys(city);
        txtZip.sendKeys(zipcode);
        return this;
    }
    public RegistrationPage clickOnRegister(){
        registerBtn.click();
        return this;
    }

}
