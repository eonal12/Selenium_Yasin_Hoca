package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C03_NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //Amazon sayfasina gidelim
        driver.navigate().to("http://www.amazon.com");
        // driver.get("http://www.amazon.com");

        //techpro sayfassina gidelim
        Thread.sleep(2000); // gecisler arai bekleme suresi. Java methodudur javada da kullanlir
        driver.navigate().to("http://techproeducation.com");
        // driver.get("https://techproeducation.com"); get methodu void'dir.

        Thread.sleep(2000);
        driver.navigate().back();

        //Sayfayi yenile (refresh)
        driver.navigate().refresh();

        //Sayfayi kapat
        driver.close();

        //Normalde sleep konulmaz biz burda yaptigimiz icin koyduk


    }
}