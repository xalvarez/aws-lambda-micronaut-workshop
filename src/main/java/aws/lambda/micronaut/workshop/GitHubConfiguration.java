package aws.lambda.micronaut.workshop;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("github")
public interface GitHubConfiguration {
    @NotBlank
    String getToken();

    @NotBlank
    String getApiUrl();

    @NotBlank
    String getUserAgent();
}
