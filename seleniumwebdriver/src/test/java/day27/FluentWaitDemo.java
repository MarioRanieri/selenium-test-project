package day27;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

    public static void main(String[] args) {

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Wait<WebDriver> mywait= new FluentWait<>(driver)
        		.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        // Attendi fino a quando l'input è presente/visibile e restituiscilo
        WebElement txtusername= mywait.until(new Function<WebDriver, WebElement>() {
        	@Override
        	public WebElement apply(WebDriver d) {
        		WebElement el= d.findElement(By.xpath("//input[@placeholder='Username']"));
                return (el.isDisplayed() && el.isEnabled()) ? el : null;
              }
          });
        txtusername.sendKeys("Admin");
    }
}