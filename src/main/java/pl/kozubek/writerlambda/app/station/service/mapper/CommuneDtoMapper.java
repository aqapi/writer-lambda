package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringCityCommune;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringCityCommuneDto;

/**
 * Obiekt <code>CommuneDtoMapper</code> odpowiedzialny za przemapowanie obiektów.
 */
@Component
@RequiredArgsConstructor
public class CommuneDtoMapper {

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringCityCommuneDto</code> na <code>MeasuringCityCommune</code>
     *
     * @param communeDto obiekt przechowujący informację na temat gmin w których znajdują się stacje pogodowe.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringCityCommune to(MeasuringCityCommuneDto communeDto) {
        return MeasuringCityCommune.builder()
                .id(communeDto.getId())
                .communeName(communeDto.getCommuneName())
                .districtName(communeDto.getDistrictName())
                .provinceName(communeDto.getProvinceName())
                .build();
    }

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringCityCommune</code> na <code>MeasuringCityCommuneDto</code>
     *
     * @param commune obiekt przechowujący informację na temat gmin w których znajdują się stacje pogodowe.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringCityCommuneDto to(MeasuringCityCommune commune) {
        return MeasuringCityCommuneDto.builder()
                .id(commune.getId())
                .communeName(commune.getCommuneName())
                .districtName(commune.getDistrictName())
                .provinceName(commune.getProvinceName())
                .build();
    }
}
