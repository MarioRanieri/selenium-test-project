package day30;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1)switch to 5th frame
2)click on link - opens new iframe
3)switch to inner frame 
4)check logo presence in the inner frame.
*/
public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();

		//frame 5
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//a[normalize-space()='https://a9t9.com']")).click();
		Thread.sleep(5000);
		//go to inner frame in frame 5
		driver.switchTo().frame(1);
		
		//check logo presence
		System.out.println("Checking logo...");

		try {
			WebElement logo=driver.findElement(
				    By.xpath("//img[contains(@alt,'Vision by a9t9')]"));
		    
		    System.out.println("LOGO TROVATO!");
		    System.out.println("   Alt text: " + logo.getAttribute("alt"));
		    System.out.println("   Src: " + logo.getAttribute("src"));
		    System.out.println("   Tag name: " + logo.getTagName());
		    System.out.println("   isDisplayed: " + logo.isDisplayed());
		    System.out.println("   isEnabled: " + logo.isEnabled());
		    
		    System.out.println("\n SUCCESS! Logo is PRESENT in the iframe!");
		    
		} catch (NoSuchElementException e) {
		    System.out.println("Logo NOT found!");
		}
	}
}