package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AbstractPage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {
    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;
    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;
    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightBtn;
    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(confirmFlightBtn));
        return confirmFlightBtn.isDisplayed();
    }
    public void selectFlights(){
        int random = ThreadLocalRandom.current().nextInt(0,departureFlightsOptions.size());
        departureFlightsOptions.get(random).click();
        arrivalFlightsOptions.get(random).click();
    }
    public void clickOnConfirmFlight(){
        confirmFlightBtn.click();
    }
}
