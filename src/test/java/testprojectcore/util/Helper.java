package testprojectcore.util;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;



public class Helper {

    public static boolean isImageDisplayed(WebElement imageToTest) {
        return (Boolean) ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imageToTest);
    }

    public static void waitForJavascript(int maxWaitMillis, int pollDelimiterInMillis) throws InterruptedException {
        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + maxWaitMillis) {
            String prevState = DriverUtils.getDriver().getPageSource();
            Thread.sleep(pollDelimiterInMillis);
            if (prevState.equals(DriverUtils.getDriver().getPageSource())) {
                return;
            }
        }
    }
}

