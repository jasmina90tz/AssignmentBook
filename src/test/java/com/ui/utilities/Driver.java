package com.ui.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.Collections;

public class Driver{
    private Driver() {}

        private static WebDriver driver;

        public static WebDriver get() {
            ChromeOptions options = new ChromeOptions();
            if (driver == null) {
                String browser = ConfigurationReader.get("browser");
                System.out.println("browser = " + browser);
                switch (browser) {
                    case "chrome":
                        // WebDriverManager.chromedriver().create();
                        WebDriverManager.chromedriver().clearDriverCache().setup();
                        // WebDriver driver = new ChromeDriver();
                        //WebDriverManager.chromedriver().driverVersion(getChromeVersion()).setup();
                        // ChromeOptions options = new ChromeOptions();
                        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                        options.addArguments("-incognito");
                        options.addArguments("-disable-cache");
                        driver = new ChromeDriver(options);
                        driver.manage().deleteAllCookies();
                        driver.manage().window().maximize();

                        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                        options.addArguments("-incognito");
                        options.addArguments("-disable-cache");
                        options.addArguments("disable-popup-blocking");
                        options.addArguments("test-type");
                        options.addArguments("start-maximized");
                        options.addArguments("no-sandbox");
                        options.addArguments("disable-infobars");
                        options.addArguments("disable-dev-shm-usage");
                        options.addArguments("disable-browser-side-navigation");
                        options.addArguments("disable-gpu");
                        options.setExperimentalOption("prefs", Collections.singletonMap("download.prompt_for_download", false));
                        options.setExperimentalOption("prefs", Collections.singletonMap("download.directory_upgrade", true));

                        String projectRoot = System.getProperty("user.dir");
                        String downloadDir = projectRoot + "/src/test/resources/downloads";
                        options.setExperimentalOption("prefs", Collections.singletonMap("download.default_directory", downloadDir));
//                    WebDriver driver = new ChromeDriver(options);
//                    driver.manage().deleteAllCookies();
//                    driver.manage().window().maximize();
                        break;
                    case "chromeHeadless":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(
                                options.addArguments("--headless=new", "--disable-gpu", "---window-size=1920,1080",
                                        "--allow-insecure-localhost", "--acceptInsecureCerts",
                                        "--disable-blink-features=AutomationControlled", "--disable-extensions",
                                        "--remote-allow-origins=*"));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().deleteAllCookies();
                        //driver.manage().window().maximize();
                        break;
                    case "firefoxHeadless":
                        WebDriverManager.firefoxdriver().setup();
                        // driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                        break;

                    case "ie":
                        if (System.getProperty("os.name").toLowerCase().contains("mac"))
                            throw new WebDriverException("You are operating Mac OS which doesn't support Internet Explorer");
                        WebDriverManager.iedriver().setup();
                        driver = new InternetExplorerDriver();
                        break;

                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;

                    case "safari":
                        if (System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("You are operating Windows OS which doesn't support Safari");
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver = new SafariDriver();
                        break;
                }
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }

        public static void closeDriver() {
            if (driver != null) {
                //driver.switchTo().alert().accept();
                driver.quit();
                driver = null;
            }
        }
    }
