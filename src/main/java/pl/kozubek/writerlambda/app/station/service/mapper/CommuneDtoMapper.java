package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringCityCommune;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringCityCommuneDto;

@Component
@RequiredArgsConstructor
public class CommuneDtoMapper {

    public MeasuringCityCommune to(MeasuringCityCommuneDto communeDto) {
        return MeasuringCityCommune.builder()
                .id(communeDto.getId())
                .communeName(communeDto.getCommuneName())
                .districtName(communeDto.getDistrictName())
                .provinceName(communeDto.getProvinceName())
                .build();
    }

    public MeasuringCityCommuneDto to(MeasuringCityCommune commune) {
        return MeasuringCityCommuneDto.builder()
                .id(commune.getId())
                .communeName(commune.getCommuneName())
                .districtName(commune.getDistrictName())
                .provinceName(commune.getProvinceName())
                .build();
    }
}
