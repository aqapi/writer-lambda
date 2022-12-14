package pl.kozubek.writerlambda.app.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Klasa <code>MeasuringData</code> odpowiedzialna za reprezentację danych pochodzących z api i przemapowanie ich na
 * dane trzymane w naszej bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów
 * oraz umożliwia wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 3 atrybuty:
 * <ol>
 *     <li>id odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>stationId odpowiedzialne za połączenie między danymi jakości powietrza, a stacjami z których te dane otrzymujemy</li>
 *     <li>key odpowiedzialne za nazwanie zawiesiny pyłowej w powietrzu</li>
 *     <li>values odpowiedzialne za przechowywanie wartości jakości powietrza. Dane są przechowywane na liście typu MeasuringValueDto </li>
 * </ol>
 *
 * @see MeasuringValueDto
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringDataDto {
    private Long id;
    private Long stationId;
    private String key;
    private List<MeasuringValueDto> values;
}
