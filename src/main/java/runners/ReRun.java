package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Karate.class
@CucumberOptions(
        features = "@target/uiFailedTests.txt",
        glue = "stepdefinitions",
        dryRun = false,

        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)


public class ReRun {
}
