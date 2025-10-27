package day27;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwaitcommand {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		//explicit wait declaration
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
			
		//usage of explicit wait
		WebElement textusername=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		textusername.sendKeys("Admin");
		
		WebElement textpwd=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		textpwd.sendKeys("admin1234");

		WebElement loginButton=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		loginButton.click();
		
        WebDriverWait shortWait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg=shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));

        //visible error
        System.out.println("Login fallito: " + errorMsg.getText());
            
        //insert username
        WebElement usernameField=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        usernameField.clear();
        usernameField.sendKeys("Admin");
        //insert password
        WebElement pwdField=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        pwdField.clear();
        pwdField.sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        
        //check if dashboard is showed
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
	}
}