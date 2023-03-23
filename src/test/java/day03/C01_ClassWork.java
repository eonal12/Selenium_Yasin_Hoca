package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");

        //"city bike" araması yapın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike"+ Keys.ENTER);

        //Arama sonuç metnini yazdırın
        WebElement aramaSonucu = driver.findElement(By.className("sg-col-inner"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());

        //Sonuç sayısını yazdırın
        String sonucSayisi = aramaSonucu.getText().split(" ")[2];
        //Sonuc sayısını LAMBDA ile yazdırın
        //Çıkan ilk sonucun resmine tıklayın.
        //Sayfayı kapatın

    }
}
