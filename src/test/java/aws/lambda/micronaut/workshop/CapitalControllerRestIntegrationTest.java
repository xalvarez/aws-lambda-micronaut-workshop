package aws.lambda.micronaut.workshop;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.BDDAssertions.then;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

@MicronautTest
public class CapitalControllerRestIntegrationTest extends AbstractRestIntegrationTest {

    @Test
    public void shouldReplyPongToPing() {
        String givenExpectedResponseBody = "{\"pong\":true, \"graal\": true}";

        var response = client.toBlocking().exchange("/ping", String.class);

        then(response.getStatus().getCode()).isEqualTo(OK.getStatusCode());
        then(response.body()).isEqualTo(givenExpectedResponseBody);
    }

    @Test
    public void shouldReturnCapital() {
        givenSuccessfulRequest();
        String givenExpectedResponseBody = "{\"capital\": \"Berlin\"}";

        var response = client.toBlocking().exchange("/capital/germany", String.class);

        then(response.getStatus().getCode()).isEqualTo(OK.getStatusCode());
        then(response.body()).isEqualTo(givenExpectedResponseBody);
    }

    private void givenSuccessfulRequest() {
        wireMockServer.stubFor(
                get(urlPathEqualTo("/name/germany")).willReturn(
                        aResponse()
                                .withStatus(OK.getStatusCode())
                                .withHeader(CONTENT_TYPE, APPLICATION_JSON)
                                .withBody(buildValidResponseBody())
                )
        );
    }

    private String buildValidResponseBody() {
        return "[\n"
            + "  {\n"
            + "    \"capital\": \"Berlin\"\n"
            + "  }\n"
            + "]\n";
    }
}
