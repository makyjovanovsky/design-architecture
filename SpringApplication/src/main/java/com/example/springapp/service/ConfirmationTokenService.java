package com.example.springapp.service;

import com.example.springapp.entity.ConfirmationTokenEntity;
import com.example.springapp.entity.user.UserEntity;
import com.example.springapp.repository.ConfirmationTokenRepository;
import com.example.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserRepository userRepository;

    @Autowired
    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository, UserRepository userRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.userRepository = userRepository;
    }


    public void saveConfirmationToken(ConfirmationTokenEntity confirmationTokenEntity) {
        confirmationTokenRepository.save(confirmationTokenEntity);
    }

    @Transactional
    public void confirmToken(String token) throws Exception {
        ConfirmationTokenEntity confirmationTokenEntity = confirmationTokenRepository.findByToken(token).orElseThrow(IllegalStateException::new);
        if (confirmationTokenEntity.getConfirmedAt() != null) {
            throw new Exception();
        }
        LocalDateTime expiresAt = confirmationTokenEntity.getExpiresAt();

        if (expiresAt.isBefore(LocalDateTime.now())) {
            throw new Exception();
        }

        Optional<UserEntity> userEntity = userRepository.findById(confirmationTokenEntity.getUser().getId());
        userEntity.ifPresent(entity -> entity.setValid(true));
        confirmationTokenRepository.delete(confirmationTokenEntity);

    }
}
