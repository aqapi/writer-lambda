package pl.kozubek.writerlambda.app.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pl.kozubek.writerlambda.app.data.model.MeasuringData;
import pl.kozubek.writerlambda.app.data.model.MeasuringValue;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;

@Mapper
public interface MeasuringDataMapper extends ModelMapper {
    void addData(MeasuringData data);

    void addValue(MeasuringValue value);

    void connectDataAndValue(@Param("dataId") Long dataId, @Param("valueId") Long valueId);
}
