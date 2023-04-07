package day12_WindowHandle_BasicAuth_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

     /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void name() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie w : allCookies) {
            System.out.println("Cookie ismi : " + w.getName() + "   ||    Cookie değeri : " + w.getValue());
        }
        //allCookies.forEach(System.out::println); ==> Lambda ile

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(allCookies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie myCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(myCookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        String yeniCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals("cikolatali",yeniCookieValue);

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int cookieSilinmedenOnce = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int cookieSilindiktenSonra = driver.manage().getCookies().size();
        Assert.assertEquals(1, (cookieSilinmedenOnce - cookieSilindiktenSonra));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertEquals(0,driver.manage().getCookies().size());

    }
}
