package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin_Post {

    WebDriver driver;

    public Linkedin_Post() {
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

    public void linkedinPost() throws InterruptedException {

        driver.get("https://www.linkedin.com/home");

        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("somavarad106@gmail.com");
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("sunilparu");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='sunil somavarad']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(2000);
        driver.findElement(By
                .xpath("//button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']"))
                .click();
        Thread.sleep(2000);
        WebElement imge = driver.findElement(By.xpath("//input[@name='file']"));
        String imgpath = "C:\\Users\\Dell\\OneDrive\\Pictures\\Screenshots\\WhatsApp Image 2023-06-09 at 11.37.33 AM.jpeg";
        imge.sendKeys(imgpath);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();

    }

}
