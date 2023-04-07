package day12_WindowHandle_BasicAuth_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class C01_WindowHandle extends TestBase {

        /*
 https://www.techproeducation.com adresine gidiniz
 Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
 Tab 2'de https://www.google.com sayfasını açınız
 Tab 3'te https://www.linkedin.com sayfasını açınız
 techproeducation sayfasına geçiniz
 youtube sayfasına geçiniz
 linkedIn sayfasına geçiniz
  */



    @Test
    public void newTabTest() {
        // https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        // Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        // Tab 2'de https://www.google.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");
        System.out.println(driver.getTitle());

        //Sayfa başlığının "Google" olduğunu doğrulayınız
        Assert.assertEquals("Google",driver.getTitle());

        // Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");

        //Sayfa başlığının "LinkedIn" içerdiğini doğrulayınız
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //Önce Window handdle Set'ini bir List içerisine alıyoruz(İndeksle çalışabilmek için)

        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandleList);

        //Artık List ile indeks kullarak ilgili windowHandle değerine ulaşabiliriz:
        //[E6AD324FD26FB858CB456ED88750D65E, B4667B68C494D75B73BD0EDA8D426245, C9E5C9E0D8F83F0AE360522BCCD1CDC8]  
        // techproeducation sayfasına geçiniz
        bekle(2);
        driver.switchTo().window(windowHandleList.get(0));
        

        // google sayfasına geçiniz
        bekle(2);
        driver.switchTo().window(windowHandleList.get(1));
        

        // linkedIn sayfasına geçiniz
        bekle(2);
        driver.switchTo().window(windowHandleList.get(2));
    }

    @Test//Bu sefer sayfa geçişleri için TestBase'de oluşturduğumuz switchWindow() isimli methodumuzu kullanıcaz
    public void newTabTest2() {
        // https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        // Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        // Tab 2'de https://www.google.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");

        // Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");

        // techproeducation sayfasına geçiniz
        bekle(2);
        switchWindow(0);

        // youtube sayfasına geçiniz
        bekle(2);
        switchWindow(1);

        // linkedIn sayfasına geçiniz
        bekle(2);
        switchWindow(2);
    }
}
