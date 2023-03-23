package day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01_Selenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/msedgedriver.exe");
/*
En temel haliyle otomasyon yapmak icin clss'imiza gerekli lan webdriver'in yerini belirtiyoruz
Java kutuphanesindeki Sytem.setProperty() mehtodu ile driver'i yazip fiziki yerini belirtiyoruz

 */

        WebDriver driver=new EdgeDriver(); //WebDriver bir interface'dir

        driver.get("https://www.google.com"); // bu sekilde kullanica daha cok method kullanabiliyoruz, implement sayesinde



    }


}