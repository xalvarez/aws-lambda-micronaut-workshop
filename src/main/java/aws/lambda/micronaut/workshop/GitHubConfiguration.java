package aws.lambda.micronaut.workshop;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(value = "github", cliPrefix = "github")
@Getter
@Setter
public class GitHubConfiguration {

    @NotBlank
    private String token;

    @NotBlank
    private String apiUrl;

    @NotBlank
    private String userAgent;
}
