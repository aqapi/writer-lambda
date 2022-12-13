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

@Service
@RequiredArgsConstructor
public class MeasuringDataService {

    private final MeasuringDataMapper dataMapper;
    private final MeasuringClient client;
    private final ValueDtoMapper valueDtoMapper;
    private final DataDtoMapper dataDtoMapper;

    @Transactional
    public void addMeasuringDataWithValue(MeasuringDataDto dataDto) {
        System.out.println(dataDto);
        if (Objects.isNull(dataDto.getValues()) || Objects.isNull(dataDto.getKey()))
            return;

        List<MeasuringValue> values = valueDtoMapper.to(dataDto.getValues());
        System.out.println(values);
        MeasuringData data = dataDtoMapper.to(dataDto);

        if (Objects.isNull(values) || Objects.isNull(data))
            return;

        MeasuringValue value = values.get(0);
        dataMapper.addData(data);
        dataMapper.addValue(value);

        Long dataId = data.getId();
        Long valueId = value.getId();
        dataMapper.connectDataAndValue(dataId, valueId);
    }
}
