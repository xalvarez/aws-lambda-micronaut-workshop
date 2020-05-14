package aws.lambda.micronaut.workshop.restcountries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestCountriesResponse {

  private String capital;
}
