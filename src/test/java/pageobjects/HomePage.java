package pageobjects;

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

    @FindBy(css = "i[class='icon navigation-icon-user']")
    WebElement loginButton;

    @FindBy(css = "a[class='category-header']")
    List<WebElement> categoryHeaders;

    @FindBy(css = "div#notification-popup .modal-close")
    WebElement indirimleriKacirmaPopup;



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
        loginButton.click();
    }

    public void waitForLoginButtonToBeClickable() {
        waitUntil(ExpectedConditions.elementToBeClickable(loginButton), 10, driver);
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
