package es.technical.test.microservices.prices.ut;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Abstract mockito test.
 */
@ExtendWith({MockitoExtension.class})
public abstract class UnitTest {

  /**
   * Podam factory.
   */
  private final PodamFactory podamFactory = new PodamFactoryImpl();

  /**
   * Constructor.
   */
  public UnitTest() {
  }

  /**
   * Get podam.
   *
   * @return podam.
   */
  protected PodamFactory getPodamFactory() {
    return podamFactory;
  }
}
