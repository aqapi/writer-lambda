package pl.kozubek.writerlambda.app.data.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.data.model.MeasuringValue;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringValueDto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ValueDtoMapper {

    public MeasuringValue to(MeasuringValueDto valueDto) {
        return MeasuringValue.builder()
                .date(valueDto.getDate())
                .value(valueDto.getValue())
                .build();
    }

    public List<MeasuringValue> to(List<MeasuringValueDto> valuesDto) {
        if (Objects.isNull(valuesDto))
            return Collections.emptyList();
        return valuesDto.stream()
                .map(this::to).collect(Collectors.toList());
    }

    public MeasuringValueDto to(MeasuringValue value) {
        return MeasuringValueDto.builder()
                .date(value.getDate())
                .value(value.getValue())
                .build();
    }
}
