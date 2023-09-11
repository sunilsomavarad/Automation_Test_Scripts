package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Book_My_Show {

    WebDriver driver;

    public Book_My_Show() {
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

    public void bookMyShow() {

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> links = driver.findElements(By.tagName("img"));

        for (WebElement link : links) {
            System.out.println(link.getAttribute("src"));
        }

        WebElement movieName = driver.findElement(By.xpath("//div[text()='Love on the Road']"));
        movieName.getText();
        WebElement movieLanguage = driver.findElement(By.xpath("//div[text()='English'][1]"));
        movieLanguage.getText();
    }

}
