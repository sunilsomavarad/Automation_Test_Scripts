
package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyper_Links {

    WebDriver driver;

    public Hyper_Links() {
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

    public void hyperLinks() {

        // Navigate to url
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        int countLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("Total number of Links present in the webpage:" + countLinks);

    }
}
