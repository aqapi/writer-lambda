package pl.kozubek.writerlambda;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import pl.kozubek.writerlambda.app.WriterLambdaComponent;
import pl.kozubek.writerlambda.app.data.model.dto.MeasuringDataDto;
import pl.kozubek.writerlambda.app.data.service.MeasuringDataService;
import pl.kozubek.writerlambda.app.station.model.dto.MeasuringStationDto;
import pl.kozubek.writerlambda.app.station.service.MeasuringStationService;
import pl.kozubek.writerlambda.mybatis.MyBatisComponent;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;
import pl.kozubek.writerlambda.webClient.MeasuringClient;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@MapperScan(value = {"pl.kozubek.*.mapper", "pl.kozubek.**.mapper"}, markerInterface = ModelMapper.class)
@Import({
        MyBatisComponent.class,
        WriterLambdaComponent.class
})
public class WriterLambdaApplication {

    private final MeasuringClient client;
    private final MeasuringStationService stationService;
    private final MeasuringDataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(WriterLambdaApplication.class, args);
    }

//    @PostConstruct
//    public void call() {
//        List<MeasuringStationDto> stationDtos = client.getMeasuringStation();
//
//        for (MeasuringStationDto stationDto : stationDtos) {
//            stationService.addMeasuringStationWithCityAndCommune(stationDto);
//            MeasuringDataDto dataDto = client.getData(stationDto.getId());
//            dataDto.setStationId(stationDto.getId());
//            System.out.println(dataDto);
//            dataService.addMeasuringDataWithValue(dataDto);
//        }
//    }
}