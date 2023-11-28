import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import pages.*;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Iam on popular page")
    public void popularPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);
        popularPage= new PopularPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
        homePage.popular().click();
    }

    @Then("i will able see movies")
    public void popularUi(){
        Assert.assertEquals(popularPage.moviesContainer(),30,"movies dsnt display");
    }
}
