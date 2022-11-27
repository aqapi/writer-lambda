package pl.kozubek.writerlambda;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.kozubek.writerlambda.app.WriterLambdaComponent;
import pl.kozubek.writerlambda.mybatis.MyBatisComponent;
import pl.kozubek.writerlambda.mybatis.annotation.ModelMapper;

@SpringBootApplication
@RequiredArgsConstructor
@MapperScan(value = {"pl.kozubek.*.mapper", "pl.kozubek.**.mapper"}, markerInterface = ModelMapper.class)
@Import({
        MyBatisComponent.class,
        WriterLambdaComponent.class
})
public class WriterLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WriterLambdaApplication.class, args);
    }

}