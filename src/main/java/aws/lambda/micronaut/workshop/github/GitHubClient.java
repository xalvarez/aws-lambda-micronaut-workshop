package aws.lambda.micronaut.workshop.github;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

@Client("${github.apiUrl}")
interface GitHubClient {

    @Post
    GitHubResponse fetchUsername(@Header("Authorization") String authorization, @Header(value = "User-Agent") String userAgent, String query);
}