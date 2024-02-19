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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (3)\\chromedriver-win32\\chromedriver.exe");
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

        //Assert.assertEquals(actualCount,3,"header count dsnt match");
        Assert.assertTrue(homePage.play().isDisplayed(),"play btn dsnt display");
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
        homePage.home().click();
        homePage.popular().click();
        homePage.home().click();
        homePage.profile().click();
        homePage.home().click();
        homePage.searching().click();
        homePage.home().click();
    }

    @Then("Should display contact section in bottom")
    public void contactSection(){
        Assert.assertEquals(homePage.contactText(),"Contact Us","contact section text is not match");
        Assert.assertEquals(homePage.contactIcon(),4,"count doesn't match");
    }




}
