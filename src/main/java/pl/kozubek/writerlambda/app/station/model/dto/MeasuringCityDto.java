package pl.kozubek.writerlambda.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringCityDto</code> odpowiedzialna za reprezentację danych pochodzących z api i przemapowanie ich na
 * dane trzymane w naszej bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
 * wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 4 atrybuty:
 * <ol>
 *     <li>id - odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>name - odpowiedzialne za przechowywanie nazwy miasta</li>
 *     <li>commune - odpowiedzialne za połączenie miasta i adresu stacji jakości powietrza</li>
 * </ol>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCityDto {
    private Long id;
    private String name;
    private MeasuringCityCommuneDto commune;
}
