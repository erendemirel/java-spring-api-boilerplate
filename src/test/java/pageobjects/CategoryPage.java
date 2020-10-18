package pageobjects;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testprojectcore.util.Helper;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CategoryPage extends DriverUtils {


    @FindBy(css = "a[data-type='banner'] img")
    List<WebElement> boutiqueImages;



    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkIfBoutiqueImagesAreDısplayed() {
        for (WebElement boutiqueImage : boutiqueImages) {
            Helper.isImageDisplayed(boutiqueImage);
        }
    }

    public void clickARandomBoutique(){
        int randomElementIndex
                = ThreadLocalRandom.current().nextInt(boutiqueImages.size()) % boutiqueImages.size();
        boutiqueImages.get(randomElementIndex).click();
    }
}
