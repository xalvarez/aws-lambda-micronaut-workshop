package aws.lambda.micronaut.workshop.restcountries;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.exceptions.HttpStatusException;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

@Prototype
public class RestCountriesService {

  @Inject
  public RestCountriesClient restCountriesClient;

  public String getCapital(String country) {

    var countries = Optional.ofNullable(restCountriesClient.fetchCountry(country))
        .orElse(List.of());

    return countries
        .stream()
        .findFirst()
        .map(RestCountriesResponse::getCapital)
        .orElseThrow(() -> badRequestException(country));
  }

  private HttpStatusException badRequestException(String country) {
    return new HttpStatusException(NOT_FOUND, "Couldn't find country " + country);
  }
}
