package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By websiteLogoImage=By.xpath("//div[@class='login-website-logo-container']");
    By HeadingText=By.xpath("//h1");
    By usernameLabel=By.xpath("//label[text()='USERNAME']");
    By passwordlabel=By.xpath("//label[text()='PASSWORD']");
    By loginButton=By.xpath("//button");
    By userE=By.xpath("//input[@id='usernameInput']");
    By passE=By.xpath("//input[@id='passwordInput']");
    By btnE=By.xpath("//button[@type='submit']");
    By errorMessageLocator = By.xpath("//p[@class='error-message']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }


    public WebElement findLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogoImage));
        return driver.findElement(websiteLogoImage);
    }

    public String getHeadingtextAt(){
        return driver.findElement(HeadingText).getText();
    }

    public String usernameLabelFun(){
        return driver.findElement(usernameLabel).getText();
    }

    public String passwordLabelFun(){
        return driver.findElement(passwordlabel).getText();
    }

    public WebElement btn(){
        return driver.findElement(loginButton);
    }

    public void enterUsername(String user){
        driver.findElement(userE).sendKeys(user);
    }
    public void enterPassword(String password){
        driver.findElement(passE).sendKeys(password);
    }
    public void clickOnButton(){
        driver.findElement(btnE).submit();
    }

    public void loginToApplication(String user, String password){
        enterUsername(user);
        enterPassword(password);
        clickOnButton();
    }
    public String getErrorMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }

}