package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber.features/",
        glue = {"testprojectcore", "stepdefs"},
        tags = "@tests"
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

