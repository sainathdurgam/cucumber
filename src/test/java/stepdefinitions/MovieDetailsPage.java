package stepdefinitions;
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

    By logoE=By.xpath("//img[@class='website-logo']");
    By homeAncharE=By.xpath("//a[text()='Home']");
    By popularE=By.xpath("//a[text()='Popular']");
    By searchIconE=By.xpath("//button[@class='search-empty-button']");
    By profileE=By.xpath("//button[@class='avatar-button']");
    By contactSectionItems=By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactTextE=By.xpath("//div[@class='footer-container']/p");
    By moreHeadE=By.xpath("//h1[@class='similar-movies-heading']");
    By moviesList=By.xpath("//li/img");
    public MovieDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public String more(){
        return driver.findElement(moreHeadE).getText();
    }
    public WebElement moviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesList));
        return driver.findElement(moviesList);
    }
    public WebElement homeA(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeAncharE));
        return driver.findElement(homeAncharE);
    }
    public WebElement popular(){
        return driver.findElement(popularE);
    }
    public WebElement searchIcon(){
        return driver.findElement(searchIconE);
    }
    public WebElement profile(){
        return driver.findElement(profileE);
    }
    public WebElement logo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoE));
        return driver.findElement(logoE);
    }

    public int contactIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactSectionItems));
        return   driver.findElements(contactSectionItems).size();
    }
    public String contactText(){
        return driver.findElement(contactTextE).getText();
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
