package aws.lambda.micronaut.workshop;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import javax.inject.Inject;

public class AbstractRestIntegrationTest {

  @Inject
  @Client("/")
  protected RxHttpClient client;
}
