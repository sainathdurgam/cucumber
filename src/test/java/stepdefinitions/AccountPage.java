package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class AccountPage {

    WebDriver driver;
    WebDriverWait wait;

    By profileImage=By.xpath("//button/img");
    By headingE=By.xpath("//h1");
    By userParaE=By.xpath("//p[@class='membership-username']");
    By passwordParaE=By.xpath("//p[@class='membership-password']");
    By premiumE=By.xpath("//div[@class='plan-details-container']");
    By logoutE=By.xpath("//button[@class='logout-button']");
    By moviesLogo=By.xpath("//img[@class='website-logo']");
    By homeAnchor=By.xpath("//a[text()='Home']");
    By popularAnchor=By.xpath("//a[text()='Popular']");
    By searchIconInProfile=By.xpath("//button[@class='search-empty-button']");
    By memberShipE=By.xpath("//p[text()='Member ship']");
    By planDetails=By.xpath("//p[text()='Plan details']");
    By iconContainer=By.xpath("//div[@class='footer-icons-container']");
    By contact=By.xpath("//p[@class='contact-us-paragraph']");

    public AccountPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public WebElement movieLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesLogo));
        return driver.findElement(moviesLogo);
    }
    public WebElement homeA(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeAnchor));
        return driver.findElement(homeAnchor);
    }
    public WebElement popularA(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularAnchor));
        return driver.findElement(popularAnchor);
    }
    public WebElement searchIconProfile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIconInProfile));
        return driver.findElement(searchIconInProfile);
    }
    public WebElement memberShip(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(memberShipE));
        return driver.findElement(memberShipE);
    }
    public WebElement planDetails(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(planDetails));
        return driver.findElement(planDetails);
    }
    public WebElement iconDetail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(iconContainer));
        return driver.findElement(iconContainer);
    }
    public String contactUs(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contact));
        return driver.findElement(contact).getText();
    }


    public WebElement profile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileImage));
        return driver.findElement(profileImage);
    }

    public String head(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingE));
        return driver.findElement(headingE).getText();
    }

    public WebElement username(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userParaE));
        return driver.findElement(userParaE);
    }

    public WebElement password(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordParaE));
        return driver.findElement(passwordParaE);
    }

    public WebElement premium(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(premiumE));
        return driver.findElement(premiumE);
    }

    public WebElement logout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutE));
        return driver.findElement(logoutE);
    }


}
