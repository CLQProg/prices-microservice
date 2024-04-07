package es.technical.test.microservices.prices.it.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;


/**
 * Input/Output utils.
 */
@Slf4j
public class IoUtils {

  /**
   * Default size for buffers used in this class.
   */
  public static final int BUF_SIZE = 2048;

  /**
   * Hide constructor.
   */
  private IoUtils() {
  }

  /**
   * Fully read the given stream and return its bytes.
   *
   * @param is the stream to read from.
   * @return the bytes read.
   * @throws IOException if any {@link IOException} is thrown during the process.
   */
  public static byte[] read(final InputStream is) throws IOException {
    final byte[] buffer = new byte[BUF_SIZE];
    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    int iterator;
    while ((iterator = is.read(buffer, 0, BUF_SIZE)) > 0) {
      baos.write(buffer, 0, iterator);
    }
    return baos.toByteArray();
  }

}
