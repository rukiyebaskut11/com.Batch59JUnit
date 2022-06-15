package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_TumSayfaScreenShot extends TestBase {

    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasina gidip tum sayfanin fotografini cekelim

        driver.get("https://amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();

        System.out.println(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        //File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa.jpeg");alt satirdaki gb dinamik yapabiliriz
        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa.jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaResim);


    }
}
