package day22;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.demoblaze.com/index.html");
            
            // Aspetta caricamento
            Thread.sleep(3000);
            
            // Conta link
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Numero di link: " + links.size());
            
            // Conta immagini
            List<WebElement> images = driver.findElements(By.tagName("img"));
            System.out.println("Numero di immagini: " + images.size());
            
            // VERIFICA ESISTENZA con findElements
            List<WebElement> samsungLinks = driver.findElements(By.partialLinkText("Samsung"));
            
            if(samsungLinks.size() > 0) {
                System.out.println("Elemento trovato: " + samsungLinks.get(0).getText());
                samsungLinks.get(0).click();
                Thread.sleep(2000);
                System.out.println("Click eseguito!");
            } else {
                System.out.println("Nessun prodotto Samsung trovato!");
                
                // Proviamo con un altro prodotto
                List<WebElement> nokiaLinks = driver.findElements(By.partialLinkText("Nokia"));
                if(nokiaLinks.size() > 0) {
                    System.out.println("Cliccando su: " + nokiaLinks.get(0).getText());
                    nokiaLinks.get(0).click();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
