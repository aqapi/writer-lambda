package pl.kozubek.writerlambda.app.data.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kozubek.writerlambda.app.data.mapper.MeasuringDataMapper;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.MeasuringValue;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.data.service.mapper.DataDtoMapper;
import pl.kozubek.writerlambda.app.data.service.mapper.ValueDtoMapper;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import java.util.List;
import java.util.Objects;

/**
 * Obiekt <code>MeasuringDataService</code> odpowiedzialny za biznesową część działania aplikacji. Obiekt posiada 3
 * zmienne odpowiedzialne za mappowanie danych oraz interfej udostępniający możliwość połączenia z bazą. Obiekt został
 * okrazony adnotacjami odpowiedzialnymi za utworzenie konstruktora oraz zarządzanie przez kontekst spring'a.
 */
@Service
@RequiredArgsConstructor
public class MeasuringDataService {

    private final MeasuringDataMapper dataMapper;
    private final ValueDtoMapper valueDtoMapper;
    private final DataDtoMapper dataDtoMapper;

    /**
     * Funkcja <code>addMeasuringDataWithValue</code> odpowiedzialna za dodanie nowych danych zanieczyszczenia
     * powietrza do bazy danych. Metoda jest zabezpieczona przed brakiem odpowiedzi z API oraz jeśli API nie zwróci nic.
     *
     * @param dataDto Obiekt odpowiedzialny za reprezentowanie danych zanieczyszczenia powietrza
     */
    @Transactional
    public void addMeasuringDataWithValue(MeasuringDataDto dataDto) {
        if (Objects.isNull(dataDto.getValues()) || Objects.isNull(dataDto.getKey()))
            return;

        List<MeasuringValue> values = valueDtoMapper.to(dataDto.getValues());
        MeasuringData data = dataDtoMapper.to(dataDto);

        if (Objects.isNull(values) || Objects.isNull(data))
            return;
        else if (values.isEmpty()) {
            return;
        }

        MeasuringValue value = values.get(0);
        dataMapper.addData(data);
        dataMapper.addValue(value);

        Long dataId = data.getId();
        Long valueId = value.getId();
        dataMapper.connectDataAndValue(dataId, valueId);
    }
}
