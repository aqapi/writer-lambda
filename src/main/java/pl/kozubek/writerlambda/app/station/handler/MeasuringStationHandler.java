package pl.kozubek.writerlambda.app.station.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.data.service.MeasuringDataService;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.writerlambda.app.station.service.MeasuringStationService;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MeasuringStationHandler {
    private final MeasuringClient client;
    private final MeasuringStationService stationService;
    private final MeasuringDataService dataService;

    public String handlerRequest(String input, String context) {
        try {
            List<MeasuringStationDto> stations = client.getMeasuringStation();
            for (MeasuringStationDto station: stations){
                stationService.addMeasuringStationWithCityAndCommune(station);
            }
        } catch (Exception e) {
            return "400 Error";
        }
        return "200 OK";
    }
}
