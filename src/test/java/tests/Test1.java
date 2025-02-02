package tests;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test1 {


    public static void main(String[] args) {
        // Selenium 4 ile birlikte, chromedriver gibi tarayıcı sürücülerini manuel olarak indirip
        // belirtmek yerine, WebDriverManager kullanarak otomatik olarak bu sürücüleri indirip
        // kullanabilirsiniz.

        // ChromeDriver'ı başlatın
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        // Web sayfasına gidin
       /* driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize(); //açılan web sayfasını büyütür.

        WebElement fullName = driver.findElement(By.id("userName")); //id'si userName olan elementi nameElemente atıyoruz.
        fullName.click();
        fullName.sendKeys("Selin"); //nameElement içine Selin yazdırıyoruz.


        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[id='userEmail']"));
        email.click();
        email.sendKeys("selinugurlu@gmail.com");


        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.click();
        currentAddress.sendKeys("İzmir");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Turkey");

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        //Textleri alma:

        WebElement nameText = driver.findElement(By.xpath("//div/p[@id='name']")); //xpath sorgusu kullandık elemente erişmek için:XPath, XML belgeleri için bir sorgu dilidir.
        String name = nameText.getText();
        System.out.println(name);

        WebElement emailText = driver.findElement(By.xpath("//div/p[@id='email']"));
        String mail = emailText.getText();
        System.out.println(mail);

        //Checkbox tıklama

        // Web sayfasına gidin
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize(); //açılan web sayfasını büyütür.

        String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";
        WebElement homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        homeCheckBox.click();

        //check box check edilmiş mi diye kontrol:

        homeCheckBox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));

        String homeCheckBoxClassName = homeCheckBox.getAttribute("class");

        if (homeCheckBoxClassName.equals("rct-icon rct-icon-check")) {
            System.out.println("Checkbox is checked!");
        } else {
            System.out.println("Checkbox is not checked!");
        }

        //başka checkbox
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
        boolean isEnabled = sportCheckbox.isEnabled(); //bu element tıklanabilir mi? diye kontrol eder. Boolen ifade döner. Tıklanıyorsa:true, tıklanamıyorsa false döner.
        System.out.println(isEnabled);

        WebElement sportsCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));
        if (isEnabled) {
            try {
                sportCheckbox.click();
            } catch (ElementClickInterceptedException ex) {
                sportsCheckboxLabel.click();
                System.out.println("Entered catch block.");
            }
        }
        boolean isSelected = sportCheckbox.isSelected();
        System.out.println(isSelected);


        //Radiobutton

        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadioButtonLabel = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        boolean isEnabledRadioButton = yesRadioButtonLabel.isEnabled();
        if (isEnabledRadioButton) {
            yesRadioButtonLabel.click();
        }

        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(output.getText());


        //ACTIONS  SINIFI:
        driver.get("https://demoqa.com/buttons");

        //çift tıklama:

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBtn).perform();

        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        //Sağ tıklama:
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickBtn).perform();


        //DİNAMİK ELEMENTLER:

        //xpath performans açısından pek tercih edilmez. Mecbur kalındığında kullanılmalı.
        WebElement dynamicClickBtn = driver.findElement(By.xpath("//div[last()]/button"));
        dynamicClickBtn.click();

        driver.get("https://demoqa.com/dynamic-properties");

        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        WebElement textElement = driver.findElement(By.xpath("//div/p"));
        String text = textElement.getText();
        System.out.println(text);

        WebElement enableAfterButton = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //5 saniye bekle demek
        wait.until(ExpectedConditions.elementToBeClickable(enableAfterButton)); //Bu element tıklanabilir olana kadar bekle demek. üstte yazdğımız 5 üst sınıf. eğer 5saniyeden çnce clickable olursa yine tıklar.
        enableAfterButton.click();


        //--
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String className = colorChangeButton.getDomAttribute("class");
        System.out.println("Before change:" + className);

        wait.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));
        className = colorChangeButton.getDomAttribute("class");
        System.out.println("After change:" + className);

        colorChangeButton.click();

        //-***

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement(By.id("visibleAfter")).click();

        //Kırık Lİnkler:
        driver.get("https://demoqa.com/broken");

        try {
            // HttpClient oluşturun
            HttpClient client = HttpClient.newHttpClient();

            // HttpRequest oluşturun
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://demoqa.com/")) // URL'nin doğru formatta olması sağlandı
                    .build();

            // HttpResponse'u alın
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Yanıtı yazdırın
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException | InterruptedException e) {
            // Hataları yakalayın ve ekrana yazdırın
            e.printStackTrace();
        }

        //Kırık Görseller:


        try {
            // Kırık görselin src URL'sini alıyoruz
            WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
            String brokenImageUrl = brokenImage.getDomAttribute("src");
            System.out.println(brokenImageUrl);

            // Eğer URL tam değilse, base URL ile birleştiriyoruz
            if (!brokenImageUrl.startsWith("http")) {
                String baseUrl = "https://demoqa.com"; // Base URL'yi belirtiyoruz
                brokenImageUrl = baseUrl + brokenImageUrl;
            }

            // HttpClient ve HttpRequest ile isteği gönderiyoruz
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(brokenImageUrl)) // Tam URL'yi burada kullanıyoruz
                    .build();

            // Yanıtı alıyoruz
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Yanıt kodu ve gövdesini yazdırıyoruz
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace(); // Hata varsa yazdırıyoruz
        } catch (Exception e) {
            e.printStackTrace(); // Diğer hataları da yakalıyoruz
        }*/


        //dosya yükleme:

      /*  driver.get("https://demoqa.com/upload-download");

        driver.manage().window().maximize(); //açılan web sayfasını büyütür.

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path = "C:\\Users\\Köseler\\Downloads"; //dosyanın ineceği bilgisayarımızdaki klasörümüzün yolu
        String fileName = "sampleFile.jpeg";
        try {
            Thread.sleep(5000); // 5 saniye bekleme koyduk çünkü daha indirmeden gidip o dosyayı aramaya çalışıyo o yüzden isFileDowbloaded fonksiyonu false dönüyordu.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Hata mesajını yazdırır
        }
        boolean isDownloaded=isFileDownloaded(path,fileName);
        System.out.println(isDownloaded);

        //Dosya Yükleme:

        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        WebElement uploadButton=driver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:/Users/Köseler/Downloads/Beige Minimalist Professional LinkedIn Background Photo.png");*/

        //Window/Tab Etkileşimleri:

       /* driver.get("https://demoqa.com/browser-windows");
        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        WebElement tabButton= driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs=new ArrayList<>(driver.getWindowHandles()); //açık olan sekmeleri bir listeye atıyoruz.

        System.out.println(tabs.size()); //kaç tane sekme olduğunu yazdırıyoruz.

        driver.switchTo().window(tabs.get(1)); //tabs listesindeki 2. sekmeye geçiş yapıyoruz.

        System.out.println(driver.getCurrentUrl()); //driverin bulunduğu sekmenin url'ini konsola yazdırıyoruz.

        try {
            Thread.sleep(1000); // 2 saniye bekleme koyduk çünkü çok hızlı close ediyordu görebilmek için
        } catch (InterruptedException e) {
            e.printStackTrace(); // Hata mesajını yazdırır
        }

        driver.close(); //driver'ın bulunduğu pencereyi kapatır. (driver'ı kapatmıyor.) driver.quit bu tamamen driver'ı kapatıyor.*/

        //Alerts:

       /* driver.get("https://demoqa.com/alerts");
        actions.sendKeys(Keys.PAGE_DOWN).build().perform(); //sayfayı aşağı indiriyoruz.

        driver.findElement(By.id("alertButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());

     //   System.out.println(driver.switchTo().alert().getText()); //Alert'in içinde yazan texti almak için.

       //driver.switchTo().alert().sendKeys("Selin"); //Alert'in içindeki textbox'a text yazmak için.

        driver.switchTo().alert().accept();*/

//FRAMES:
     /*   driver.get("https://demoqa.com/frames");

        //driver.switchTo().frame(0); //burda index numarasına göre ulaştık.

        driver.switchTo().frame("frame1"); //burda frame'in id'sine göre ulaştık.

        WebElement heading= driver.findElement(By.id("sampleHeading"));
        String text=heading.getText();
        System.out.println(text);

        driver.switchTo().parentFrame(); //Bir  üstteki ana frame'e geçiş yapıyoruz.*/

//MODALS: öne bir popup gibib çıkıyo ve arkasındaki syafayıı pasif hale getiren bir element.
       /* driver.get("https://demoqa.com/modal-dialogs");

        JavascriptExecutor Js = ((JavascriptExecutor)driver);

        Js.executeScript("window.scrollBy(0,600)") ; //sayfayı aşağı indiriyoruz.
        WebElement smallButton=driver.findElement(By.id("showSmallModal"));
        smallButton.click();

        WebElement smallCloseButton=driver.findElement(By.id("closeSmallModal"));
        smallCloseButton.click();*/

       //AUTO COMPLETE:

       /* driver.get("https://demoqa.com/auto-complete");

        WebElement input=driver.findElement(By.cssSelector("div.auto-complete__option"));
        input.sendKeys("R");

        List<WebElement> suggestions=driver.findElements(By.cssSelector("div.auto-complete__option"));

        for(WebElement suggestion:suggestions)
        {
            String text = suggestion.getText();
            System.out.println(text);

            if(text.equals("Red")) //eğer önerilenin texti "Red" olan varsa ona tıkla diyoruz.
            {
                suggestion.click();
                break;
            }
        }

        //suggestions.get(0).click(); //r yhazınca önerilenklerden lkine tıklar.*/


        //DATE PICKER

        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();

        WebElement datePicker = driver.findElement(By.id("datePickerMonthYearInput"));
        datePicker.click();

        WebElement month=driver.findElement(By.className("react-datepicker__month-select"));

        Select select = new Select(month);  //Dropdown'dan bi şey seçmek istediğimizde bu kütüphaneyi kullanmalıyız.

        select.selectByVisibleText("December");

        WebElement year=driver.findElement(By.className("react-datepicker__year-select"));
        select = new Select(year);
        select.selectByVisibleText("2019");

       List<WebElement> days=driver.findElements(By.cssSelector("div.react-datepicker__day"));

       for(WebElement day:days)
       {
          // System.out.println(day.getText());
          String dayText=day.getText();
            if(dayText.equals("18"))
           {
            day.click();
            break;
           }
       }





    }

    public static boolean isFileDownloaded(String downloadPath, String fileName)
    {
        File file =new File(downloadPath);
        File[] files=file.listFiles();

        for(int i=0; i < files.length;i++) {
            if (files[i].getName().equals(fileName))
            {
                files[i].delete();
                return true;
            }
        }
        return  false;
    }
}
