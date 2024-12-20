package ma.xproce.controlprep;

import ma.xproce.controlprep.dto.AvionDTO;
import ma.xproce.controlprep.service.AvionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ControlPrepApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlPrepApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AvionService avionService){
        return  args -> {
            avionService.saveAvions(
                    List.of(
                            AvionDTO.builder().model("model1").color("red").matricul("sdf64w6e").price(12345).build(),
                            AvionDTO.builder().model("model2").matricul("ef6e+6").color("green").price(65489).build(),
                            AvionDTO.builder().model("model3").matricul("ef64we8").color("yellow").price(89789).build(),
                            AvionDTO.builder().model("model4").matricul("wrdqwqw").color("black").price(67489).build()
                    )

            );
        };
    }

}