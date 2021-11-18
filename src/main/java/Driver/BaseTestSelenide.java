package Driver;

import Properties.PropertyReader;
import TestNG.ListenerSelenide;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Listeners(ListenerSelenide.class)
public class BaseTestSelenide {

    public <T> T get(Class<T> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass): open("https://moodpanda.com/", pageObjectClassClass);
    }

    public <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass, String env) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(env);
        return get(pageObjectClassClass);
    }
}
