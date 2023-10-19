package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AbstractTest {
    protected WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
