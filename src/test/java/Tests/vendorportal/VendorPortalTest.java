package Tests.vendorportal;

import Tests.AbstractTest;
import Tests.vendorportal.datamodel.VendorPortalTestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.VendorPortal.DashboardPage;
import pages.VendorPortal.LoginPage;
import utils.JsonUtil;

import java.io.IOException;

public class VendorPortalTest extends AbstractTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    private String testDataPath = System.getProperty("user.dir")+"/src/test/resources/test-data/VendorPortal/data.json";
    private VendorPortalTestData testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);

    public VendorPortalTest() throws IOException {
    }

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.navigateToApp("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.waitForPageToLoad());
        loginPage.loginToApp(testData.username(),testData.password());
    }
    @Test(dependsOnMethods = "loginTest")
    public void dashBoardTest(){
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.waitForPageToLoad());

        Assert.assertEquals(dashboardPage.getMonthlyEarning(),testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(),testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(),testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(),testData.availableInventory());

        dashboardPage.searchOrderHistory("adams");
        Assert.assertEquals(dashboardPage.getSearchResultsCount(),testData.searchResultsCount());

    }
    @Test(dependsOnMethods = "dashBoardTest")
    public void logOutTest(){
        dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();
        Assert.assertTrue(loginPage.waitForPageToLoad());
    }

}
