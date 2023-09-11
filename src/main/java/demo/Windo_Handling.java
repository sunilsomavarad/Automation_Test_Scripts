package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windo_Handling {

    WebDriver driver;

    public Windo_Handling() {
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

    public void windowHandling() throws IOException {

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // driver.manage().window().maximize();
        // wb.navigate().refresh();
        driver.switchTo().frame("iframeResult");
        // WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        WebElement trybn = driver.findElement(By.xpath("//button[text()='Try it']"));
        trybn.click();

        String originalWindowHandle = driver.getWindowHandle();
        Set<String> allwindowhandles = driver.getWindowHandles();

        for (String chilcwindowHandle : allwindowhandles) {
            if (!chilcwindowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(chilcwindowHandle);
                break;
            }
        }

        // wb.navigate().to("https://www.w3schools.com/");
        System.out.println("The child window url : " + driver.getCurrentUrl());
        System.out.println("The child window title is : " + driver.getTitle());
        // Take Screenshot
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        AShot ashot = new AShot();
        Screenshot screenshot = ashot.takeScreenshot(driver);
        String filename = "Screenshot " + timeStamp + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(filename));
        System.out.println("Full page screenshot capture and saved at: " + filename);
        driver.close();
        driver.switchTo().window(originalWindowHandle);
        System.out.println("The parent window url is : " + driver.getCurrentUrl());
        System.out.println("The parent window title is : " + driver.getTitle());
    }

}
