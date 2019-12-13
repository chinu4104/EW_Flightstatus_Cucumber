package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue={"stepdefinitions"},
        plugin={"pretty","html:cucumber-html-report"})
public class TestRunner {

}
