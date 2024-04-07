package es.technical.test.microservices.prices.it.context;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 */
@Setter
@Getter
@Accessors(fluent = true)
@Component
public class CucumberContext {

  private ResponseEntity<JsonNode> responseEntity;
  private RequestEntity<?> requestEntity;

  public void reset() {
    responseEntity = null;
    requestEntity = null;
  }

}