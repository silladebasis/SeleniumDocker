package Tests.flightreservation;

import Tests.AbstractTest;
import Tests.flightreservation.datamodel.FlightReservationTestData;
import Tests.vendorportal.datamodel.VendorPortalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FlightReservation.*;
import utils.JsonUtil;

import java.io.IOException;

public class FlightReservationsTest extends AbstractTest {
    RegistrationPage registrationPage;
    RegistrationConfirmationPage registrationConfirmationPage;
    FlightSearchPage flightSearchPage;
    FlightSelectionPage flightSelectionPage;
    FlightConfirmationPage flightConfirmationPage;
    private String testDataPath = System.getProperty("user.dir")+"/src/test/resources/test-data/FlightReservation/testdata.json";
    private FlightReservationTestData testData = JsonUtil.getTestData(testDataPath, FlightReservationTestData.class);

    public FlightReservationsTest() throws IOException {
    }

    @Test
    public void userRegistrationTest(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToApplication("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.waitForPageToLoad());
        registrationPage.enterUserDetails(testData.firstName(),testData.lastName()).
                enterCredentials(testData.email(),testData.password()).
                enterAddress(testData.street(),testData.city(),testData.zipcode()).
                clickOnRegister();
    }
    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest(){
        registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.waitForPageToLoad());
        Assert.assertTrue(registrationConfirmationPage.getFirstNameText().contains(testData.firstName()));
        registrationConfirmationPage.clickOnFlightSearch();
    }
    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.waitForPageToLoad());
        flightSearchPage.selectPassenger(testData.passengerCount());
        flightSearchPage.clickOnSearchFlights();
    }
    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest(){
        flightSelectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.waitForPageToLoad());
        flightSelectionPage.selectFlights();
        flightSelectionPage.clickOnConfirmFlight();
    }
    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightConfirmationTest(){
        flightConfirmationPage = new FlightConfirmationPage(driver);
        Assert.assertTrue(flightConfirmationPage.waitForPageToLoad());
        Assert.assertEquals(flightConfirmationPage.getTotalPrice(),testData.expectedPrice());
    }
}
