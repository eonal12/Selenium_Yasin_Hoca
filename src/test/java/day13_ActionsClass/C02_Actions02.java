package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {
    
           /*
    Amazon anasayfasına gidin
    "Account & List" üzerinde bekleyin (mouse over - hover over)
    Açılan menüde "Account" linkine tıklayın
    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
     */

    @Test
    public void actionsTest() {

        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");

        //"Account & List" üzerinde bekleyin (mouse over - hover over)
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();

        //Açılan menüde "Account" linkine tıklayın

        //Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
    }
}
