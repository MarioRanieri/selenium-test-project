package day25;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XPathAxesDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://money.rediff.com/gainers/bse/daily/groupa");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // 1) Aspetta la tabella caricata
            By tableLocator = By.xpath("//table[contains(@class,'dataTable')]/tbody");
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

            // 2) Prendi il link della PRIMA riga (colonna nome società)
            WebElement firstLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'dataTable')]/tbody/tr[1]/td[1]/a")
            ));

            String company = firstLink.getText();
            System.out.println("Company (self): " + company);

            // --- AXES DEMO partendo da firstLink ---
            // self
            System.out.println("Self: " + firstLink.findElement(By.xpath("./self::a")).getText());

            // parent (td)
            WebElement parentTd = firstLink.findElement(By.xpath("./parent::td"));
            System.out.println("Parent TD text: " + parentTd.getText());

            // ancestor (tr)
            WebElement row = firstLink.findElement(By.xpath("./ancestor::tr"));
            System.out.println("Row text: " + row.getText());

            // child (tutte le celle della riga)
            List<WebElement> cells = row.findElements(By.xpath("./child::td"));
            System.out.println("Cells count: " + cells.size());

            // descendant (*)
            List<WebElement> descendants = row.findElements(By.xpath("./descendant::*"));
            System.out.println("Descendants count: " + descendants.size());
            
            System.out.println("\n--- Descendant Elements ---");
            int index = 1;
            for (WebElement d : descendants) {
                String tag = d.getTagName();
                String text = d.getText().trim();
                System.out.println(index + ") <" + tag + "> " + (text.isEmpty() ? "(no text)" : text));
                index++;
            }

            // following / preceding
            int following = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr[1]/following::tr")).size();
            int preceding = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr[1]/preceding::tr")).size();
            System.out.println("Following tr: " + following);
            System.out.println("Preceding tr: " + preceding);

            // following-sibling / preceding-sibling (rispetto alla riga corrente)
            int followingSiblings = row.findElements(By.xpath("./following-sibling::tr")).size();
            int precedingSiblings = row.findElements(By.xpath("./preceding-sibling::tr")).size();
            System.out.println("Following-sibling tr: " + followingSiblings);
            System.out.println("Preceding-sibling tr: " + precedingSiblings);

        } finally {
            driver.quit();
        }
    }
}

