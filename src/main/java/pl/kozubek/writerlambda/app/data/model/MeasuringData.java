package pl.kozubek.writerlambda.app.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringData</code> odpowiedzialna za reprezentację tabeli <code>MEASURING_DATA</code> znajdująca się
 * na bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
 * wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 3 atrybuty:
 * <ol>
 *     <li>id odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>stationId odpowiedzialne za połączenie między danymi jakości powietrza, a stacjami z których te dane otrzymujemy</li>
 *     <li>key odpowiedzialne za nazwanie zawiesiny pyłowej w powietrzu</li>
 * </ol>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringData {
    private Long id;
    private Long stationId;
    private String key;
}
