package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* Handle country dropdown with/without using Select class:
https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/
a) count total number of options
b) print all the options
c) select one option
*/

public class Assignment1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//select[@id='country-list']")).click();
        Thread.sleep(2000);

        //a) count total number of options
        List<WebElement> options=driver.findElements(By.xpath("//select[@id='country-list']/option"));
        System.out.println("a) Number of options: " + options.size());

        //b) print all the options
      	for(WebElement op:options)
      		System.out.println(op.getText());

        //c) select one option (China)
        System.out.println("\nc) Selecting 'China'...");
        for (WebElement option:options) {
            if (option.getText().equals("China")) {
                option.click();
                System.out.println(" Selected: " + option.getText());
                break;
            }
        }
        Thread.sleep(3000);
        driver.quit();
    }
}