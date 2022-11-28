package pl.kozubek.writerlambda.app.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCity {
    private Long id;
    private String name;
    private Long commune;
}
