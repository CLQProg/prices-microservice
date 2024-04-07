package es.technical.test.microservices.prices.it;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "es.technical.test.microservices.prices.it",
    plugin = {"pretty"},
    tags = "not @ignore")
public class CucumberTest {

}