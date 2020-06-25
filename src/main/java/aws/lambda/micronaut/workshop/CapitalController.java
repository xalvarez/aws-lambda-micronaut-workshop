package aws.lambda.micronaut.workshop;

import aws.lambda.micronaut.workshop.restcountries.RestCountriesService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import javax.inject.Inject;
import javax.validation.constraints.NotBlank;

@Controller("/")
public class CapitalController {

  @Inject
  public RestCountriesService restCountriesService;

  @Get("/ping")
  public String index() {
    return "{\"pong\":true, \"graal\": true}";
  }

  @Get("/capital/{country}")
  public String getCapital(@PathVariable @NotBlank String country) {
    return "{\"capital\": \"" + restCountriesService.getCapital(country) + "\"}";
  }
}
