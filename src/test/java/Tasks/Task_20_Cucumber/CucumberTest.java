package Tasks.Task_20_Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/feature/booking.feature"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"Tasks/Task_20_Cucumber/steps"}
        )
public class CucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
