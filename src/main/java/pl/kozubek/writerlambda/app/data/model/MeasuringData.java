package pl.kozubek.writerlambda.app.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringData {
    private Long id;
    private Long stationId;
    private String key;
}
