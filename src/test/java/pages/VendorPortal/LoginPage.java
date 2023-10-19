package pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class LoginPage extends AbstractPage {
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login")
    private WebElement loginBtn;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        return loginBtn.isDisplayed();
    }
    public void navigateToApp(String url){
        driver.get(url);
    }
    public void loginToApp(String username,String pass){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginBtn.click();
    }
}
