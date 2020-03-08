package aws.lambda.micronaut.workshop;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.context.annotation.Value;

import javax.inject.Inject;

@Prototype
public class GitHubService {

    private static final String USER_QUERY = "{\n" +
            "viewer {\n" +
            "login\n" +
            "}\n" +
            "}";

    @Inject
    public GitHubClient gitHubClient;

    @Value("${github.token}")
    private String gitHubToken;

    @Value("${github.userAgent}")
    private String userAgent;

    public String getUsername() {
        String authorization = "Bearer " + gitHubToken;
        return gitHubClient.fetchUsername(authorization, userAgent, USER_QUERY).getUsername();
    }
}
