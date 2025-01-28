package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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

        WebElement fullName = driver.findElement(By.id("userName")); //id'si userName olan elementi nameElemente atıyoruz.
        fullName.click();
        fullName.sendKeys("Selin"); //nameElement içine Selin yazdırıyoruz.

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement email =driver.findElement(new By.ByCssSelector(".mr-sm-2[id='userEmail']"));
        email.click();
        email.sendKeys("selinugurlu@gmail.com");



        WebElement currentAddress=driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.sendKeys("İzmir");

        WebElement permanentAddress= driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Turkey");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        //Textleri alma:

        WebElement nameText=driver.findElement(By.xpath("//div/p[@id='name']")); //xpath sorgusu kullandık elemente erişmek için:XPath, XML belgeleri için bir sorgu dilidir.
        String name= nameText.getText();
        System.out.println(name);

        WebElement emailText= driver.findElement(By.xpath("//div/p[@id='email']"));
        String mail=emailText.getText();
        System.out.println(mail);

        //Checkbox tıklama

        // ChromeDriver'ı başlatın
      //  WebDriver driver = new ChromeDriver() ;

        // Web sayfasına gidin
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize(); //açılan web sayfasını büyütür.

        String homeCheckBoxCssValue= "label[for='tree-node-home'] span.rct-checkbox svg";
        WebElement homeCheckBox= driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        homeCheckBox.click();

        //check box check edilmiş mi diye kontrol:

        homeCheckBox=driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));

        String homeCheckBoxClassName=homeCheckBox.getAttribute("class");

        if(homeCheckBoxClassName.equals("rct-icon rct-icon-check"))
        {
            System.out.println("Checkbox is checked!");
        }
        else
        {
            System.out.println("Checkbox is not checked!");
        }

    }
}
