package pl.kozubek.writerlambda.app.station.model;

import lombok.*;

/**
 * Klasa <code>MeasuringStation</code> odpowiedzialna za reprezentację danych pochodzących z api i przemapowanie ich na
 * dane trzymane w naszej bazie danych. Funkcja jest okraszona adnotacjami odpowiedzialnymi za utworzenie konstruktorów oraz umożliwia
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
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasuringStation {
    private Long id;
    private String stationName;
    private String gegrLat;
    private String gegrLon;
    private Long city;
    private String addressStreet;
}
