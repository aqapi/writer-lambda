package pl.kozubek.writerlambda.app.data.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.RequiredArgsConstructor;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.data.service.MeasuringDataService;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class MeasuringDataHandler implements RequestHandler<Map<String, String>, String> {

    private final MeasuringClient client;
    private final MeasuringDataService service;

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        String response = "200 OK";
        try {
            List<MeasuringStationDto> stationDtos = client.getMeasuringStation();

            for (MeasuringStationDto stationDto : stationDtos) {
                MeasuringDataDto dataDto = client.getData(stationDto.getId());
                service.addMeasuringDataWithValue(dataDto);
            }
        } catch (RuntimeException e) {
            response = "400 OK";
        }
        return response;
    }
}
