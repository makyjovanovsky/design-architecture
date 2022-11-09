package com.example.springapp.startup;

import com.example.springapp.entity.GasStationEntity;
import com.example.springapp.pipefilter.Pipe;
import com.example.springapp.pipefilter.impl.FilterDropColumn;
import com.example.springapp.service.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final String FILE_PATH = "D:\\Semestar V\\Dizajn i arhitektura na softver\\Labaratoriski Vezbi\\designandarchitecture\\dataset.csv";
    private final GasStationService gasStationService;

    @Autowired
    public CommandLineAppStartupRunner(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @Override
    public void run(String... args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));

        Pipe<String> pipe = new Pipe<>();
        FilterDropColumn filterDropColumn = new FilterDropColumn();
        pipe.addFilter(filterDropColumn);

        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            String output = pipe.runFilter(line);
            String name = output.split("\\|")[0];
            String location = output.split("\\|")[1];
            String working_hours = output.split("\\|")[2];
            String phone_number = output.split("\\|")[3];
            gasStationService.saveGasStation(new GasStationEntity(name, location, working_hours, phone_number));
        }

        bufferedReader.close();


    }
}
