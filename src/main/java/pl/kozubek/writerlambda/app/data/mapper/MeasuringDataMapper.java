package pl.kozubek.writerlambda.app.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.MeasuringValue;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;

/**
 * Interfejs <code>MeasuringDataMapper</code> odpowiedzialna za udostępnienie metod, które pozwalają na komunikację z
 * bazą danych zarządzana przez MyBatis. Funkcja posiada 3 funkcje odpowiedzialne tylko za dodawanie nowych danych do
 * bazy. Interfejs rozszerza interfejs <code>ModelMapper</code> aby zachować spójność wszystkich interfejsów w projekcie.
 */
@Mapper
public interface MeasuringDataMapper extends ModelMapper {
    /**
     * Funkcja odpowiedzialna za dodanie do bazy nowej danej dla zanieczyszczenia powietrza.
     *
     * @param data obiekt odpowiedzialny za przechowywanie informacji na temat zawiesiny w powietrzu.
     * @see MeasuringData
     */
    void addData(MeasuringData data);

    /**
     * Funkcja odpowiedzialna za dodanie do bazy nowej wartości dla zanieczyszczenia powietrza.
     *
     * @param value obiekt odpowiedzialny za przechowywanie informacji na temat wartości zanieczyszczenia powietrza.
     * @see MeasuringValue
     */
    void addValue(MeasuringValue value);

    /**
     * Funkcja odpowiedzialna za połączenie danych zanieczyszczenia powietrza i wartości zanieczyszczenia powietrza.
     *
     * @param dataId  identyfikator jednoznacznie identyfikujący encję odpowiedzialną za informację na temat
     *                zanieczyszczenia powietrza
     * @param valueId ifentyfikator jednoznacznie identyfikujący encję odpowiedzialną za informację na temat
     *                wartości zanieczyszczenia powietrza
     * @see MeasuringValue
     * @see MeasuringData
     */
    void connectDataAndValue(@Param("dataId") Long dataId, @Param("valueId") Long valueId);
}
