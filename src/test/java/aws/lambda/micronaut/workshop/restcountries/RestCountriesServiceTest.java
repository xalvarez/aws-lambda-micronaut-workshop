package aws.lambda.micronaut.workshop.restcountries;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RestCountriesServiceTest {

    @Mock
    private RestCountriesClient restCountriesClient;

    @InjectMocks
    private RestCountriesService restCountriesService;

    @Test
    public void shouldReturnCapital() {
        String givenCapital = "exampleCapital";
        String givenCountry = "germany";
        given(restCountriesClient.fetchCountry(anyString())).willReturn(List.of(
            RestCountriesResponse.builder().capital(givenCapital).build()));

        String capital = restCountriesService.getCapital(givenCountry);

        then(capital).isEqualTo(givenCapital);
    }
}