package day11_IFrame_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import static org.junit.Assert.assertEquals;


public class C02_WindowHandle extends TestBase {
      /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini alın.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    "Click Here" butonuna tıklayın.
    Açılan pencereye geçin.
    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
    2. pencereye tekrar geçin.
    1. pencereye tekrar dönün.
     */

    @Test
    public void name() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //İlk sayfanın ID'sini alın.
        String ilkSayfa = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String ilkSayfaText = driver.findElement(By.xpath("//h3")).getText();
        assertEquals("Opening a new window",ilkSayfaText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String ilkSayfaTitle = driver.getTitle();
        assertEquals("The Internet",ilkSayfaTitle);

        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        System.out.println(driver.findElement(By.xpath("//div")).getText());

        //Açılan pencereye geçin.

        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        //2. pencereye tekrar geçin.
        //1. pencereye tekrar dönün.
    }
}
