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

public class HomePageTest {

    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("am on Home page")
    public void home(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }


    @Then("i can view Home page with all elements")
    public void homepage(){

        Assert.assertEquals(homePage.trendingHeading().getText(),"Trending Now","trending heading not match");
        Assert.assertEquals(homePage.orginalHeading().getText(),"Originals","original heading not match");
       /*for (int i=0;i<2;i++){
            Assert.assertTrue(homePage.moviez(i).isDisplayed(),"movies not displayed");
        }*/
       // Assert.assertTrue(homePage.movieScreen().isDisplayed(),"screen is not displayed");
        //Assert.assertTrue(homePage.moviePara().isDisplayed(),"movie para is not displayed");
        //Assert.assertEquals(actualCount,3,"header count dsnt match");
        Assert.assertTrue(homePage.play().isDisplayed(),"play btn does not display");
        Assert.assertTrue(homePage.footer().isDisplayed(),"footer dnt displayed");
        Assert.assertEquals(homePage.headCount(),3,"count dst match");
        Assert.assertTrue(homePage.moviesDisplay().isDisplayed(),"movies not display");
        Assert.assertEquals(homePage.movesInt(),20,"movies count dsnt matched");
       //String[] arr = {"A Few Good Men","Trending Now","Originals"};


       for (int i=0;i<homePage.headCount();i++){
           Assert.assertTrue(homePage.headDisplay( i).isDisplayed(),"heading not match");
       }
    }

    @Then("header section Ui display as this")
    public void headerSectionUi(){
        Assert.assertTrue(homePage.web().isDisplayed(),"logo dsnt display inside");
        Assert.assertTrue(homePage.home().isDisplayed(),"home anchor dsnt");
        Assert.assertTrue(homePage.popular().isDisplayed(),"popular dsnt display");
        Assert.assertTrue(homePage.profile().isDisplayed(),"profile dsnt dislpay");
        Assert.assertTrue(homePage.searching().isDisplayed(), "search icon dsnt display");
    }


    @And("Clicking navbar Links")
    public void headerSection(){
        //homePage.home().click();


        homePage.popular().click();
        String expectedUrlP = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrlP));

        String actualURLP = driver.getCurrentUrl();
        Assert.assertEquals(actualURLP, expectedUrlP, "Popular URLs do not match");

        //homePage.home().click();


        homePage.profile().click();
        String expectedUrlProfile = "https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.urlToBe(expectedUrlProfile));

        String actualURLProfile = driver.getCurrentUrl();
        Assert.assertEquals(actualURLProfile, expectedUrlProfile, "Profile URLs do not match");
        //homePage.home().click();


        homePage.searching().click();
        String expectedUrls = "https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait3.until(ExpectedConditions.urlToBe(expectedUrls));

        String actualURLs = driver.getCurrentUrl();
        Assert.assertEquals(actualURLs, expectedUrls, "search URLs do not match");


        homePage.home().click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait4.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "home URLs do not match");
    }

    @Then("Should display contact section in bottom")
    public void contactSection(){
        Assert.assertEquals(homePage.contactText(),"Contact Us","contact section text is not match");
        Assert.assertEquals(homePage.contactIcon(),4,"count doesn't match");
    }




}
