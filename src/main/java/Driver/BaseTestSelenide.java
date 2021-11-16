package Driver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class BaseTestSelenide {

    public <T> T get(Class<T> pageObjectClassClass) {
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass): open("https://moodpanda.com/", pageObjectClassClass);
    }
}
