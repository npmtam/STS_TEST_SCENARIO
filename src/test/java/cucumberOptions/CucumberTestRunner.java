package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = false,
        plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json"},
        snippets = SnippetType.UNDERSCORE,
        tags = {"@GoogleScenarios"})

public class CucumberTestRunner {

}