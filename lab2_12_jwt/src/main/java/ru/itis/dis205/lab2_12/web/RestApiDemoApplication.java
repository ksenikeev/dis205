package ru.itis.dis205.lab2_12.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.dis205.lab2_12.web.model.transport.Coordinates;
import ru.itis.dis205.lab2_12.web.model.transport.EntityGeometry;
import ru.itis.dis205.lab2_12.web.model.transport.TrasportDataBase;
import ru.itis.dis205.lab2_12.web.service.VehicleService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class RestApiDemoApplication {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = SpringApplication.run(RestApiDemoApplication.class, args);

/*
        VehicleService vehicleService = context.getBean(VehicleService.class);

        ObjectMapper mapper = new ObjectMapper();
        TrasportDataBase dataBase =
                mapper.readValue(new File("transport.json"), TrasportDataBase.class);

        dataBase.getData().getVehicles().forEach(
                v -> {
                    v.getFeatures().forEach(f->{
                        EntityGeometry eg = new EntityGeometry();
                        List<Coordinates> coordinates =
                        f.getGeometry().getCoordinates().stream()
                                .map(c-> new Coordinates(null,c[0],c[1])).toList();
                        eg.setCoordinates(coordinates);
                        f.setEgeometry(eg);
                    });
                    vehicleService.save(v);
                }
        );
*/
    }
}
