package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By headingsE=By.xpath("//h1");
    By trendHeading=By.xpath("//h1[text()='Trending Now']");
    By orginalHeading=By.xpath("//h1[text()='Originals']");
    By playBtnE=By.xpath("//button[@class='home-movie-play-button']");
    By moviesE=By.xpath("//img[@class='poster']");
    By footerE=By.xpath("//div[@class='footer-container']");
    By websiteLogoE=By.xpath("//img[@alt='website logo']");
    By navHomeE=By.xpath("//a[text()='Home']");
    By navPopular=By.xpath("//a[text()='Popular']");
    By profileImgE=By.xpath("//button[@type='button']/img");
    By contactSectionItems=By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactTextE=By.xpath("//div[@class='footer-container']/p");
    By searchE=By.xpath("//button[@class='search-empty-button']");
    By moviesDisplayE=By.xpath("//div[@class='slick-track']");

    //By movieParaE=By.xpath("//p[@class='movie-overview']");


    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    /*public WebElement moviez(int j){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesDisplayE));
         for (int k=0;k<2;k++){
            return  driver.findElements(moviesDisplayE).get(k);
        }

    }*/
    public WebElement trendingHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(trendHeading));
        return  driver.findElement(trendHeading);
    }

    /*public WebElement moviePara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieParaE));
        return  driver.findElement(movieParaE);
    }*/
    public WebElement orginalHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orginalHeading));
        return  driver.findElement(orginalHeading);
    }

    public WebElement searching(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchE));
        return  driver.findElement(searchE);
    }

    public WebElement web(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(websiteLogoE));
        return driver.findElement(websiteLogoE);
    }
    public WebElement home(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navHomeE));
        return driver.findElement(navHomeE);
    }
    public WebElement popular(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navPopular));
        return driver.findElement(navPopular);
    }
    public WebElement profile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileImgE));
        return driver.findElement(profileImgE);
    }
    public int headCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingsE));
        return  driver.findElements(headingsE).size();
    }
    public WebElement headDisplay(int i){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingsE));
        return driver.findElements(headingsE).get( i);
    }
    public WebElement moviesDisplay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesE));
        return driver.findElement(moviesE);
    }

    public WebElement play(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(playBtnE));
        return driver.findElement(playBtnE);
    }

    public int movesInt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesE));
        return driver.findElements(moviesE).size();
    }
    public WebElement footer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(footerE));
        return driver.findElement(footerE);
    }

    public int contactIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactSectionItems));
       return   driver.findElements(contactSectionItems).size();
    }
    public String contactText(){
        return driver.findElement(contactTextE).getText();
    }
}
