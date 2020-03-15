package aws.lambda.micronaut.workshop;

import aws.lambda.micronaut.workshop.github.GitHubService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import javax.inject.Inject;

@Controller("/")
public class ExampleController {

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
