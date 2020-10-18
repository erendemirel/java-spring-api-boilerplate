package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.IOException;

/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber.features/",
        glue = {"testprojectcore","stepdefs"},
        plugin = {"pretty", "json:target/cucumber-report.json", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "html:target/html/"},
        tags = "@test-tag"
)
public class CucumberRunnerTest {
    @AfterClass
    public static void killDriverProcess() throws RuntimeException, IOException {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
        } else if (System.getProperty("os.name").toLowerCase().contains("nix") || System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().indexOf("aix") > 0) {
            String[] cmd = new String[]{"/bin/sh", "kill_driver_process.sh"};
            Process pr = Runtime.getRuntime().exec(cmd);
        }
    }
}

