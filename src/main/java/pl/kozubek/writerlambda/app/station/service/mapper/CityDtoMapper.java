package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringCity;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringCityDto;

@Component
@RequiredArgsConstructor
public class CityDtoMapper {

    public MeasuringCity to(MeasuringCityDto cityDto) {
        return MeasuringCity.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .commune(cityDto.getCommune().getId())
                .build();
    }

    public MeasuringCityDto to(MeasuringCity city) {
        return MeasuringCityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .commune(null)
                .build();
    }
}
