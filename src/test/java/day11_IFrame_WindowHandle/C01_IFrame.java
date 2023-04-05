package day11_IFrame_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
        /*
   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */

    @Test
    public void iFrame01() {
        //   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String sayfaBaslik = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(sayfaBaslik.contains("Editor"));

        //   TextBox iFrame içerisinde yer aldığı için önce iFrame'e geçiş yapmalıyız
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);

        //   Textbox içindeki yazıyı siliniz.
        WebElement textBox = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        textBox.clear();

        //   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());
    }
}
