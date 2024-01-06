
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import stepdefinitions.LoginPage;

public  class LoginPageTest {

    public WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32 (2)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("I am on the login page")
    public void loginPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }


    @Then("I should be view UI")
    public void loginPageUi(){
        Assert.assertTrue(loginPage.findLogo().isDisplayed(),"App logo image is not displayed");
        Assert.assertEquals(loginPage.getHeadingTextAt(),"Login","heading dsnt match");
        Assert.assertEquals(loginPage.usernameLabelFun(),"USERNAME","user label text does not match");
        Assert.assertEquals(loginPage.passwordLabelFun(),"PASSWORD","password label text does not match");
        Assert.assertTrue(loginPage.btn().isDisplayed(),"btn is dsnt matched");

    }


    @When("I enter a valid User ID and valid pin")
    public void enterValidUserPassword(){
        loginPage.loginToApplication("rahul", "rahul@2021");
    }

    @When("I enter a valid PIN")
    public void emptyUserId(){
        loginPage.loginToApplication("", "rahul@2021");
    }

    @When("I enter a valid User ID")
    public void emptyPin(){
        loginPage.loginToApplication("rahul", "");
    }

    @When("I enter a valid User ID and I enter an invalid PIN")
    public void invalidPin(){
        loginPage.loginToApplication("rahul", "rahul@202");
    }

    @When("Empty username and passwords test")
    public void emptyUsernamePassword(){
        loginPage.loginToApplication("","");
    }

    @When("Invalid username and correct password test")
    public void invalidUsername(){
        loginPage.loginToApplication("rahu", "rahul@2021");
    }


    @And("I click on the login button")
    public void clicking(){
        loginPage.clickOnButton();
    }

    @Then("I should be redirected to the homepage")
    public void redirectedToHome(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }

    @Then("error message 'Invalid user ID' should be visible")
    public void errorMessage(){
        loginPage.getErrorMessage();
    }


    @Then("an error message 'User ID and PIN didn't match' should be visible")
    public void invalidCredError(){
        loginPage.getErrorMessage();
    }


}