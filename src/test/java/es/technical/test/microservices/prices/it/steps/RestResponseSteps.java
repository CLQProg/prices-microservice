package es.technical.test.microservices.prices.it.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.technical.test.microservices.prices.it.context.CucumberContext;
import es.technical.test.microservices.prices.it.utils.IoUtils;
import io.cucumber.java.en.Then;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Objects;


public class RestResponseSteps {

  @Autowired
  private CucumberContext context;
  @Autowired
  private ObjectMapper objectMapper;

  @Then("the response status code is {int}")
  public void assertHttpRequestResult(final int httpStatus) {
    Assertions.assertEquals(httpStatus, context.responseEntity().getStatusCode().value());
  }

  @Then("the response body contains {}")
  public void assertResponseBodyIsJsonExample(final String fileName) throws IOException {
    final byte[] bytes = IoUtils.read(
        Objects.requireNonNull(getClass().getResourceAsStream("/api/" + fileName)));

    final JsonNode expectedJson = objectMapper.readTree(bytes);

    Assertions.assertNotNull(context.responseEntity().getBody());
    String actual = objectMapper.writeValueAsString(context.responseEntity().getBody());
    try {
      JSONAssert.assertEquals(expectedJson.toPrettyString(), actual, JSONCompareMode.NON_EXTENSIBLE);
    } catch (JSONException e) {
      throw new RuntimeException(e);
    }
  }

  @Then("the response body is null")
  public void assertResponseBodyIsNull() {
    Assertions.assertNull(context.responseEntity().getBody());
  }

  @Then("the response body is empty")
  public void assertResponseBodyIsEmpty() {
    Assertions.assertNull(context.responseEntity().getBody());
  }

  @Then("the response body is not null")
  public void assertResponseBodyIsNotNull() {
    Assertions.assertNotNull(context.responseEntity().getBody());
  }

}
