package pl.kozubek.writerlambda;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.kozubek.writerlambda.app.WriterLambdaComponent;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.data.service.MeasuringDataService;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.writerlambda.app.station.service.MeasuringStationService;
import pl.kozubek.writerlambda.mybatis.MyBatisComponent;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

/**
 * Klasa <code>WriterLambdaApplication</code> główna odpowiedzialna za konfigurację oraz uruchomienie serwera spring boot.
 * Klasa jest również odpowiedzialna za połączenie wszystkich komponentów. Obiekt powinien przy uruchomieniu serwera
 * uruchomić metodę <code>call</code>.
 */
@SpringBootApplication
@RequiredArgsConstructor
@MapperScan(value = {"pl.kozubek.*.mapper", "pl.kozubek.**.mapper"}, markerInterface = ModelMapper.class)
@Import({
        MyBatisComponent.class,
        WriterLambdaComponent.class
})
public class WriterLambdaApplication {

    private final MeasuringClient client;
    private final MeasuringStationService stationService;
    private final MeasuringDataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(WriterLambdaApplication.class, args);
        System.exit(0);
    }

    /**
     * Funkcja <code>call</code> odpowiedzialna za odpytanie zewnętrznego api oraz dopisaniu nowych wartości do bazy
     * danych. Metoda jest zabezpieczona przed brakiem połączenia oraz brakiem odpowiedzi z strony api GIOS. Metoda
     * najpierw wywołuje funkcję odpowiedzialną za pobranie wszystkich dostępnych stacji pogodowych, a następnie
     * pobiera informację na temat jakości powietrza z tych stacji zarejestrowanych w rejestrze GIOS. Po skończonej
     * pracy serwer spring boot powinien się wyłączyć z kodem końcowym 0.
     */
    @PostConstruct
    public void call() {
        List<MeasuringStationDto> stationDtos = client.getMeasuringStation();
        if (Objects.isNull(stationDtos)) {
            System.exit(0);
        }
        for (MeasuringStationDto stationDto : stationDtos) {
            stationService.addMeasuringStationWithCityAndCommune(stationDto);
            MeasuringDataDto dataDto = client.getData(stationDto.getId());
            dataDto.setStationId(stationDto.getId());
            dataService.addMeasuringDataWithValue(dataDto);
        }
    }
}