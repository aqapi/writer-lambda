package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;

@Component
@RequiredArgsConstructor
public class StationDtoMapper {

    public MeasuringStation to(MeasuringStationDto stationDto) {
        return MeasuringStation.builder()
                .id(stationDto.getId())
                .stationName(stationDto.getStationName())
                .gegrLat(stationDto.getGegrLat())
                .gegrLon(stationDto.getGegrLon())
                .city(stationDto.getCity().getId())
                .addressStreet(stationDto.getAddressStreet())
                .build();
    }

    public MeasuringStationDto to(MeasuringStation station) {
        return MeasuringStationDto.builder()
                .id(station.getId())
                .stationName(station.getStationName())
                .gegrLat(station.getGegrLat())
                .gegrLon(station.getGegrLon())
                .city(null)
                .addressStreet(station.getAddressStreet())
                .build();
    }
}
