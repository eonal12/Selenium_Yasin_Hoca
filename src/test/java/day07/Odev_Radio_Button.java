package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_Radio_Button {
    WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void radioButton() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement radioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if (!radioButton.isSelected()){
            radioButton.click();
        }
    }
}
