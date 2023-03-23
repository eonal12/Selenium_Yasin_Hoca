package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver","src/resources/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //techproeducation sayfasina gidelim:
        driver.get("https://www.techproeducation.com");

        System.out.println("sayfanin konumu: "+ driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari: "+ driver.manage().window().getSize());

        //Sayfayi minimize() yap (simge durumuna kucult)
        driver.manage().window().minimize();

        //Sayfayi maximize() yap (buyuk ekran yap)
        Thread.sleep(2000);
        driver.manage().window().maximize();

        System.out.println("sayfanin konumu: "+ driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari: "+ driver.manage().window().getSize());

        //Sayfayi fullscreen yapma
        Thread.sleep(2000);
        driver.manage().window().fullscreen();

        System.out.println("sayfanin konumu: "+ driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutlari: "+ driver.manage().window().getSize());

        driver.close();





    }
}