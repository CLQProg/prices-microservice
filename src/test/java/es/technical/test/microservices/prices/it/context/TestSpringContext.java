package es.technical.test.microservices.prices.it.context;

import es.technical.test.microservices.prices.PricesApplication;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = {
    PricesApplication.class})
@ActiveProfiles("test")
public class TestSpringContext {

  @Autowired
  private CucumberContext context;

  @Before
  public void initializeContext() {
    context.reset();
  }

}