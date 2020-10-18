package testprojectcore.util;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class Helper {


    public static void clickBlankSpace() {
        DriverUtils.getDriver().findElement(By.xpath("//html")).click();
    }


    public static int checkAllCheckboxes(List<WebElement> checkboxes) {
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
        return checkboxes.size();
    }


    public static void selectFromDrowpdownByVisibleText(WebElement webElement, String visibleText) {
        Select select = new Select(webElement);
        select.selectByVisibleText(visibleText);
    }


    public static void fillInInputField(WebElement webElement, String valueToEnter) {
        webElement.sendKeys(valueToEnter);
    }


    public static List<String> getAttributeValuesAccordingToATag(List<WebElement> elementsAccordingToTagName, String attributeToGetValueOf) {
        List<String> attributeValues = new ArrayList<>();
        for (WebElement element : elementsAccordingToTagName) {
            attributeValues.add(element.getAttribute(attributeToGetValueOf));
        }
        return attributeValues;
    }

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

