package day30;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Assignment2 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ui.vision/demo/webtest/frames/");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            //1) in frame5
            WebElement frame5=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//frame[@src='frame_5.html']")));
            driver.switchTo().frame(frame5);

            // 2) click on link
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='https://a9t9.com']"))).click();

            // 3) Problem: the logo is in the fame 5, not iframe
            WebElement logo=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@alt,'Ui.Vision')]")));
            
            System.out.println("LOGO!");
            System.out.println("Alt: " + logo.getAttribute("alt"));
            System.out.println("Src: " + logo.getAttribute("src"));
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}