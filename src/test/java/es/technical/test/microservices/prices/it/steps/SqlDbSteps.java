package es.technical.test.microservices.prices.it.steps;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlDbSteps {

  @Autowired
  private DataSource dataSource;

  @Given("clean the database with the sql file {word}")
  public void cleanUp(String file) throws SQLException {
    executeSql(dataSource, "/db/test-data/" + file);
  }


  @Given("inserts the data in the sql file into the database {}")
  public void importSqlData(final String file) throws SQLException {
    executeSql(dataSource, "/db/test-data/populate/" + file);
  }

  private void executeSql(DataSource dataSource, final String sqlResource) throws SQLException {
    final InputStream in = getClass().getResourceAsStream(sqlResource);
    Assertions.assertNotNull(in, "SQL Resource " + sqlResource + " not found!");
    try (final Connection conn = dataSource.getConnection()) {
      Scanner s = new Scanner(in);
      s.useDelimiter("(;(\r)?\n)|(--\n)");
      try (Statement st = conn.createStatement()) {
        while (s.hasNext()) {
          String line = s.next();
          if (line.startsWith("/*!") && line.endsWith("*/")) {
            int i = line.indexOf(' ');
            line = line.substring(i + 1, line.length() - " */".length());
          }
          if (!line.trim().isEmpty()) {
            st.execute(line);
          }
        }
      }
      if (!conn.getAutoCommit()) {
        conn.commit();
      }
    }
  }

}
