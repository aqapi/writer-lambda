package pl.kozubek.writerlambda.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringCityCommuneDto</code> odpowiedzialna za reprezentację danych pochodzących z api i przemapowanie ich na
 * dane trzymane w naszej bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
 * wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 4 atrybuty:
 * <ol>
 *     <li>id - odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>communeName - odpowiedzialne za przechowywanie nazwy gmiany</li>
 *     <li>districtName - odpowiedzialne za przechowywanie nazwy dzielnicy </li>
 *     <li>provinceName - odpowiedzialne za przechowywanie nazwy prowincji</li>
 * </ol>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringCityCommuneDto {
    private Long id;
    private String communeName;
    private String districtName;
    private String provinceName;
}
