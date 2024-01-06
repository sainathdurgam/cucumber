package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;


public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;



    By searchButtonE=By.xpath("//button[@class='search-empty-button']");
    By inputSearchE=By.xpath("//input[@id='search']");
    By okE=By.xpath("//button[@class='search-button']");
    By resultE=By.xpath("//ul[@class='search-movies-container']/li");
    By errorMessageE=By.xpath("//p");


    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement search(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButtonE));
        return driver.findElement(searchButtonE);
    }
    public WebElement input(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearchE));
        return driver.findElement(inputSearchE);
    }

    public WebElement result(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultE));
        return driver.findElement(resultE);
    }
    public WebElement error(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageE));
        return driver.findElement(errorMessageE);
    }

    public WebElement ok(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(okE));
        return driver.findElement(okE);
    }


}
