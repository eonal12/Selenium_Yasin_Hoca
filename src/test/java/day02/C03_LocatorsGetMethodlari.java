package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03_LocatorsGetMethodlari {
    public static void main(String[] args) {


//Amazon sayfasına gidin
//Search bölümünü locate edip, "Tablet" aratalım
//Arama sonuç yazısında Tablet yazısını locate edip konsola yazdırın
//Sayfayı kapatın

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

        //Amazon sayfasına gidin
        driver.get("https://www.amazon.com");

        //Search bölümünü locate edip, "Tablet" aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Tablet");
        aramaKutusu.submit();

        //Arama sonuç yazısında Tablet yazısını locate edip konsola yazdırın
        WebElement aramaSonucu = driver.findElement(By.className("sg-col-inner"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());

        //Sayfayı kapatın
        driver.close();

    }
}
