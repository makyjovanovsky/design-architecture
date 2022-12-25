package com.example.springapp.service;

import com.example.springapp.entity.GasStationEntity;
import com.example.springapp.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    @Autowired
    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public void saveGasStation(GasStationEntity gasStationEntity) {
        gasStationRepository.save(gasStationEntity);
    }

    public List<String> getAllStations() {
        List<GasStationEntity> list = gasStationRepository.findAll();
        Set<String> set = new HashSet<>();
        for (GasStationEntity g : list) {
            set.add(g.getCity());
        }
        return new ArrayList<>(set);
    }

    public List<GasStationEntity> findAllGasStationsInCity(String city) {
        return gasStationRepository.findAllByCity(city);
    }
}
