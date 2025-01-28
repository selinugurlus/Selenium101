package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

    public static void main(String[] args)
    {
       // Selenium 4 ile birlikte, chromedriver gibi tarayıcı sürücülerini manuel olarak indirip
        // belirtmek yerine, WebDriverManager kullanarak otomatik olarak bu sürücüleri indirip
        // kullanabilirsiniz.

            // ChromeDriver'ı başlatın
        WebDriver driver = new ChromeDriver() ;

        // Web sayfasına gidin
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize(); //açılan web sayfasını büyütür.

        WebElement nameElement = driver.findElement(By.id("userName")); //id'si userName olan elementi nameElemente atıyoruz.
        nameElement.click();
        nameElement.sendKeys("Selin"); //nameElement içine Selin yazdırıyoruz.
    }
}
