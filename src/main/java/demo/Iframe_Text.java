package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe_Text {

    WebDriver driver;

    public Iframe_Text() {
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

    public void iframeText() {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switch to parent frame
        driver.switchTo().frame("frame-top");

        // switch to inner frame by frmae name driver.switchTo().frame("frame-left");
        driver.switchTo().frame("frame-left");

        // declare a webelement using locatot "tagname"
        WebElement leftEle = driver.findElement(By.tagName("body"));

        // declare a new variable and store left frame text
        String leftText = leftEle.getText();

        // print the text
        System.out.println(leftText);

        // switch to the parent frame
        driver.switchTo().parentFrame();

        // switch to the inner frame
        driver.switchTo().frame("frame-middle");

        // declare a webelement to middle frame
        WebElement middleEle = driver.findElement(By.tagName("body"));

        // declare a new variable and store in the middle frame text
        String middleText = middleEle.getText();

        // print the text
        System.out.println(middleText);

        // switch to the parent frame
        driver.switchTo().parentFrame();

        // switch to the inner frame
        driver.switchTo().frame("frame-right");

        // declare a webelement to right frame
        WebElement rightEle = driver.findElement(By.tagName("body"));

        // declare a new variable and store in the right frame text
        String rightText = rightEle.getText();

        // print the text
        System.out.println(rightText);

        // switch to thr default frame
        driver.switchTo().defaultContent();

        // switch to bottom frame
        driver.switchTo().frame("frame-bottom");

        // declare a webelement to bootmele
        WebElement bottomEle = driver.findElement(By.tagName("body"));

        // declare a new variable and store in bottom frame text
        String bottomText = bottomEle.getText();

        // print the text
        System.out.println(bottomText);

        // switch to the default frame
        driver.switchTo().defaultContent();

    }

}
