package es.technical.test.microservices.prices.it.steps;

import com.fasterxml.jackson.databind.JsonNode;
import es.technical.test.microservices.prices.it.context.CucumberContext;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;


public class RestExecutionSteps {

  @Autowired
  private CucumberContext context;
  @Autowired
  private TestRestTemplate restTemplate;

  @When("http request executed")
  public void executeHttpRequest() {
    context.responseEntity(restTemplate.exchange(context.requestEntity(), JsonNode.class));
  }

}
