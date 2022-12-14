package pl.kozubek.writerlambda.app.station.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.writerlambda.app.station.model.MeasuringCity;
import pl.kozubek.writerlambda.app.station.model.MeasuringCityCommune;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;

/**
 * Interfejs <code>MeasuringStationMapper</code> odpowiedzialna za udostępnienie metod, które pozwalają na komunikację z
 * bazą danych zarządzana przez MyBatis. Funkcja posiada 6 funkcji odpowiedzialne za dodawanie nowych danych do
 * bazy oraz sprawdzania czy takie dane istnieją w bazie. Interfejs rozszerza interfejs <code>ModelMapper</code>
 * aby zachować spójność wszystkich interfejsów w projekcie.
 */
@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    /**
     * Funkaja odpowiedzialna za dodanie nowej gminy gdzie znajduje się stacja jakości powietrza.
     *
     * @param commune obiekt przechowujący adres stacji pogodowej.
     * @see MeasuringCityCommune
     */
    void addMeasuringCommune(@Param("measuringCommune") MeasuringCityCommune commune);

    /**
     * Funkcja odpowiedzialna za dodanie nowego miasta gdzie znajduje się stacja jakości powietrza.
     *
     * @param city obiekt przechowujący nazwę miasta gdzie znajduje isę stacja pogodowa.
     * @see MeasuringCity
     */
    void addMeasuringCity(@Param("measuringCity") MeasuringCity city);

    /**
     * Funkcja odpowiedzialna za dodawanie nowej stacji pogodowej.
     *
     * @param station obiekt przechowujący informajcę na temat stacji pogodowej.
     * @see MeasuringStation
     */
    void addMeasuringStation(@Param("measuringStation") MeasuringStation station);

    /**
     * Funkcja sprawdzająca czy stacja istnieje w bazie danych poprzed identyfikator stacji.
     *
     * @param id identyfikator jednoznacznie identyfikujący stację pogodową.
     * @return True jeśli stacja znajduje się w bazie lub False jeśli stacja się nie znajduje w bazie.
     */
    boolean existStationById(@Param("id") Long id);

    /**
     * Funkcja sprawdzająca czy miasto istnieje w bazie danych poprzed identyfikator miasta.
     *
     * @param id identyfikator jednoznacznie identyfikujący miasto w którym znajduje się stacja pogodowa.
     * @return True jeśli stacja znajduje się w bazie lub False jeśli stacja się nie znajduje w bazie.
     */
    boolean existCityById(@Param("id") Long id);

    /**
     * Funkcja sprawdzająca czy gmina istnieje w bazie danych poprzed jej parametry.
     *
     * @param communeName  nazwa gminy w której znajduje się stacja pogodowa
     * @param districtName nazwa dzielnicy w której znajduje się stacja pogodowa
     * @param provinceName nazwa prowincji w której znajduje się stacja pogodowa
     * @return True jeśli gmina znajduje się w bazie lub False jeśli gmina się nie znajduje w bazie
     * @see MeasuringCityCommune
     */
    boolean existCommuneByCommuneNameAndDistrictNameAndProvinceName(@Param("communeName") String communeName,
                                                                    @Param("districtName") String districtName,
                                                                    @Param("provinceName") String provinceName);
}
