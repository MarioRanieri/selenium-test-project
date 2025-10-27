package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {

    public static void main(String[] args) {
        
        WebDriver driver=new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.demoblaze.com/index.html");
            
            //wait
            Thread.sleep(3000);
            
            //count links
            List<WebElement> links=driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            
            //count images
            List<WebElement> images=driver.findElements(By.tagName("img"));
            System.out.println(images.size());
            
            //check if exist
            List<WebElement> samsungLinks=driver.findElements(By.partialLinkText("Samsung"));
            if(samsungLinks.size()>0) {
                System.out.println(samsungLinks.get(0).getText());
                samsungLinks.get(0).click();
                Thread.sleep(2000);
            } else {
                System.out.println("Product not found!");
            }  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}