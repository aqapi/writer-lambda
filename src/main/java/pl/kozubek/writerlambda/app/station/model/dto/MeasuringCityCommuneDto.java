package pl.kozubek.writerlambda.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCityCommuneDto {
    private Long id;
    private String communeName;
    private String districtName;
    private String provinceName;
}
