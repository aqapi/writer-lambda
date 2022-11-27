package pl.kozubek.writerlambda.app.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringValueDto {
    private Long id;
    private String date;
    private String value;
}
