package pl.kozubek.writerlambda.app.station.model;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringStation {
    private Long id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private Long city;
    private String addressStreet;
}
