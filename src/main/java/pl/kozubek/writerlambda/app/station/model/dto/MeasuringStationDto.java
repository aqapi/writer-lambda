package pl.kozubek.writerlambda.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringStationDto {
    private Long id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private MeasuringCityDto city;
    private String addressStreet;
}
