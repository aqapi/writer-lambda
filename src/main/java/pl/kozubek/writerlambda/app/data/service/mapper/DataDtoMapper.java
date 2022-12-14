package pl.kozubek.writerlambda.app.data.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;

/**
 * Obiekt <code>DataDtoMapper</code> odpowiedzialny za przemapowanie obiektów.
 */
@Component
@RequiredArgsConstructor
public class DataDtoMapper {

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringDataDto</code> na <code>MeasuringData</code>
     *
     * @param dataDto obiekt przechowujący informację na temat zanieczyszczenia powietrza.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringData to(MeasuringDataDto dataDto) {
        return MeasuringData.builder()
                .stationId(dataDto.getStationId())
                .key(dataDto.getKey())
                .build();
    }

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringData</code> na <code>MeasuringDataDto</code>
     *
     * @param data obiekt przechowujący informację na temat zanieczyszczenia powietrza.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringDataDto to(MeasuringData data) {
        return MeasuringDataDto.builder()
                .key(data.getKey())
                .build();
    }
}
