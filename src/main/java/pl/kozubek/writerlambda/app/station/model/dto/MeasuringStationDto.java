package pl.kozubek.writerlambda.app.station.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa <code>MeasuringStationDto</code> odpowiedzialna za reprezentację tabeli <code>MEASURING_STATION</code> znajdująca się
 * na bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
 * wykorzystywanie wzorca projektowego o nazwie builder. Klasa posiada 6 atrybutów:
 * <ol>
 *     <li>id - odpowiedzialne za jednoznaczną reprezencaję encji w bazie</li>
 *     <li>stationName - odpowiedzialne za przechowywanie nazwy stacji pomiarowej</li>
 *     <li>gegrLat - odpowiedzialne za przechowywanie szerokości geograficznej stacji pomiarowej horyzontalnej</li>
 *     <li>gegrLon - odpowiedzialne za przechowywanie szerokości geograficznej stacji pomiarowej wertykalnej</li>
 *     <li>city - odpowiedzialne za połączenie stacji z miastem w którym znajduje się stacja jakości powietrza</li>
 *     <li>addressStreet - odpowiedzialne za przechowywanie nazwy ulicy na której znajduje się stacja jakości powietrza</li>
 * </ol>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringStationDto {
    private Long id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private MeasuringCityDto city;
    private String addressStreet;
}
