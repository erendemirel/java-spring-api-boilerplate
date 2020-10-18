package pageobjects;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BoutiquePage extends DriverUtils {


    @FindBy(className = "p-card-img short-product-image")
    List<WebElement> productImages;

    @FindBy(className = "name")
    List<WebElement> productNames;



    public BoutiquePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
