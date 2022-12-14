package pl.kozubek.writerlambda.app.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringData</code> odpowiedzialna za reprezentację tabeli <code>MEASURING_DATA_VALUES</code>
 * znajdująca się na bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz
 * umożliwia wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 3 atrybuty:
 * <ol>
 *     <li>id odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>date odpowiedzialne za przechowywanie daty kiedy został przechwycony wynik z czujników</li>
 *     <li>value odpowiedzialne za przechowywanie wartości jakości powietrza</li>
 * </ol>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringValue {
    private Long id;
    private String date;
    private String value;
}
