package pageobjects;

import testprojectcore.base.DriverUtils;
import testprojectcore.dataprovider.JsonFileParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverUtils {


    By usernameInputField = By.id("login-email");
    By passwordInputField = By.id("login-password-input");
    By submitLoginButton = By.xpath("//button[@type='submit']");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername() throws Exception {
        driver.findElement(usernameInputField).sendKeys(JsonFileParser.getInstance().parseJsonFileAndReturnRequestedDAta("trendyol.com webapp", "login.username"));
    }

    public void enterPassword() throws Exception {
        driver.findElement(passwordInputField).sendKeys(JsonFileParser.getInstance().parseJsonFileAndReturnRequestedDAta("trendyol.com webapp", "login.password"));
    }

    public void clickSubmit() {
        driver.findElement(submitLoginButton).click();
    }


}
