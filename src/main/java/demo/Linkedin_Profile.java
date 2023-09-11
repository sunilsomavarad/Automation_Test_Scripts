package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Linkedin_Profile {

    WebDriver driver;

    public Linkedin_Profile() {
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

    public void linkedInProfile() throws InterruptedException {

        driver.get("https://www.linkedin.com/home");
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("somavarad106@gmail.com");
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("sunilparu");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Me']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Me']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@id='ember1481']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='sunil somavarad']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//p)[1]")).sendKeys("Automation test engineers");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(2000);
        WebElement postSuccessMsg = driver.findElement(By.xpath("//span[text()='Post successful.']"));

        if (postSuccessMsg.isDisplayed()) {
            String s1 = postSuccessMsg.getText();
            System.out.println("Post has been updated sucessfully :" + s1);
        }

        WebElement viewPost = driver.findElement(By.xpath("//a[text()='View post']"));
        viewPost.click();
        if (viewPost.isDisplayed()) {
            System.out.println("User is able to view the post sucessfully");
        }

    }

}
