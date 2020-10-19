package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import testprojectcore.base.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testprojectcore.util.Helper;

import java.util.List;

public class HomePage extends DriverUtils {


    @FindBy(xpath = "//a[@title='Close']")
    WebElement fancyBoxCloseButton;

    @FindBy(id = "accountBtn")
    WebElement loginButton;

    @FindBy(css = "a[class='category-header']")
    List<WebElement> categoryHeaders;

    @FindBy(css = "div#notification-popup .modal-close")
    WebElement indirimleriKacirmaPopup;

    @FindBy(xpath = "//img[@class='trendyol-logo-c']")
    WebElement trendyolLogo;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToHomepage() {
        driver.get("https://www.trendyol.com/");
    }

    public void closeFancyBoxIfExists() {
        if (fancyBoxCloseButton.isDisplayed()) {
            fancyBoxCloseButton.click();
        }
    }

    public void clickLoginButton() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        int yScrollPosition = loginButton.getLocation().getY();
        javascriptExecutor.executeScript("window.scroll(0, " + yScrollPosition + ");");
        loginButton.click();
    }

    public void waitForLoginButtonToBeClickable() throws InterruptedException {
//        waitUntil(ExpectedConditions.elementToBeClickable(trendyolLogo), 10, driver);
        Thread.sleep(500);      //Unfortunately
    }

    public void clickCategoryHeadersAccordingToALoopIndex(int loopIndex) {
        categoryHeaders.get(loopIndex).click();
    }

    public int returnCategoryHeadersListSize() {
        return categoryHeaders.size();
    }

    public void closeIndirimleriKacirmaPopupIfExists() {
        if (indirimleriKacirmaPopup.isDisplayed()) {
            indirimleriKacirmaPopup.click();
        }
    }
}
