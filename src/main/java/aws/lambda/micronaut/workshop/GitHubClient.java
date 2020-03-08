package aws.lambda.micronaut.workshop;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client("${github.apiUrl}")
interface GitHubClient {
    @Post
    GitHubResponse fetchUsername(@Header("Authorization") String authorization, @Header(value = "User-Agent") String userAgent, String query);
}