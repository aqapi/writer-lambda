package pl.kozubek.writerlambda.app.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringCityCommune</code> odpowiedzialna za reprezentację tabeli <code>MEASURING_CITY_COMMUNES</code> znajdująca się
 * na bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
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
public class MeasuringCityCommune {
    private Long id;
    private String communeName;
    private String districtName;
    private String provinceName;
}
