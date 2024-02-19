package stepdefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;



    By movies=By.xpath("//div[@class='search-movies-container']/li");
    By logoE=By.xpath("//img[@class='website-logo']");
    By homeE=By.xpath(("//a[text()='Home']"));
    By PopularE=By.xpath("//a[text()='Popular']");
    By searchIconE=By.xpath("//button[@class='search-empty-button']");
    By profileE=By.xpath("//button[@class='avatar-button']");
    By contactSectionItems=By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactTextE=By.xpath("//div[@class='footer-container']/p");

    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement logo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoE));
        return driver.findElement(logoE);
    }
    public WebElement home(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeE));
        return driver.findElement(homeE);
    }
    public WebElement popular(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PopularE));
        return driver.findElement(PopularE);
    }
    public WebElement searchIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIconE));
        return driver.findElement(searchIconE);
    }
    public WebElement profile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileE));
        return driver.findElement(profileE);
    }
    public String contactText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactTextE));
        return driver.findElement(contactTextE).getText();
    }
    public int contactIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactSectionItems));
        return driver.findElements(contactSectionItems).size();
    }


    public int moviesContainer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movies));
        return driver.findElements(movies).size();
    }
   public WebElement moviesDisplay(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(movies));
        return driver.findElement(movies);
    }
}
