package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features/TestScenario.feature",
        glue = "TestMethods",
        dryRun = false,
        tags = "not @ignore",
        plugin = {
                "pretty","html:login-negative.html"
        }


)
public class Automate {
}
