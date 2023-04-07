package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    //Orn: TestBase base = new TestBase()
    //Bu class'a extends ettiğimiz test classlarından ulaşabiliriz
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    //HARD WAİT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alert DİSMİSS
    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Alert getText
    public void alertText() {
        driver.switchTo().alert().getText();
    }

    //Alert promptBox
    public void alertPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void ddmValue(WebElement ddm, String Value) {
        Select select = new Select(ddm);
        select.selectByValue(Value);
    }

    //SwitchTo: Sayfalar arası geçiş methodu:
    //Indeks 0'dan başlar
    //Girilen indeksteki winwHandle değerini alarak o sayfaya geçiş yapar.
    public static void switchWindow(int sayfaIndeksi) {

        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(sayfaIndeksi));

    }


}