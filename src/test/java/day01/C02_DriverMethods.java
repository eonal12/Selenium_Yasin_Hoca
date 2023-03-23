package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/msedgedriver.exe");

        WebDriver driver=new EdgeDriver(); //sade bu yazildigin bos bor browser acar

        driver.get("https://www.google.com"); //gitmek istedigimiz sayfayi belirtiriz

        System.out.println("Sayfa basligi: "+driver.getTitle()); //Sayfa basligini getirir

        System.out.println("Sayfanin adresini: "+driver.getCurrentUrl()); //Sayfani adresini verir

        //  System.out.println("Sayfa kodlari: "+driver.getPageSource()); //Sayfa kodlarini getirir

        //sayfanin(window) hash degerini verir.
        // //Bu hash degeleri ile baska sayfadan bu sayfaya direk donmeyi saglar yani sayfalar arasi gecis
        System.out.println("sayfanin hash degeri: "+ driver.getWindowHandle());

    }

}