package pl.kozubek.writerlambda.webClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;

import java.util.List;

@Component
@Slf4j
public class MeasuringClient {
    private static final String GIOS_URL = "https://api.gios.gov.pl/pjp-api/rest";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<MeasuringStationDto> getMeasuringStation() {
        return List.of(callGetMethod("/station/findAll",
                MeasuringStationDto[].class));
    }

    public MeasuringDataDto getData(Long idStation) {
        return callGetMethod("/data/getData/{station}",
                MeasuringDataDto.class,
                idStation);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        log.info("call to GIOS api");
        return restTemplate.getForObject(GIOS_URL + url,
                responseType, objects);
    }
}
