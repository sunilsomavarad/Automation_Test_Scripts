package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb_Ratings {

    WebDriver driver;

    public Imdb_Ratings() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void imdbRatings() throws InterruptedException {

        driver.get("https://www.imdb.com/chart/top/");
        WebElement highestRatedMovie = driver.findElement(By.xpath("https://www.imdb.com/chart/top/"));
        highestRatedMovie.getText();
        System.out.println("Highest rated movie on the IMDB :" + highestRatedMovie);
        List<WebElement> totalNumberOfMovies = driver.findElements(
                By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println(totalNumberOfMovies.size() + "Movies are included in the table");
        Select select = new Select(driver.findElement(By.id("sort-by-selector")));
        select.selectByVisibleText("Release date");
        Thread.sleep(30000);
        WebElement wb1 = driver
                .findElement(By.xpath("(//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[250]/div/a/h3"));
        WebElement wb2 = driver.findElement(By.xpath("//div[@class='sc-b85248f1-0 bCmTgE cli-children'])[1]/div/a/h3"));
        if (wb1.isDisplayed()) {
            String txt1 = wb1.getText();
            System.out.println("The oldest movie on the list : " + txt1);
        }
        if (wb2.isDisplayed()) {
            String txt2 = wb2.getText();
            System.out.println("The recent movie on the list : " + txt2);
        }
        select.selectByIndex(3);
        System.out.println(highestRatedMovie + " movie has the most user ratings");

    }
}
