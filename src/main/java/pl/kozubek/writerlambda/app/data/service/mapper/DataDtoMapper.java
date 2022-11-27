package pl.kozubek.writerlambda.app.data.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;

@Component
@RequiredArgsConstructor
public class DataDtoMapper {

    public MeasuringData to(MeasuringDataDto dataDto) {
        return MeasuringData.builder()
                .stationId(dataDto.getStationId())
                .key(dataDto.getKey())
                .build();
    }

    public MeasuringDataDto to(MeasuringData data) {
        return MeasuringDataDto.builder()
                .key(data.getKey())
                .build();
    }
}
