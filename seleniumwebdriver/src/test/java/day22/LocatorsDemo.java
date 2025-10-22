package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		//nameLocator
		WebElement searchBox= driver.findElement(By.name("search"));
		searchBox.sendKeys("MacBook");
		//single step
		driver.findElement(By.name("search")).sendKeys("Macbook");
		
		//idLocator
		//WebElement logo=driver.findElement(By.id("logo"));
		//boolean status=logo.isDisplayed();
		//single step
		//boolean status=driver.findElement(By.id("logo")).isDisplayed();
		
		//linkText & partialLinkText  -- only for link
		driver.findElement(By.linkText("Tablets")).click();   //linkText  //preferable
		driver.findElement(By.partialLinkText("Tab")).click();  //partialLinkText
		
		//classname
		List<WebElement> headerLinks=driver.findElements(By.className("list-inline-item"));
		System.out.println(headerLinks.size()); //7
				
		//tagname
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size()); //76
				
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println(images.size()); //18
				
				
		//findElement() Vs findElements()
				
		//WebElement ele=driver.findElement(By.id("xyz")); //NoSuchElementException
				
		//List<WebElement> ele=driver.findElements(By.id("xyz")); 
		//System.out.println(ele.size());
		
		
		

	}

}
