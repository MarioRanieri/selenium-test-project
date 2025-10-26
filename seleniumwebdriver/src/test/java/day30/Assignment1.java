package day30;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//1) click on login then handle alert : https://mypage.rediff.com/login/dologin
public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@name='proceed']")).click();
		Thread.sleep(5000);
		
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert message: " + alertText);
		alert.accept();
	}
}