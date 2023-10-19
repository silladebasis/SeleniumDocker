package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id="go-to-flights-search")
    private WebElement flightSearchBtn;
    @FindBy(css = "#registration-confirmation-section p.mt-3")
    private WebElement firstNameElement;
    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(flightSearchBtn));
        return flightSearchBtn.isDisplayed();
    }
    public String getFirstNameText(){
        return firstNameElement.getText();
    }
    public void clickOnFlightSearch(){
        flightSearchBtn.click();
    }
}
