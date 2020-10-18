package testprojectcore.driverutil;

import testprojectcore.base.DriverUtils;
import org.openqa.selenium.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * Creates an instance of given page class
 *
 * @author Eren Demirel <eren.demirel@payten.com>
 */
public class PageObjectFactory {


//    protected static FooPage fooPage;       //You can also register page objects here


    public static <T extends DriverUtils> T createClass(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getConstructor(WebDriver.class);
            return constructor.newInstance(DriverUtils.getDriver());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
