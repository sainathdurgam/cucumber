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

import java.time.Duration;
import stepdefinitions.*;

public class MovieDetailsPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    MovieDetailsPage movieDetailsPage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (3)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Given("Iam on Home page")
    public void homePageMovie(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);
        popularPage= new PopularPage(driver);

        movieDetailsPage= new MovieDetailsPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }
    @When("clicking on movie")
    public void clickingOnMovie(){
        movieDetailsPage.homeImage().click();
    }

    @When("clicking on popular anchar")
    public void clickingOnPopularA(){
        movieDetailsPage.popularAnchor().click();
    }

    @And("clicking on popular movie")
    public void clickingOnPoplarMovie(){
        movieDetailsPage.popularImage().click();
    }

    @Then("movie details will display in movie page")
    public void displayMovieDetails(){
        Assert.assertTrue(movieDetailsPage.name().isDisplayed(),"name is dsnt display");
        Assert.assertTrue(movieDetailsPage.review().isDisplayed(),"review dsnt dsiplay");
        Assert.assertTrue(movieDetailsPage.para().isDisplayed(),"para dsnt display");
        Assert.assertTrue(movieDetailsPage.play().isDisplayed(),"play buttondsnt display");
        Assert.assertTrue(movieDetailsPage.logo().isDisplayed(),"movie logo not display");
        Assert.assertTrue(movieDetailsPage.homeA().isDisplayed(),"movie home anchor not display");
        Assert.assertTrue(movieDetailsPage.popularAnchor().isDisplayed(),"popular anchor not display");
        Assert.assertTrue(movieDetailsPage.searchIcon().isDisplayed(),"search icon not display");
        Assert.assertTrue(movieDetailsPage.profile().isDisplayed(),"profile not display");
        Assert.assertEquals(movieDetailsPage.contactText(),"Contact Us","contact section text is not match");
        Assert.assertEquals(movieDetailsPage.contactIcon(),4,"count doesnt match");
        Assert.assertEquals(movieDetailsPage.more(),"More like this","more head not match");
        Assert.assertTrue(movieDetailsPage.moviesList().isDisplayed(),"movies list not dsiplay");
        Assert.assertTrue(movieDetailsPage.genres().isDisplayed(),"genres not display");
        Assert.assertTrue(movieDetailsPage.audio().isDisplayed(),"audio container is not display");
        Assert.assertTrue(movieDetailsPage.rating().isDisplayed(),"rating container is not display");
        Assert.assertTrue(movieDetailsPage.budget().isDisplayed(),"budget is not display");
    }



}
