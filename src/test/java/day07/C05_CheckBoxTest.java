package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBoxTest {
    WebDriver driver;


    //Verilen web sayfasına gidin. https://the-internet.herokuapp.com/checkboxes
    //Checkbox1 ve checkbox2 elementlerini locate edin
    //Checkbox1 seçili değil ise onay kutusunu tıklayın
    //Checkbox2 seçili değil ise onay kutusunu tıklayın

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void checkBoxTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }

        if (!checkBox2.isSelected()){
            checkBox2.click();
        }


    }
}
