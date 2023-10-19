package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AbstractPage;

public class FlightConfirmationPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
    @FindBy(css = ".card-body div:nth-child(1) p")
    private WebElement  flightConfirmationNumber;
    @FindBy(css = ".card-body div:nth-child(3) p")
    private WebElement  totalPrice;
    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return totalPrice.isDisplayed();
    }
    public String getTotalPrice(){
        String price = totalPrice.getText();
        log.info("total price is : {}",price);
        return price;
    }
    public String getFlightConfirmationNumber(){
        String confirmationNumber =  flightConfirmationNumber.getText();
        log.info("confirmation number is : {}",confirmationNumber);
        return confirmationNumber;
    }
}
