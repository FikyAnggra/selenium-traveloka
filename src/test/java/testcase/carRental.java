package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class carRental {
    private static WebDriver driver;
    @Test
    public void withoutDriver() {
        //open browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.get("https://www.traveloka.com/en-id");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Select Cars Product
        driver.findElement(By.xpath("//div[text()='Car Rental']")).click();

        //Select tab Without Driver
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Without Driver']")));
        driver.findElement(By.xpath("//h4[text()='Without Driver']")).click();

        //Select Pick-up Location (e.g.: Jakarta)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='rental-search-form-location-input']")));
        driver.findElement(By.xpath("//input[@data-testid='rental-search-form-location-input']")).sendKeys("Jakarta");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Jakarta']")));
        driver.findElement(By.xpath("//div[@aria-label='Jakarta']")).click();

        //Select Pick-up Date & Time (e.g.: today+2d 09:00)
        driver.findElement(By.xpath("//input[@data-testid='rental-search-form-date-input-start']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='date-cell-"+ GetDate.setDaysToAdd("dd-M-yyyy", 2) +"'])[1]")));
        driver.findElement(By.xpath("(//div[@data-testid='date-cell-"+ GetDate.setDaysToAdd("dd-M-yyyy", 2) +"'])[1]")).click();
        driver.findElement(By.xpath("//input[@data-testid='rental-search-form-time-input-start']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-391gc0 r-1loqt21 r-1777fci r-tuq35u r-1otgn73 r-1i6wzkk r-lrvibr']//div[@class='css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-q4m81j'][text()='9']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-391gc0 r-1loqt21 r-1777fci r-tuq35u r-1otgn73 r-1i6wzkk r-lrvibr']//div[@class='css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-q4m81j'][text()='0']")).click();
        driver.findElement(By.xpath("//div[text()='Done']")).click();


        //Select Drop-off Date & Time (e.g.: today+5d 11:00)
        driver.findElement(By.xpath("//input[@data-testid='rental-search-form-date-input-end']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-testid='date-cell-"+ GetDate.setDaysToAdd("dd-M-yyyy", 5) +"'])[2]")));
        driver.findElement(By.xpath("(//div[@data-testid='date-cell-"+ GetDate.setDaysToAdd("dd-M-yyyy", 5) +"'])[2]")).click();
        driver.findElement(By.xpath("//input[@data-testid='rental-search-form-time-input-end']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-1777fci r-tuq35u r-1otgn73 r-1i6wzkk r-lrvibr']//div[@class='css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-q4m81j'][text()='11']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-391gc0 r-1loqt21 r-1777fci r-tuq35u r-1otgn73 r-1i6wzkk r-lrvibr']//div[@class='css-901oao r-cwxd7f r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-q4m81j'][text()='0']")).click();
        driver.findElement(By.xpath("//div[text()='Done']")).click();

        //Click button Search Car
        driver.findElement(By.xpath("//div[@data-testid='rental-search-form-cta']")).click();
        String actualResult = "Jakarta • "+GetDate.setDaysToAdd("E, dd MMM yyyy ", 2)+"09:00 - "+GetDate.setDaysToAdd("E, dd MMM yyyy ", 5)+"11:00";
        String expectedResult = driver.findElement(By.xpath("//*[text()='Jakarta']")).getText();
        Assert.assertEquals(actualResult, expectedResult);

        //Select Car
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-173mn98 r-1wzrnnt r-1w88a7h']")));
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-173mn98 r-1wzrnnt r-1w88a7h']")).click();

        //Select Car Provider
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-kdyh1x r-1loqt21 r-10paoce r-1guathk r-5njf8e r-1otgn73 r-lrvibr']")));
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-kdyh1x r-1loqt21 r-10paoce r-1guathk r-5njf8e r-1otgn73 r-lrvibr']")).click();

        //Select Pick-up Location in “Rental Office”
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-14gqq1x r-ttdzmv']")));
        WebElement elementScroll = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-14gqq1x r-ttdzmv']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScroll);
        driver.findElement(By.xpath("//div[@class='css-901oao r-t1w4ow r-ubezar r-majxgm r-135wba7 r-fdjqy7'][text()='Rental Office']")).click();
        driver.findElement(By.xpath("//div[@class='css-901oao css-bfa6kz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-1m04atk r-fdjqy7']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-1q52ik8 r-qklmqi r-1loqt21 r-kzbkwu r-1otgn73 r-1i6wzkk r-lrvibr']")).click();

        //Select Drop-off Location in “Other Location”
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-kdyh1x r-b4qz5r r-1ifxtd0 r-nsbfu8 r-184en5c']//div[@class='css-901oao r-t1w4ow r-ubezar r-majxgm r-135wba7 r-fdjqy7'][text()='Other Locations']")));
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-kdyh1x r-b4qz5r r-1ifxtd0 r-nsbfu8 r-184en5c']//div[@class='css-901oao r-t1w4ow r-ubezar r-majxgm r-135wba7 r-fdjqy7'][text()='Other Locations']")).click();
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-kdyh1x r-da5iq2']//div[@class='css-1dbjc4n']//div[@class='css-1dbjc4n']//input[@placeholder='Search location or address']")).sendKeys("jakarta");
        WebElement elementScrollDropOff = driver.findElement(By.xpath("//div[@class='css-901oao css-bfa6kz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-1m04atk r-fdjqy7']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollDropOff);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Indonesia, Asia Tenggara, Asia']")));
        driver.findElement(By.xpath("//div[text()='Indonesia, Asia Tenggara, Asia']")).click();

        //Input Pick-up/Drop-off notes is optional
        driver.findElement(By.xpath("//textarea[@placeholder='Additional notes (optional)']")).sendKeys("Cileungsi, Bogor");

        //Click button Continue in Product Detail
        WebElement elementScrollContinue = driver.findElement(By.xpath("//h3[text()='Rental Duration']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollContinue);
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-kdyh1x r-1loqt21 r-10paoce r-5wp0in r-5njf8e r-1otgn73 r-lrvibr']//div[@class='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-cygvgh r-b88u0q r-1iukymi r-q4m81j'][text()='Continue']")).click();

        //capcha

        //Fill Contact Details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-labelledby='name.full'])[1]")));
        driver.findElement(By.xpath("(//input[@aria-labelledby='name.full'])[1]")).sendKeys("Fiky Anggra Sepriaji");
        driver.findElement(By.xpath("(//input[@aria-label='Phone Number'])[1]")).sendKeys("89676848398");
        driver.findElement(By.xpath("//input[@aria-labelledby='emailAddress']")).sendKeys("fiky.anggra@gmail.com");

        //Fill Driver Details
        WebElement elementScrollDriver = driver.findElement(By.xpath("//h2[text()='Driver Details']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollDriver);
        driver.findElement(By.xpath("//option[@value='MR']")).click();
        driver.findElement(By.xpath("(//input[@aria-labelledby='name.full'])[2]")).sendKeys("Fiky Anggra");
        driver.findElement(By.xpath("(//input[@aria-label='Phone Number'])[2]")).sendKeys("89676848399");

        //Click Continue
        driver.findElement(By.xpath("//div[@class='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-cygvgh r-b88u0q r-1iukymi r-q4m81j']")).click();

        //Add a special request is optional
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Odd or even license plates, car charger, baby car seat, etc.']")));
        WebElement elementScrollSpesial = driver.findElement(By.xpath("//h2[text()='Car Rental Special Request (optional)']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollSpesial);
        driver.findElement(By.xpath("//textarea[@placeholder='Odd or even license plates, car charger, baby car seat, etc.']")).sendKeys("Car Charger");

        //Check all rental requirements
        driver.findElement(By.xpath("//div[text()='Tap to check the requirements.']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-kdyh1x']")));
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-kdyh1x']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-633pao']")).click();
        WebElement elementScrollSave = driver.findElement(By.xpath("//div[@class='css-901oao r-1yadl64 r-1vonz36 r-109y4c4 r-1cis278 r-1udh08x r-t60dpp r-u8s1d r-3s2u2q r-92ng3h'][text()='Save']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollSave);
        driver.findElement(By.xpath("//div[@class='css-901oao r-1yadl64 r-1vonz36 r-109y4c4 r-1cis278 r-1udh08x r-t60dpp r-u8s1d r-3s2u2q r-92ng3h'][text()='Save']']")).click();

        //Click Continue
        WebElement elementScrollDetail = driver.findElement(By.xpath("//h2[text()='Price Details']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementScrollDetail);
        driver.findElement(By.xpath("//div[@class='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-1uirtdp r-b88u0q r-uzxld0 r-q4m81j']")).click();
        driver.findElement(By.xpath("//div[@class='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-cygvgh r-b88u0q r-1iukymi r-q4m81j'][text()='Continue']")).click();

        //Select payment method and proceed payment
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='paymentScopeOption-Mandiri Transfer-selected']")));
        driver.findElement(By.xpath("//div[@data-testid='paymentScopeOption-Mandiri Transfer-selected']")).click();
    }
}
