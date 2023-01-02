package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features/WebAutomation.feature",
        glue = "testMethods",
        dryRun = false,
        tags = "not @ignore",
        plugin = {
                "pretty","html:login-negative.html"
        }


)
public class Automate {
}
