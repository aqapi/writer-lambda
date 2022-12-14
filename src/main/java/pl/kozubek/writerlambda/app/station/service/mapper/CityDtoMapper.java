package pl.kozubek.writerlambda.app.station.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kozubek.writerlambda.app.station.model.MeasuringCity;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringCityDto;

/**
 * Obiekt <code>CityDtoMapper</code> odpowiedzialny za przemapowanie obiektów.
 */
@Component
@RequiredArgsConstructor
public class CityDtoMapper {

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringCityDto</code> na <code>MeasuringCity</code>
     *
     * @param cityDto obiekt przechowujący informację na temat miast w których znajdują się stacje pogodowe.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringCity to(MeasuringCityDto cityDto) {
        return MeasuringCity.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .commune(cityDto.getCommune().getId())
                .build();
    }

    /**
     * Funkcja odpowiedzialna za przemapowanie obiektów z typu <code>MeasuringCity</code> na <code>MeasuringCityDto</code>
     *
     * @param city obiekt przechowujący informację na temat miast w których znajdują się stacje pogodowe.
     * @return Przemapowany obiekt wykorzystywany w naszej aplikacji
     */
    public MeasuringCityDto to(MeasuringCity city) {
        return MeasuringCityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .commune(null)
                .build();
    }
}
