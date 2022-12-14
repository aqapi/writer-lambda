package pl.kozubek.writerlambda.app.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringValueDto</code> odpowiedzialna za reprezentację danych pochodzących z api i przemapowanie ich na
 * dane trzymane w naszej bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie
 * konstruktorów oraz umożliwia wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 3 atrybuty:
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
public class MeasuringValueDto {
    private Long id;
    private String date;
    private String value;
}
