package aws.lambda.micronaut.workshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/")
public class ExampleController {
    private static final Logger LOG = LoggerFactory.getLogger(ExampleController.class);

    @Inject
    public GitHubService gitHubService;

    @Get("/ping")
    public String index() {
        return "{\"pong\":true, \"graal\": true}";
    }

    @Get("/hello-github")
    public String helloGitHub() {
        return "{\"greeting\": \"Hello " + gitHubService.getUsername() + "!\"}";
    }
}
