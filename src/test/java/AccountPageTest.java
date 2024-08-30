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


public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;

    MovieDetailsPage movieDetailsPage;
    AccountPage accountsPage;


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("Iam on homepage")
    public void homePage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage= new HomePage(driver);
        popularPage= new PopularPage(driver);

        movieDetailsPage= new MovieDetailsPage(driver);
        accountsPage = new AccountPage(driver);

        loginPage.loginToApplication("rahul", "rahul@2021");

        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }
    @When("click on account Icon")
    public void clickingOnProfileIcon(){
        accountsPage.profile().click();
    }
    @Then("see account details")
    public void accountDetails(){
        Assert.assertTrue(accountsPage.profile().isDisplayed(),"profile does not display");
        Assert.assertEquals(accountsPage.head(),"Account","account text not match");
        Assert.assertTrue(accountsPage.username().isDisplayed(),"account user does not display");
        Assert.assertTrue(accountsPage.password().isDisplayed(),"account pass dsnt display");
        Assert.assertTrue(accountsPage.premium().isDisplayed(),"accound premium dsnt display");
        Assert.assertTrue(accountsPage.movieLogo().isDisplayed(),"movie logo not display");
        Assert.assertTrue(accountsPage.homeA().isDisplayed(),"home anchor not display");
        Assert.assertTrue(accountsPage.popularA().isDisplayed(),"profileA not display");
        Assert.assertTrue(accountsPage.searchIconProfile().isDisplayed(),"search not display");
        Assert.assertTrue(accountsPage.memberShip().isDisplayed(),"membership not display");
        Assert.assertTrue(accountsPage.planDetails().isDisplayed(),"plan details not display");
        Assert.assertTrue(accountsPage.iconDetail().isDisplayed(),"icons not display");
        Assert.assertEquals(accountsPage.contactUs(),"Contact Us","contact msg match");
        Assert.assertTrue(accountsPage.premiumAccount().isDisplayed(),"premium details not display");
        Assert.assertTrue(accountsPage.UltraHd().isDisplayed(),"ultra hd is not display");
    }

    @And("click on logout button")
    public void logout(){
        accountsPage.logout().click();
    }

    @Then("redirect to login page")
    public void redirectToHome(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");

    }


}
