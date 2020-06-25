package aws.lambda.micronaut.workshop.restcountries;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.exceptions.HttpStatusException;
import java.util.Optional;
import javax.inject.Inject;

@Prototype
public class RestCountriesService {

  @Inject
  public RestCountriesClient restCountriesClient;

  public String getCapital(String country) {
    return Optional.ofNullable(restCountriesClient.fetchCountry(country))
        .flatMap(restCountriesResponses -> restCountriesResponses.stream().findFirst())
        .map(RestCountriesResponse::getCapital)
        .orElseThrow(() -> new HttpStatusException(NOT_FOUND, "Couldn't find country " + country));
  }
}
