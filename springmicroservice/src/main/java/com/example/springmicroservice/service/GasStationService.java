package com.example.springmicroservice.service;

import com.example.springmicroservice.entity.GasStationEntity;
import com.example.springmicroservice.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GasStationEntity> getAllStations() {
        return gasStationRepository.findAll();
    }

    public List<GasStationEntity> findAllGasStationsInCity(String city) {
        return gasStationRepository.findAllByCity(city);
    }
}

