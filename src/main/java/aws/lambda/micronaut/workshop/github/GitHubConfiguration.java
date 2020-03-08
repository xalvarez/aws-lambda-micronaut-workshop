package aws.lambda.micronaut.workshop.github;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(value = "github", cliPrefix = "github")
@Data
public class GitHubConfiguration {

    @NotBlank
    private String token;

    @NotBlank
    private String userAgent;
}
