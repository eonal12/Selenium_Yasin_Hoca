package day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_Examples {
    /*
       Browser'ı açıp maximize yapın
       Tüm sayfa için maksimum bekleme süresi olarak 15 saniye belirleyin
       Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin
       Amazon sayfasına geri dönün
       Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
       Sayfanın konumunu ve boyutunu yazdırın
       Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
       İstediğiniz şekilde olup olmadığını test edin
       Sayfayı kapatın
        */
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

//         Browser'ı açıp maximize yapın
        driver.manage().window().maximize();

//         Tüm sayfa için maksimum bekleme süresi olarak 15 saniye belirleyin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//         Sırasıyla Amazon, Facebook ve Youtube sayfalarına gidin
        driver.get("https://amazon.com");
        driver.get("https://facebook.com");
        driver.get("https://youtube.com");

//         Amazon sayfasına geri dönün
        driver.navigate().back();
        driver.navigate().back();

//         Amazon sayfasının adresinin(Url) https://www.amazon.com/ adresine eşit olduğunu test edin
        String actualUrl = driver.getCurrentUrl();//Asıl URL
        String expectedUrl = "https://www.amazon.com/";//Beklenen URL

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Url Testi PASSED");
        } else {
            System.out.println("Url Testi FAILED");
        }

//         Sayfanın konumunu ve boyutunu yazdırın
        System.out.println("Sayfa konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfa boyutu: " + driver.manage().window().getSize());

//         Sayfanın konumunu ve boyutunu istediğimiz şekilde ayarlıyın
        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(600, 600));
        System.out.println("Sayfa yeni konumu: " + driver.manage().window().getPosition());
        System.out.println("Sayfa yeni boyutu: " + driver.manage().window().getSize());

//         İstediğiniz şekilde olup olmadığını test edin
        Point actualPosition = driver.manage().window().getPosition();//Konum bilgilerini getPosition() methodu ile bir Point container'ı içerisine koyuyoruz.
        if (actualPosition.getX() == 50 && actualPosition.getY() == 50) {//x ve y değerlerini Point container'ından alarak karşılaştırıyoruz
            System.out.println("Konum testi PASSED");
        } else {
            System.out.println("Konum testi FAILED");
        }

        Dimension actualDimension = driver.manage().window().getSize();//Boyut bilgilerini getSize() methodu ile bir Dimension container'ı içerisine koyuyoruz.
        if (actualDimension.getWidth() == 600 && actualDimension.getHeight() == 700) {//width(en) ve height(boy) değerlerini Dimension container'ından alarak karşılaştırıyoruz
            System.out.println("Boyut testi PASSED");
        } else {
            System.out.println("Boyut testi FAILED");
        }

//         Sayfayı kapatın
        driver.close();

    }
}