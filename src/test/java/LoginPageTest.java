
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
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }








    @Given("I am on the login page")//login page
    public void loginPage(){
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @Then("I should be view UI")
    public void loginPageUi(){
        Assert.assertTrue(loginPage.findLogo().isDisplayed(),"App logo image is not displayed");
        Assert.assertEquals(loginPage.getHeadingTextAt(),"Login","heading does not match");
        Assert.assertEquals(loginPage.usernameLabelFun(),"USERNAME","user label text does not match");
        Assert.assertEquals(loginPage.passwordLabelFun(),"PASSWORD","password label text does not match");
        Assert.assertTrue(loginPage.btn().isDisplayed(),"btn is does not matched");
    }




    @When("I enter a valid User ID and valid pin")
    public void enterValidUserPassword(){
        loginPage.loginToApplication("rahul", "rahul@2021");
    }
    @Then("I should be redirected to the homepage")
    public void redirectedToHome(){
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedUrl, "URLs do not match");
    }


    @When("Empty username and passwords test")
    public void emptyUsernamePassword(){
        loginPage.loginToApplication("","");
    }
    @Then("error message *Username or password is invalid should be visible")
    public void errorMessage(){
        Assert.assertEquals(loginPage.getErrorMessage(),"*Username or password is invalid");
    }



    @When("I enter a valid User ID and empty Pin")
    public void emptyPin(){
        loginPage.loginToApplication("rahul", "");
    }





    @When("I enter a valid PIN  and empty userId")
    public void emptyUserId(){
        loginPage.loginToApplication("", "rahul@2021");
    }




    @When("I enter a valid User ID and I enter an invalid PIN")
    public void invalidPin(){
        loginPage.loginToApplication("rahul", "rahul@202");
    }
    @Then("an error message *username and password didn't match should be visible")
    public void invalidCredError(){

        Assert.assertEquals(loginPage.getErrorMessage(),"*username and password didn't match","username and password not match");
    }


    @When("Invalid username and correct password test")
    public void invalidUsername(){
        loginPage.loginToApplication("rahu", "rahul@2021");
    }
    @When("Invalid username and Incorrect password test")
    public void invalidUsernameWithIncorrectPin(){
        loginPage.loginToApplication("rahu", "rahul@2021ghhghjg");
    }
    @Then("an error message *invalid username should be visible")
    public void invalidUserName(){

        Assert.assertEquals(loginPage.getErrorMessage(),"*invalid username","username and password not match");
    }










    @And("I click on the login button")
    public void clicking(){
        loginPage.clickOnButton();
    }


    @After
    public void tearDown(){
        driver.quit();
    }


}