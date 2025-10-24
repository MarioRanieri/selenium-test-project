package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        
        driver.get("https://testautomationpractice.blogspot.com/");
        
        // 1) Provide string search
        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        // 2) Count number of links
        List<WebElement> searchlinks = driver.findElements(
            By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));
        
        System.out.println("2) Number of Links: " + searchlinks.size());
        
        // 3) Click on each link using for loop
        System.out.println("\n3) Printing & clicking links...");
        for(WebElement link : searchlinks) {
            System.out.println("   " + link.getText());
            link.click();
        }
        
        // 4) Get window IDs for every browser window
        Set<String> windowIds = driver.getWindowHandles();
        System.out.println("\n4) Total windows opened: " + windowIds.size());
        
        System.out.println("\nSwitching to each window and getting titles:");
        for(String winid : windowIds) {
            String title = driver.switchTo().window(winid).getTitle();
            System.out.println("   Window ID: " + winid);
            System.out.println("   Title: " + title);
        }
        
        // 5) Close specific browser window
        System.out.println("\n5) Closing a specific window...");
        // Torna alla prima finestra e chiudila come esempio
        String firstWindow = windowIds.iterator().next();
        driver.switchTo().window(firstWindow);
        System.out.println("   Closing: " + driver.getTitle());
        driver.close();
        
        System.out.println("   Remaining windows: " + driver.getWindowHandles().size());
        
        driver.quit();
    }
}