package pageobjects;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends DriverUtils {


    @FindBy(xpath = "//a[@title='Close']")
    WebElement fancyBoxCloseButton;

    @FindBy(css = "i[class='icon navigation-icon-user']")
    WebElement loginButton;

    @FindBy(css = "a.category-header")
    List<WebElement> categoryHeaders;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void navigateToHomepage(){
        driver.get("https://www.trendyol.com/");
    }

    public void closeFancyBox(){
        fancyBoxCloseButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void waitForLoginButtonToBeClickable(){
        waitUntil(ExpectedConditions.elementToBeClickable(loginButton), 10, driver);
    }


}
