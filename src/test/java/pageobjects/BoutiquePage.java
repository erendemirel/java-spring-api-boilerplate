package pageobjects;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testprojectcore.util.Helper;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BoutiquePage extends DriverUtils {


    @FindBy(css = ".p-card-img")
    List<WebElement> productImages;

    @FindBy(className = "name")
    List<WebElement> productNames;



    public BoutiquePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickARandomProduct(){
        int randomElementIndex
                = ThreadLocalRandom.current().nextInt(productImages.size()) % productImages.size();
        productImages.get(randomElementIndex).click();
    }

    public void checkIfProductImagesAreDisplayed() throws Exception {
        for (WebElement productImage : productImages) {
            Helper.isImageDisplayed(productImage);
        }
    }
}
