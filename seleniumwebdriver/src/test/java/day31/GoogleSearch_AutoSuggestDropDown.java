package day31;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch_AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
				
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies(); //deletes all the cookies in your browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
          
		//accept cookie banner if showed
        try {
            WebElement acceptButton=wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Accetta') or contains(., 'Accept') or contains(., 'Accetto')]")));
            acceptButton.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Banner cookie non found");
        }
        
		driver.findElement(By.name("q")).sendKeys("selenium"); //search box
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("selenium")) {
				list.get(i).click();
				break;
			}
		}	
	}
}