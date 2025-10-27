package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {
        
    	//1) launch browser
        WebDriver driver=new ChromeDriver();

        //2) open URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //3) validate title should be "OrangeHRM"
        String act_title=driver.getTitle();

        if(act_title.equals("OrangeHRM"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed - actual title: " + act_title);

        // 4) close browser
        driver.quit();
    }
}