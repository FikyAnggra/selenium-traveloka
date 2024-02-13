package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class game {
    private static WebDriver driver;
    @Test
    public void automatedGame() {
        //open browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://zzzscore.com/1to50/en/");

        //scroll to element
        WebElement elementScroll = driver.findElement(By.xpath("//*[text()=' 1to50']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScroll);


        WebElement grid = driver.findElement(By.id("grid"));

        List<WebElement> elements = grid.findElements(By.tagName("div"));

        for (int i = 1; i <= 50; i++) {
            String textCount = String.valueOf(i);
            for (WebElement element : elements) {
                String text = element.getText();
                if (text.equals(textCount)) {
                    element.click();
                    break;
                }
            }
        }

        driver.quit();
    }
}
