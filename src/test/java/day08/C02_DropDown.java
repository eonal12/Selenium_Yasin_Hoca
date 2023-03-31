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
import java.util.List;

public class C02_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        //1.Locate DropDown Element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        //Select objesi oluştur
        Select yearDropDown = new Select(year);

        //Select objesini kullanarak 3 farklı şekilde seçim yapabiliriz:
        //selectByIndex---selectByValue--SelectByVisibleText
        Thread.sleep(2000);
        yearDropDown.selectByIndex(22);//Seçenek 0'dan başlar. 2001 yılı 22. seçenek

        //Ay seçimi
        Thread.sleep(2000);//Sadece seçimleri görebilmek için koyuyoruz.Automation'da buna gerek yok
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropDown = new Select(month);
        monthDropDown.selectByVisibleText("July");

        //Gün seçimi
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropDown = new Select(day);
        dayDropDown.selectByValue("28");
    }

    @Test
    public void printAllStates() throws InterruptedException {
        //Tüm eyalet isimlerini yazdıralım
        Thread.sleep(2000);
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown = new Select(state);
        List<WebElement> stateList = stateDropDown.getOptions();
        stateList.stream().skip(1).forEach(t-> System.out.println(t.getText()));//lambda ile yazdık skip'i kullanarak
        //Ya da foreach loop ile de yazdırabiliriz                                  ilk secenek olan "Select a State" eyalet olmadığı için onu almadık
        for (WebElement w : stateList) {
            System.out.println(w.getText());
        }
    }
}
