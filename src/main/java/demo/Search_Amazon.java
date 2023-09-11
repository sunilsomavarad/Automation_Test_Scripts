package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Amazon {

    WebDriver driver;

    public Search_Amazon() {
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

    public void searchAmazon() {
        // Navigate to url https://www.google.com/gradle
        driver.get("https://www.google.com/");
        // Enter the amazon in the search field Using Locator "Name" q |
        // sendKeys("amazon")
        driver.findElement(By.name("q")).sendKeys("amazon");
        // Press enter in the search filed Using Locator "Name" q |
        // sendKeys(Keys.RETURN)
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        // Verify whether the amazon.in or amazon.com link is present in the page Using
        // Locator "XPath"
        boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']"))
                .isDisplayed();
        System.out.println("Is amazon is presnet :" + result);

    }

}
