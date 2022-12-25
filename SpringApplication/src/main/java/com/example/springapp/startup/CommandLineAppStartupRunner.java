package com.example.springapp.startup;

import com.example.springapp.entity.GasStationEntity;
import com.example.springapp.pipefilter.Pipe;
import com.example.springapp.pipefilter.impl.FilterDropColumn;
import com.example.springapp.service.GasStationService;
import com.example.springapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final String STATIONS_PATH = "D:\\Semestar V\\Dizajn i arhitektura na softver\\Labaratoriski Vezbi\\design-architecture\\dataset.csv";
    private final GasStationService gasStationService;
    private final UserService userService;

    public CommandLineAppStartupRunner(GasStationService gasStationService, UserService userService) {
        this.gasStationService = gasStationService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(STATIONS_PATH));

        Pipe<String> pipe = new Pipe<>();
        FilterDropColumn filterDropColumn = new FilterDropColumn();
        pipe.addFilter(filterDropColumn);

        String line = "";
        boolean flag = false;
        while ((line = bufferedReader.readLine()) != null) {
            if (flag) {
                String output = pipe.runFilter(line);
                String city = output.split("\\|")[0];
                String location = output.split("\\|")[1];
                String working_hours = output.split("\\|")[2];
                String phone_number = output.split("\\|")[3];
                double latitude = Double.parseDouble(output.split("\\|")[4]);
                double longitude = Double.parseDouble(output.split("\\|")[5]);
                if (latitude != 0.0 || longitude != 0.0) {
                    gasStationService.saveGasStation(new GasStationEntity(city, location, working_hours, phone_number, latitude, longitude));
                }
            } else {
                flag = true;
            }

        }
        bufferedReader.close();


    }

}
