package day08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class C01_Assertion {

    /*
    1)https://amazon.com adresine gidin
    2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        titleTest  ==> Sayfa başlığının "Amazon" olduğunu test edin
        image Test ==> Amazon resminin görüntülendiğini (isDisplayed()) test edin
        Search Box'in erişilebilir olduğunu test edin(isEnabled())
        wrongTitleTest ==> Sayfa basliginin "amazon" içermediğini dogrulayın
     */
    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test// titleTest  ==> Sayfa başlığının "Amazon" olduğunu test edin
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        boolean iceriyorMu = actualTitle.contains(expectedTitle);
        assertTrue(iceriyorMu);
    }

    @Test//image Test ==> Amazon resminin görüntülendiğini (isDisplayed()) test edin
    public void imageTest() {
        boolean imageGorunurMu = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
        assertTrue(imageGorunurMu);
    }

    @Test//Search Box'in erişilebilir olduğunu test edin(isEnabled())
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        assertTrue(searchBox.isEnabled());
    }

    @Test//wrongTitleTest ==> Sayfa basliginin "amazon" içermediğini dogrulayın
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        assertFalse(actualTitle.contains(expectedTitle));
    }
}
