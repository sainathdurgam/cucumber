package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;



    By movies=By.xpath("//div[@class='search-movies-container']/li");

    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public int moviesContainer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movies));
        return driver.findElements(movies).size();
    }
}
