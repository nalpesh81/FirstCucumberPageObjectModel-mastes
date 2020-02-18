package FirstCucumberPageObjectModel;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;


import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSelector extends Utils {
    public static final String USERNAME = "Jash2006";
    public static final String ACCESS_KEY = "11490dae-b6dd-4ccf-ac31-22ba6dc531b3";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("sauce"));
    public static final String browser = System.getProperty("browser");
    LoadProps loadProps = new LoadProps();

    public void setUpBrowser() {
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);
        //if sauce lab is true................
        if (SAUCE_LAB) {
            System.out.println("Running in Saucelabs...........with browser " + browser);
            if (browser.equalsIgnoreCase("Chrome")) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "googlechrome");
                caps.setCapability("platformName", "Windows 10");
                caps.setCapability("browserVersion", "latest");
                MutableCapabilities sauceCaps = new MutableCapabilities();
                caps.setCapability("sauce:options", sauceCaps);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("w3c", true);
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("IE")) {
                MutableCapabilities sauceCaps = new MutableCapabilities();
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "internetexplorer");
                caps.setCapability("platformName", "Windows 10");
                caps.setCapability("browserVersion", "11.285");
                sauceCaps.setCapability("seleniumVersion", "2.53.1");
                sauceCaps.setCapability("iedriverVersion", "3.141.0");
                sauceCaps.setCapability("name", "Test using W3C protocol");
                caps.setCapability("sauce:options", sauceCaps);
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "68.0");
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "firefox");
                MutableCapabilities sauceCaps = new MutableCapabilities();
                sauceCaps.setCapability("seleniumVersion", "3.11.0");
                sauceCaps.setCapability("name", "Test using W3C protocol");
                caps.setCapability("sauce:options", sauceCaps);
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Safari")) {
                MutableCapabilities sauceCaps = new MutableCapabilities();
                SafariOptions safariOptions = new SafariOptions();
                sauceCaps.setCapability("browserName", "safari");
                sauceCaps.setCapability("platformName", "macOS 10.13");
                sauceCaps.setCapability("browserVersion", "11.1");
                sauceCaps.setCapability("seleniumVersion", "3.4.0");
                sauceCaps.setCapability("name", "Test using W3C protocol");
                //caps.setCapability("sauce:options",sauceCaps);
                try {
                    driver = new RemoteWebDriver(new URL(URL), sauceCaps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("Edge")) {
                MutableCapabilities sauceCaps = new MutableCapabilities();

                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", "Microsoft Edge");
                caps.setCapability("platformName", "Windows 10");
                caps.setCapability("browserVersion", "16.16299");
                sauceCaps.setCapability("seleniumVersion", "2.52.0");
                //sauceCaps.setCapability("edgedriverVersion","3.141.0");
                sauceCaps.setCapability("name", "Test using W3C protocol");
                caps.setCapability("sauce:options", sauceCaps);
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDrivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDrivers\\IEDriverServer.exe");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(internetExplorerOptions);
            } else {
                System.out.println("Browser name entered is either wrong or empty:" + browser);
            }
        }
    }
}
