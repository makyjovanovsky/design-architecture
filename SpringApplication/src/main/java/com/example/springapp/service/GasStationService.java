package com.example.springapp.service;

import com.example.springapp.entity.GasStationEntity;
import com.example.springapp.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
