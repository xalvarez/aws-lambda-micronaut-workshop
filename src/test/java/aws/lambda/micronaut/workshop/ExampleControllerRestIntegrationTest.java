package aws.lambda.micronaut.workshop;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;
import static org.assertj.core.api.BDDAssertions.then;

@MicronautTest
public class ExampleControllerRestIntegrationTest extends AbstractRestIntegrationTest {

    @Test
    public void shouldReplyPongToPing() {
        String givenExpectedResponseBody = "{\"pong\":true, \"graal\": true}";

        var response = client.toBlocking().exchange("/ping", String.class);

        then(response.getStatus().getCode()).isEqualTo(OK.getStatusCode());
        then(response.body()).isEqualTo(givenExpectedResponseBody);
    }

    @Test
    public void shouldReturnGitHubUsername() {
        givenSuccessfulGitHubtRequest();
        String givenExpectedResponseBody = "{\"greeting\": \"Hello exampleUsername!\"}";

        var response = client.toBlocking().exchange("/hello-github", String.class);

        then(response.getStatus().getCode()).isEqualTo(OK.getStatusCode());
        then(response.body()).isEqualTo(givenExpectedResponseBody);
    }

    private void givenSuccessfulGitHubtRequest() {
        wireMockServer.stubFor(
                post(urlPathEqualTo("/graphql")).willReturn(
                        aResponse()
                                .withStatus(OK.getStatusCode())
                                .withHeader(CONTENT_TYPE, APPLICATION_JSON)
                                .withBody(buildValidResponseBody())
                )
        );
    }

    private String buildValidResponseBody() {
        return "{\n" +
                "  \"data\": {\n" +
                "    \"viewer\": {\n" +
                "      \"login\": \"exampleUsername\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }
}
