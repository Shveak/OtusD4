package org.otus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSelenoid {
    private WebDriver driver110;
    private WebDriver driver112;

    @Before
    public void init() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "110.0");
        capabilities.setCapability("enableVNC", true);
        driver110 = new RemoteWebDriver(new URL(System.getProperty("webdriver.base.url")), capabilities);
        capabilities.setCapability("browserVersion", "112.0");
        driver112 = new RemoteWebDriver(new URL(System.getProperty("webdriver.base.url")), capabilities);
    }

    @After
    public void tearDown() {
        if (driver110 != null) {
            driver110.close();
            driver110.quit();
        }
        if (driver112 != null) {
            driver112.close();
            driver112.quit();
        }
    }

    @Test
    public void test1() throws InterruptedException {
        driver110.get("http://127.0.0.1:8080");

        Thread.sleep(50000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver110.get("http://localhost:8080");
        Thread.sleep(50000);
    }

    @Test
    public void test3() throws InterruptedException {
        driver112.get("http://localhost:8080");
        Thread.sleep(50000);
    }

    @Test
    public void test4() throws InterruptedException {
        driver112.get("http://localhost:8080");
        Thread.sleep(50000);
    }

    @Test
    public void test5() throws InterruptedException {
        driver110.get("https://ya.ru");
        Thread.sleep(50000);
    }

    @Test
    public void test6() throws InterruptedException {
        driver110.get("https://ya.ru");
        Thread.sleep(50000);
    }

    @Test
    public void test7() throws InterruptedException {
        driver112.get("https://ya.ru");
        Thread.sleep(50000);
    }
}
