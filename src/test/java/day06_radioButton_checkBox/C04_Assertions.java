package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown()  {
        driver.close();

    }

    @Test
    public void test01(){
        /*
        eger Test method umuzda hiçbir test yoksa, test calıstıktan sonra
        hiçbir problemle karsılasılmadıgını raporlamak icin "test passed" yazisi cikar

        Eger testleri if ile yaparsak
        test failed olsa bile kodlar problemsiz calıstıgı icin
        kod calismasi bittiginde
        ekranin sol alt kısmında test passed yazacaktır

         */
        driver.get("https://www.amazon.com");

        // url in https://www.facebook.com  oldugunu test edin
      /*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("url testi PASSED");
        }else {
            System.out.println("url testi FAILED");
        }
       */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
