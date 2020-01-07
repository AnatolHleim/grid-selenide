package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @BeforeTest
    public static void setUp() {
        Configuration.remote = "http://192.168.100.16:4444/wd/hub";
        Configuration.browser = "firefox";
        Configuration.headless = false;
        Configuration.proxyEnabled = true;
        Configuration.browserCapabilities.setAcceptInsecureCerts(true);
    }

    @Test
    public static void firstTest() {

        open("https://google.com/");
        $("[name=\"q\"]").sendKeys("ураааа!");
        $("[value=\"Поиск в Google\"]").click();
        Assert.assertEquals(title(), "ураааа! - Поиск в Google");

    }
    @Test
    public static void secondTest() {

        open("https://ya.ru/");
        $("[id=\"text\"]").sendKeys("ураааа!");
        $("[type=\"submit\"]").click();
        $("[class=\"navigation__region\"]").waitUntil(Condition.visible,8000);
        Assert.assertEquals(title(), "ураааа! — Яндекс: нашлось 13 тыс. результатов");

    }

    @AfterTest
    public static void fuck() {
        Configuration.remote = null;
    }
}