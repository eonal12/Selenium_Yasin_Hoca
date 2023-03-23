package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02_WebElementsVELocators {
    public static void main(String[] args) {


        //Amazon sayfasına gidin
        //Search kutusunu locate edin
        //Search kutusunda iphone aratın
        //Sayfadaki <input> ve <a> tag'larinin sayısını yazdırın
        //Sayfayı kapatınız

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Amazon sayfasına gidin
        driver.get("https://www.amazon.com");

        //Search kutusunu locate edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //Search kutusunda iphone aratın
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);

        /*
        Bir Webelementini locate etmek istersek önce sayfayı açıp element üzerinde sağ tıklayıp incele diyoruz.Karşımıza çıkam HTML kodlarından
        eşsiz olanı locate almak için kullanıyoruz.
        Genellikle "id" attribute'ü eşsiz olarak kullanılır.
         */

        //Sayfadaki <input> ve <a> tag'larinin sayısını yazdırın
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("input tag sayısı :" + inputList.size());

        List<WebElement> aTagList = driver.findElements(By.tagName("a"));
        System.out.println("Link Sayısı: " + aTagList.size());

        //Sayfayı kapatınız
        driver.close();



    }
}
