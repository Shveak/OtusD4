package org.otus.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Locale;

public class WebDriverFactory {
    private final String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);

    public EventFiringWebDriver getDriver() {
        switch (browser) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--homepage=about:blank");
                options.addArguments("--ignore-certificate-errors");
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                options.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC", "false")));
                WebDriverManager.chromedriver().setup();
                return new EventFiringWebDriver(new ChromeDriver(options));
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("browser.startup.page", 1);
                options.addPreference("browser.link.open_newwindow", 3);
                options.addPreference("browser.link.open_newwindow.restriction", 0);
                options.setCapability("marionette", true);
                WebDriverManager.firefoxdriver().setup();
                return new EventFiringWebDriver(new FirefoxDriver(options));
            }
            case "opera": {
                OperaOptions options = new OperaOptions();
                options.addArguments("private");
                options.setCapability(OperaOptions.CAPABILITY, options);
                WebDriverManager.operadriver().setup();
                return new EventFiringWebDriver(new OperaDriver(options));
            }
            default:
                throw new Error(String.format("Отсутствует драйвер для браузера '%s'", browser));
        }
    }
}
