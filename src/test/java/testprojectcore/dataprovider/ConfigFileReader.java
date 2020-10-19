package testprojectcore.dataprovider;

import java.io.*;
import java.util.Properties;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class ConfigFileReader {

    private final Properties properties;
    private String propertyFilePath = "src/test/resources/config/config.properties";
    private String driverPath;


    private static final ConfigFileReader configFileReader = new ConfigFileReader();

    public static ConfigFileReader getInstance() {
        return configFileReader;
    }

    private ConfigFileReader() {
        propertyFilePath = propertyFilePath.replace('/', File.separatorChar);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser").toUpperCase();
        if (browser != null) return browser;
        else throw new RuntimeException("Can not read browser from the cofniguration file");
    }

    public String getDriverPathChromeWindows() {
        driverPath = properties.getProperty("driverPathChromeForWindows");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("driverPath for Chrome for Windows not specified in the Configuration.properties file.");
    }

    public String getDriverPathFirefoxWindows() {
        driverPath = properties.getProperty("driverPathFirefoxForWindows");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("driverPath for Firefox Windows not specified in the Configuration.properties file.");
    }

    public String getDriverPathChromeLinux() {
        driverPath = properties.getProperty("driverPathChromeForLinux");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("driverPath for Chrome for Unix not specified in the Configuration.properties file.");
    }

    public String getDriverPathFirefoxLinux() {
        driverPath = properties.getProperty("driverPathFirefoxForLinux");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("driverPath for Firefox for Unix not specified in the Configuration.properties file.");
    }


    public long getImplicitlyWait() {
        String implicitWaitDuration = properties.getProperty("implicitWaitDuration");
        if (implicitWaitDuration != null) return Long.parseLong(implicitWaitDuration);
        else throw new RuntimeException("Implicit wait duration not specified in the Configuration properties file");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public boolean getIfStartMaximized() {
        String startMaximized = properties.getProperty("startMaximized");
        if (startMaximized != null && startMaximized.toLowerCase().equals("true")) return true;
        else if (startMaximized != null && startMaximized.toLowerCase().equals("false")) return false;
        else
            throw new RuntimeException("Property to determine if browser will start maximized not specified in the Configuration properties file");
    }

    public boolean getEnablePerformanceLogs() {
        String performanceLogs = properties.getProperty("performanceLogs");
        if (performanceLogs != null && performanceLogs.toLowerCase().contains("enable")) return true;
        else if (performanceLogs != null && performanceLogs.toLowerCase().contains("disable")) return false;
        else
            throw new RuntimeException("Property to determine whether browser performance logs will be produced not specified in the Configuration properties file");
    }

}


