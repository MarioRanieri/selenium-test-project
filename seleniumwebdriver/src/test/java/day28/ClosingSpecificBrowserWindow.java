package day28;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosingSpecificBrowserWindow {

    public static void main(String[] args) {
        
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Clic sul link che apre nuova finestra
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        // ID di tutte le finestre aperte
        Set<String> windowIDs= driver.getWindowHandles();
        String parentId= driver.getWindowHandle();

        for(String winid : windowIDs) {
            driver.switchTo().window(winid);
            String title= driver.getTitle();
            System.out.println("Window: " + title);
            
            if(title.contains("Human Resources Management Software")) {
                System.out.println("Closing child window...");
                driver.close();
            }
        }
        driver.switchTo().window(parentId);
        System.out.println("Back to main: " + driver.getTitle());
        driver.quit();
    }
}