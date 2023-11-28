package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    By searchE=By.xpath("//button[@class='search-empty-button']");
    By inputE=By.xpath("//input[@id='search']");

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement search(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchE));
        return driver.findElement(searchE);
    }
    public void input(String a){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputE));
        driver.findElement(inputE).sendKeys( a);
    }
}
