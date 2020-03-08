package aws.lambda.micronaut.workshop;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Inject;

@Prototype
public class GitHubService {

    private static final String USER_QUERY = "{\n" +
            "viewer {\n" +
            "login\n" +
            "}\n" +
            "}";

    @Inject
    private GitHubClient gitHubClient;

    @Inject
    private GitHubConfiguration gitHubConfiguration;

    public String getUsername() {
        String authorization = "Bearer " + gitHubConfiguration.getToken();
        return gitHubClient.fetchUsername(authorization, gitHubConfiguration.getUserAgent(), USER_QUERY).getUsername();
    }
}
