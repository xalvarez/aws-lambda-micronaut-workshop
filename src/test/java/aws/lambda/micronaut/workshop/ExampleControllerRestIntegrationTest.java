package aws.lambda.micronaut.workshop;

import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.BDDAssertions.then;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ExampleControllerRestIntegrationTest extends AbstractRestIntegrationTest {

  @Test
  public void shouldReplyPongToPing() {
    String givenExpectedResponseBody = "{\"pong\":true, \"graal\": true}";

    var response = client.toBlocking().exchange("/ping", String.class);

    then(response.getStatus().getCode()).isEqualTo(OK.getStatusCode());
    then(response.body()).isEqualTo(givenExpectedResponseBody);
  }
}
