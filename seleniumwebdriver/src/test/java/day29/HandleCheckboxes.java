package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1) select checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2) capturing all the checkboxes
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		System.out.println("Number of checkboxes: " + checkboxes.size()); //7

		//3) selecting all the checkboxes
		/*for(int i=0;i<checkboxes.size();i++)
			checkboxes.get(i).click();*/
		
		for(WebElement chkbox:checkboxes)
			chkbox.click();
		
		//4) select last 3 checkboxes
		for(int i=4;i<checkboxes.size();i++)
			checkboxes.get(i).click();
		
		//5) select first 3 checkboxes
		for(int i=0;i<3;i++)
			checkboxes.get(i).click();
	}
}