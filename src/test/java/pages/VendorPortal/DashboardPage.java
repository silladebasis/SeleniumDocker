package pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AbstractPage;

public class DashboardPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);
    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarning;
    @FindBy(id = "annual-earning")
    private WebElement annualEarning;
    @FindBy(id = "profit-margin")
    private WebElement profitMargin;
    @FindBy(id = "available-inventory")
    private WebElement availableInventory;
    @FindBy(css = "input[type='search']")
    private WebElement searchInput;
    @FindBy(id = "dataTable_info")
    private WebElement searchResults;
    @FindBy(css = "#userDropdown img.img-profile")
    private WebElement userProfileLink;
    @FindBy(linkText = "Logout")
    private WebElement logOutLink;
    @FindBy(css = "#logoutModal a")
    private WebElement modalLogoutBtn;
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public boolean waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(monthlyEarning));
        return monthlyEarning.isDisplayed();
    }
    public String getMonthlyEarning(){
        return monthlyEarning.getText();
    }
    public String getAnnualEarning(){
        return annualEarning.getText();
    }
    public String getProfitMargin(){
        return profitMargin.getText();
    }
    public String getAvailableInventory(){
        return availableInventory.getText();
    }
    public void searchOrderHistory(String text){
        searchInput.sendKeys(text);
    }
    public int getSearchResultsCount(){
        String [] arr = searchResults.getText().split(" ");
        int resultCount = Integer.parseInt(arr[5]);
        log.info("Result count : {}",resultCount);
        return resultCount;
    }
    public void logout(){
        userProfileLink.click();
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        logOutLink.click();
        wait.until(ExpectedConditions.visibilityOf(modalLogoutBtn));
        modalLogoutBtn.click();
    }

}
