package com.optiim.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private DriverFactory() {
    }

    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver()  {
        Dimension dimension = new Dimension(ReadProperties.getViewPort()[0], ReadProperties.getViewPort()[1]);


        if (driverPool.get() == null) {

                switch (ReadProperties.getBrowser()) {
                    case "chrome":
                        ChromeOptions options = new ChromeOptions();
                        options.setHeadless(ReadProperties.getHeadLessStatus());
                        driverPool.set(new ChromeDriver(options));
                        break;

                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(ReadProperties.getHeadLessStatus());
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        break;

                    case "remote":
                        ChromeOptions browserOptions = new ChromeOptions();
                        browserOptions.setPlatformName("Windows 11");
                        browserOptions.setBrowserVersion("latest");
                        String hubURL = ReadProperties.getProperty("hubURL");
                        URL url = null;
                        try {
                            url = new URL(hubURL);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        driverPool.set(new RemoteWebDriver(url, browserOptions));
                        break;


            }

            if(ReadProperties.isMaximize()){
                driverPool.get().manage().window().maximize();
            }else{
                driverPool.get().manage().window().setSize(dimension);
            }
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();

        }
    }
}
