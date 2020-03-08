package aws.lambda.micronaut.workshop.github;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GitHubUser {

    private String username;
}
