package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testprojectcore.base.DriverUtils;

import java.util.List;

public class ProductDetailsPage extends DriverUtils {


    @FindBy(xpath = "//div[@class='add-to-bs-tx']")
    WebElement addToCartButton;



    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilAddToCartButtonIsClickable() {
        waitUntil(ExpectedConditions.elementToBeClickable(addToCartButton), 10, driver);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

}
