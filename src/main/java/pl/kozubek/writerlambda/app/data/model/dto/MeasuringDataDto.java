package pl.kozubek.writerlambda.app.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringDataDto {
    private Long id;
    private Long stationId;
    private String key;
    private List<MeasuringValueDto> values;
}
