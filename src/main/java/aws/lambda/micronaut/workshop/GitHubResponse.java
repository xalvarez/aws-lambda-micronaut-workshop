package aws.lambda.micronaut.workshop;

import lombok.Data;

@Data
public class GitHubResponse {

    private GitHubData data;

    public String getUsername() {
        return data.getViewer().getLogin();
    }

    @Data
    private static class GitHubData {
        private Viewer viewer;
    }

    @Data
    private static class Viewer {
        private String login;
    }
}
