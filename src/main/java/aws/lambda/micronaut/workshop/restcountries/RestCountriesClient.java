package aws.lambda.micronaut.workshop.restcountries;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import java.util.List;

@Client("${restCountries.apiUrl}")
interface RestCountriesClient {

    @Get("/name/{country}")
    List<RestCountriesResponse> fetchCountry(@PathVariable String country);
}