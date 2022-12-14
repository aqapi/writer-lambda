package pl.kozubek.writerlambda.app.data.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.data.model.MeasuringValue;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringValueDto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Obiekt <code>ValueDtoMapper</code> odpowiedzialny za przemapowanie obiektów.
 */
@Component
@RequiredArgsConstructor
public class ValueDtoMapper {

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringValueDto</code> na <code>MeasuringValue</code>
     *
     * @param valueDto obiekt przechowujący informację na temat wartości zanieczyszczenia powietrza.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringValue to(MeasuringValueDto valueDto) {
        return MeasuringValue.builder()
                .date(valueDto.getDate())
                .value(valueDto.getValue())
                .build();
    }

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z listy typu <code>MeasuringValueDto</code> na
     * <code>MeasuringValue</code>. Funkcja jest zabezpieczona na wypadek gdyby obiekt MeasuringValueDto był pusty i
     * zwraca pustą listę.
     *
     * @param valuesDto obiekt przechowujący informację na temat wartości zanieczyszczenia powietrza.
     * @return Przemapowana lista obiaktów wykorzystywany w naszej aplikacji
     */
    public List<MeasuringValue> to(List<MeasuringValueDto> valuesDto) {
        if (Objects.isNull(valuesDto))
            return Collections.emptyList();
        return valuesDto.stream()
                .map(this::to).collect(Collectors.toList());
    }

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringValue</code> na <code>MeasuringValueDto</code>
     *
     * @param value obiekt przechowujący informację na temat wartości zanieczyszczenia powietrza.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringValueDto to(MeasuringValue value) {
        return MeasuringValueDto.builder()
                .date(value.getDate())
                .value(value.getValue())
                .build();
    }
}
