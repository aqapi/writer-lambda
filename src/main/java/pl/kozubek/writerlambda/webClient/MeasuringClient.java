package pl.kozubek.writerlambda.webClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;

import java.util.List;

/**
 * KLasa <code>MeasurinigClient</code> odpowiedzialna jest za utworzenie komunikacji oraz pobranie danych z zewnętrznego api
 * Obiekt posiada statyczne pole URL do api GIOS. Obiekt również loguje wszystkie eventy do logów aplikacji aby w razie
 * błędów łatwiej było debugować i znaleźć problem jaki występuje.
 */
@Component
@Slf4j
public class MeasuringClient {

    private static final String GIOS_URL = "https://api.gios.gov.pl/pjp-api/rest";
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Funkcja <code>getMeasuringStation</code> odpowiedzialna za pobranie z zewnętrznego api danych na temat stacji pogodowych w Polsce.
     * Metoda zwraca Liste stacji pogodowych.
     *
     * @return Lista istniejących i zarejetrowanych w systemie GIOS stacji pogodowych w Polsce.
     * @see MeasuringStationDto
     */
    public List<MeasuringStationDto> getMeasuringStation() {
        log.info("Function getMeasuringStation");
        return List.of(callGetMethod("/station/findAll",
                MeasuringStationDto[].class));
    }

    /**
     * Funkcja <code>getData</code> odpowiedzialna za pobranie z zewnętrznego api danych na temat jakości powietrza w
     * Polsce udostępnianego przez wskazaną stację pogodową. Metoda przyjmuje identyfikator stacji pogodowej z której
     * ma zostać pobrana informacja na temat jakości powietrza. Metoda zwraca liste jakości powietrza, która
     * jest aktualizowana co godzine przez zewnętrzne api.
     *
     * @param idStation identyfikator stacji pogodowej zarejestrowanej w systemie GIOS.
     * @return Lista jakości powietrza.
     * @see MeasuringDataDto
     */
    public MeasuringDataDto getData(Long idStation) {
        log.info("Function getData");
        return callGetMethod("/data/getData/{station}",
                MeasuringDataDto.class,
                idStation);
    }

    /**
     * Generyczna funkcja <code>callGetMethod</code> odpowiedzialna za otwarcie połączenia i pobranie informacji
     * z zewnętrznego api.
     *
     * @param url          Link pod którym można wywołać podane api.
     * @param responseType Klasa na jaką ma zostać przemapowane dane z postaci JSON na postać klasową.
     * @param objects      Dodatkowe parametry potrzebne do wywołąnia poszczególnych endpointów api.
     * @return Lista obiektów wskazana przy wywołaniu obiektu
     */
    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        log.info("call to GIOS api");
        return restTemplate.getForObject(GIOS_URL + url,
                responseType, objects);
    }
}
