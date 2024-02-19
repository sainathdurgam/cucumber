import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import stepdefinitions.*;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    PopularPage popularPage;
    SearchPage searchPage;


    @Before
    public void setUp(){
        //C:\Users\HP\Downloads\chromedriver-win32 (3)\chromedriver-win32
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (3)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("am on Home pagee")
    public void searchPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);

        popularPage= new PopularPage(driver);
        searchPage= new SearchPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }



    @When("Should display the search icon in header Section and click search icon")
    public void searchIconHeaderSectionF(){
        Assert.assertTrue(searchPage.search().isDisplayed(),"search icon should not display");
        searchPage.search().click();
    }
    @And("After clicking search icon Search Input Box should display and Ok button should display")
    public void inputBoxAndOk(){
        Assert.assertTrue(searchPage.input().isDisplayed(),"searchInput should not display");
        Assert.assertTrue(searchPage.ok().isDisplayed(),"ok button not dsiplay");

    }
    @Then("user enter valid movie name in searchInput and clicking ok button movies should display")
    public void enterMovieValidName(){
        searchPage.input().clear();
        searchPage.input().sendKeys("Titanic");
        searchPage.ok().click();
        Assert.assertTrue(searchPage.result().isDisplayed(),"resulted movies will not display");
    }

    @Then("user enter Invalid movie name in serachInput and clikcing ok button error message should display")
    public void invalidName(){
        searchPage.input().clear();
        searchPage.input().sendKeys("jhdjkldhjksdhjh");
        searchPage.ok().click();
        Assert.assertTrue(searchPage.error().isDisplayed(),"error messags not dsiplay");
    }




}
