package aws.lambda.micronaut.workshop.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GitHubServiceTest {

    @Mock
    private GitHubClient gitHubClient;

    @Mock
    private GitHubConfiguration gitHubConfiguration;

    @InjectMocks
    private GitHubService gitHubService;

    @Test
    public void shouldReturnGitHubUsername() {
        String givenUsername = "exampleUsername";
        given(gitHubConfiguration.getToken()).willReturn("dummyToken");
        given(gitHubConfiguration.getUserAgent()).willReturn("dummyUserAgent");
        given(gitHubClient.fetchUsername(anyString(), anyString(), anyString())).willReturn(givenValidGitHubResponse(givenUsername));

        String username = gitHubService.getUsername();

        then(username).isEqualTo(givenUsername);
    }

    private GitHubResponse givenValidGitHubResponse(String username) {
        return GitHubResponse.builder()
                .data(GitHubResponse.GitHubData.builder()
                        .viewer(GitHubResponse.Viewer.builder()
                                .login(username)
                                .build())
                        .build())
                .build();
    }
}