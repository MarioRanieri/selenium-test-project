package day31;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
2) Hidden dropdown
Login to OrangeHRM-->pim-->employee status
*/
public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		//login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		//clicking on PIM 
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click(); //PIM
		
		//click dropdown button
		driver.findElement(By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		Thread.sleep(1000);
		
		//select one option
		WebElement option=driver.findElement(By.xpath("//span[normalize-space()='Full-Time Permanent']"));
		String selectedText=option.getText();
		option.click();
		System.out.println("  " + selectedText);

		Thread.sleep(1000);
		driver.quit();
	}
}