package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;

/**
 * Obiekt <code>StationDtoMapper</code> odpowiedzialny za przemapowanie obiektów.
 */
@Component
@RequiredArgsConstructor
public class StationDtoMapper {

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringStationDto</code> na <code>MeasuringStation</code>
     *
     * @param stationDto obiekt przechowujący informację na temat stacji pogodowych.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
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

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringStation</code> na <code>MeasuringStationDto</code>
     *
     * @param station obiekt przechowujący informację na temat stacji pogodowych.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
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
