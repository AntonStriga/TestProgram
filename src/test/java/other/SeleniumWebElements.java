package other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.linkText("Oppo")).click();

        driver.navigate().to("http://edureka.co/blog");
        Thread.sleep(1000);
        driver.navigate().back();

        driver.quit();
    }
}
