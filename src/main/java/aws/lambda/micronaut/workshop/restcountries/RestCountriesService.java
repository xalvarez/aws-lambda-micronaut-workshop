package aws.lambda.micronaut.workshop.restcountries;

import static io.micronaut.http.HttpStatus.NOT_FOUND;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.exceptions.HttpStatusException;
import javax.inject.Inject;

@Prototype
public class RestCountriesService {

  @Inject
  public RestCountriesClient restCountriesClient;

  public String getCapital(String country) {

    if (restCountriesClient.fetchCountry(country) == null) {
      throw badRequestException(country);
    }

    return restCountriesClient.fetchCountry(country)
        .stream()
        .findFirst()
        .map(RestCountriesResponse::getCapital)
        .orElseThrow(() -> badRequestException(country));
  }

  private HttpStatusException badRequestException(String country) {
    return new HttpStatusException(NOT_FOUND, "Couldn't find country " + country);
  }
}
