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
    By paraImageE=By.xpath("//div[@class='search-movies-container']/li");//not working

    By logoE=By.xpath("//img[@class='website-logo']");
    By homeAncharE=By.xpath("//a[text()='Home']");
    By popularE=By.xpath("//a[text()='Popular']");
    By searchIconE=By.xpath("//button[@class='search-empty-button']");
    By profileE=By.xpath("//button[@class='avatar-button']");
    By contactSectionItems=By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactTextE=By.xpath("//div[@class='footer-container']/p");
    By moreHeadE=By.xpath("//h1[@class='similar-movies-heading']");
    By moviesList=By.xpath("//li/img");
    By genresE=By.xpath("//div[@class='genres-category']");
    By AudioLanguageE=By.xpath("//div[@class='audio-category']");
    By RatingE=By.xpath("//div[@class='rating-category']");
    By budgetE=By.xpath("//div[@class='budget-category']");
    By genresHeadingE=By.xpath("//h1[text()='Genres']");
    By genresParaE=By.xpath("//div[@class='genres-container']/p");
    By audioHeadingE=By.xpath("//h1[text()='Audio Available']");
    By audioParaE=By.xpath("//ul[@class='audio-container']/li");
    By ratingCountHeadingE=By.xpath("//h1[text()='Rating Count']");
    By ratingCountParaE=By.xpath("//div[@class='rating-category']/p");
    By ratingAverageHeadingE=By.xpath("//h1[text()='Rating Average']");
    By ratingAverageParaE=By.xpath("//div[@class='rating-category']/p");
    By budgetHeadingE=By.xpath("//h1[text()='Budget']");
    By budgetParaE=By.xpath("//div[@class='budget-category']/p");
    By releaseDateHeading=By.xpath("//h1[text()='Release Date']");
    By releaseParaE=By.xpath("//div[@class='budget-category']/p");



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
    public WebElement genresPara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(genresParaE));
        return driver.findElement(genresParaE);
    }
    public WebElement audioPara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(audioParaE));
        return driver.findElement(audioParaE);
    }
    public WebElement ratingCountPara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingCountParaE));
        return driver.findElement(ratingCountParaE);
    }
    public WebElement ratingAveragePara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingAverageParaE));
        return driver.findElement(ratingAverageParaE);
    }
    public WebElement budgetPara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetParaE));
        return driver.findElement(budgetParaE);
    }
    public WebElement releasePara(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseParaE));
        return driver.findElement(releaseParaE);
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
    public WebElement genres(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(genresE));
        return driver.findElement(genresE);
    }


    public WebElement audio(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(AudioLanguageE));
        return driver.findElement(AudioLanguageE);
    }
    public WebElement rating(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RatingE));
        return driver.findElement(RatingE);
    }
    public WebElement budget(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetE));
        return driver.findElement(budgetE);
    }

    public int contactIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactSectionItems));
        return   driver.findElements(contactSectionItems).size();
    }
    public String contactText(){
        return driver.findElement(contactTextE).getText();
    }
    public String genresH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(genresHeadingE));
        return driver.findElement(genresHeadingE).getText();
    }
    public String audioH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(audioHeadingE));
        return driver.findElement(audioHeadingE).getText();
    }
    public String ratingCountH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingCountHeadingE));
        return driver.findElement(ratingCountHeadingE).getText();
    }
    public String ratingAverageH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ratingAverageHeadingE));
        return driver.findElement(ratingAverageHeadingE).getText();
    }
    public String budgetH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(budgetHeadingE));
        return driver.findElement(budgetHeadingE).getText();
    }
    public String releaseH(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseDateHeading));
        return driver.findElement(releaseDateHeading).getText();
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
