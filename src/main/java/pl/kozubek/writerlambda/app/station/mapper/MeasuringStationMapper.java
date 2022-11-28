package pl.kozubek.writerlambda.app.station.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.writerlambda.app.station.model.MeasuringCity;
import pl.kozubek.writerlambda.app.station.model.MeasuringCityCommune;
import pl.kozubek.writerlambda.app.station.model.MeasuringStation;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;

@Mapper
public interface MeasuringStationMapper extends ModelMapper {

    void addMeasuringCommune(@Param("measuringCommune") MeasuringCityCommune commune);

    void addMeasuringCity(@Param("measuringCity") MeasuringCity city);

    void addMeasuringStation(@Param("measuringStation") MeasuringStation station);

    boolean existStationById(@Param("id") Long id);

    boolean existCityById(@Param("id") Long id);

    boolean existCommuneByCommuneNameAndDistrictNameAndProvinceName(@Param("communeName") String communeName,
                                                                    @Param("districtName") String districtName,
                                                                    @Param("provinceName") String provinceName);
}
