package aws.lambda.micronaut.workshop;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;

public abstract class AbstractRestIntegrationTest extends AbstractWireMockTest {

    @Inject
    @Client("/")
    protected RxHttpClient client;
}
