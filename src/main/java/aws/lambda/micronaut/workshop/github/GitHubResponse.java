package aws.lambda.micronaut.workshop.github;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class GitHubResponse {

    private GitHubData data;

    public String getUsername() {
        return data.getViewer().getLogin();
    }

    @Data
    @Builder
    static class GitHubData {
        private Viewer viewer;
    }

    @Data
    @Builder
    static class Viewer {
        private String login;
    }
}
