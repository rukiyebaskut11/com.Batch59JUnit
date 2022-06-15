package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_HandleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {

        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();


        //2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);


        /*
        CDwindow-F699C74F9412CBFB7193F366E9720B29
        bu kod acilan sayfanın unique hash kodudur
        Selenium sayfalar arası gecişte bu window handle degerini kullanır


        eger sayfalar arasında driver imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-F699C74F9412CBFB7193F366E9720B29");
        bu sayfanın window handle degerini girerek bu sayfaya gecisi saglayabiliriz
         */

        //3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect']"));

        driver.switchTo().newWindow(WindowType.TAB);
        /*
        bu komutu kullandıgımızda driver otomatik olarak olusturalım
        new tab a gecer
        yeni tab da görevi gerceklestirmek icin
        adimlari bastan almamiz gerekir

         */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));



        //4- yeni tab da acilan urunun title ini yazdirin
        WebElement urnTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));


        //5- ilk sayfaya gecip Url i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());

    }


}
