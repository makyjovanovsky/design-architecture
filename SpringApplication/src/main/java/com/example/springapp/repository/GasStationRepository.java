package com.example.springapp.repository;

import com.example.springapp.entity.GasStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasStationRepository extends JpaRepository<GasStationEntity,Long> {
    List<GasStationEntity> findAllByCity(String city);
}
