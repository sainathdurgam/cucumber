package pages;
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

    public AccountPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement profile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileImage));
        return driver.findElement(profileImage);
    }

    public WebElement head(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingE));
        return driver.findElement(headingE);
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
