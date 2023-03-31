package day08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDownOdev {

    //https://the-internet.herokuapp.com/dropdown adresine gidin
        //Index kullanarak Seçenek 1'i (Option 1) seçin ve yazdırın
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //Visible Text(Görünen metin) kullanarak Seçenek 1'i (Option 1) seçin ve yazdırın
        //Tüm dropdown değerleri(value) yazdırın
        //Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, degilse False yazdırın

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Test//Index kullanarak Seçenek 1'i (Option 1) seçin ve yazdırın
    public void Index() {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown);
        options.selectByIndex(1);
        System.out.println(options.getOptions().get(1).getText());
    }

    @Test//Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    public void Value() {
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown);
        options.selectByValue("2");
        System.out.println(options.getOptions().get(2).getText());
    }
}
