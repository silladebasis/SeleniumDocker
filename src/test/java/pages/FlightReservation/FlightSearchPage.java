package pages.FlightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement selPassenger;
    @FindBy(id = "search-flights")
    private WebElement searchFlightsBtn;
    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(searchFlightsBtn));
        return searchFlightsBtn.isDisplayed();
    }
    public void selectPassenger(String numOfPassenger){
        Select select = new Select(selPassenger);
        select.selectByValue(numOfPassenger);
    }
    public void clickOnSearchFlights(){
        searchFlightsBtn.click();
    }
}
