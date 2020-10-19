package testprojectcore.base;

import com.github.javafaker.Faker;
import testprojectcore.dataprovider.ConfigFileReader;
import testprojectcore.dataprovider.JsonFileParser;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class DriverUtils extends Driver {

    public static Wait fluentWait;

    static long timeOutInSeconds = 10;

    public static WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);

    public static Actions actions = new Actions(driver);

    public static Faker faker = Faker.instance();

    private final static Logger logger = Logger.getLogger("GlobalLogger");

    static int randomNum = ThreadLocalRandom.current().nextInt(10000, Integer.MAX_VALUE);

    private static String REMOTE_URL;


    public DriverUtils() {
    }


    public static Wait getWebDriverWait() {
        return webDriverWait;
    }

    public static Actions getActions() {
        return actions;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static int getRandomNumber() {
        return randomNum;
    }

    public static void closeDriver() {
        driver.close();
    }


    public static void waitUntil(ExpectedCondition<WebElement> condition, long waitDurationInSeconds, WebDriver driver) {
        (new WebDriverWait(driver, waitDurationInSeconds)).until(condition);
    }


    public String getJsonFileParser(String dataGroup, String requestedData) throws Exception {
        return JsonFileParser.getInstance().parseJsonFileAndReturnRequestedDAta(dataGroup, requestedData);
    }

    public static ConfigFileReader getConfigFileReader() {
        return ConfigFileReader.getInstance();
    }

    public static void initDriver() {
        String browser = null;
        try {
            browser = System.getProperty("browser").toLowerCase();
        } catch (Exception e) {
            logger.warn("browser parameter was not passed in run command, setting the value from the properties file");
            browser = ConfigFileReader.getInstance().getBrowser().toLowerCase();
        }
        ChromeOptions chromeOptions = new ChromeOptions();          //Chrome options
        chromeOptions.addArguments("--disable-notifications");
        FirefoxOptions firefoxOptions = new FirefoxOptions();           //Firefox options
        firefoxOptions.setCapability("marionette", true);
        firefoxOptions.addPreference("permissions.default.desktop-notification", 0);
        if (getConfigFileReader().getEnablePerformanceLogs()) {
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
            chromeOptions.setCapability("goog:loggingPrefs", logPrefs);
            firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
        }
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", ConfigFileReader.getInstance().getDriverPathFirefoxWindows());
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPathChromeWindows());
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPathChromeWindows());
                    driver = new ChromeDriver(chromeOptions);
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("nix") || System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().indexOf("aix") > 0) {
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", ConfigFileReader.getInstance().getDriverPathFirefoxLinux());
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPathChromeLinux());
                    driver = new ChromeDriver(chromeOptions);
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPathChromeWindows());
                    driver = new ChromeDriver(chromeOptions);
            }
        }

        if (getConfigFileReader().getIfStartMaximized()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(), TimeUnit.SECONDS);
    }
}


