package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

    public static void main(String[] args) {
        // 1) Launch browser
        WebDriver driver = new ChromeDriver();

        // 2) Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 3) Validate title should be "OrangeHRM"
        String act_title = driver.getTitle();

        if (act_title.equals("OrangeHRM"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed - actual title: " + act_title);

        // 4) Close browser
        driver.quit();
    }
}

