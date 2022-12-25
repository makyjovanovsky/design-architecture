package com.example.springapp.repository;

import com.example.springapp.entity.ConfirmationTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenEntity,Long> {
    Optional<ConfirmationTokenEntity> findByToken(String token);
}
