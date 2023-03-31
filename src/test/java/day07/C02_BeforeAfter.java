package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;




public class C02_BeforeAfter {


    @Before
    public void setUp() {

        System.out.println("Her test methodu öncesinde bir kez çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodu sonrası bir kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk Test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }
}
