package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

public class MovieDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    By homeImageE=By.xpath("//div[@class='react-slick-item']/img");
    By movieNameE=By.xpath("//div[@class='title-details-container']/h1");
    By reviewE=By.xpath("//div[@class='movie-review-container']");
    By paraE=By.xpath("//div[@class='title-details-container']/p");
    By playButoonE=By.xpath("//button[@class='play-button']");
    By popularAnchorE=By.xpath("//a[text()='Popular']");
    By paraImageE=By.xpath("//div[@class='search-movies-container']/li");

    public MovieDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement homeImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeImageE));
        return driver.findElement(homeImageE);
    }
    public WebElement name(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieNameE));
        return driver.findElement(movieNameE);
    }
    public WebElement review(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewE));
        return driver.findElement(reviewE);
    }
    public WebElement para(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paraE));
        return driver.findElement(paraE);
    }
    public WebElement play(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButoonE));
        return driver.findElement(playButoonE);
    }
    public WebElement popularAnchor(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularAnchorE));
        return driver.findElement(popularAnchorE);
    }
    public WebElement popularImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paraImageE));
        return driver.findElement(paraImageE);
    }

}
