package es.technical.test.microservices.prices.it.steps.prices;


import es.technical.test.microservices.prices.it.context.CucumberContext;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringJoiner;

public class RestRequestSteps {

  @Autowired
  private CucumberContext context;


  @When("GET to prices at {string} of product {long} for brand {long}")
  public void getOfertas(final String date, final long productId, final long brandId) throws URISyntaxException {
    StringJoiner query = new StringJoiner("&").add("?");
    query.add("date=" + date);
    query.add("brandId=" + brandId);
    query.add("productId=" + productId);
    context.requestEntity(new RequestEntity<>(HttpMethod.GET, new URI("/v1/prices" + query)));
  }

}
