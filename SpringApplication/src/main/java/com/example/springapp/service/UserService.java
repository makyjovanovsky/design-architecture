package com.example.springapp.service;

import com.example.springapp.entity.ConfirmationTokenEntity;
import com.example.springapp.entity.user.UserEntity;
import com.example.springapp.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ConfirmationTokenService confirmationTokenService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, ConfirmationTokenService confirmationTokenService, MailService mailService) {
        this.userRepository = userRepository;
        this.confirmationTokenService = confirmationTokenService;
        this.mailService = mailService;
    }

    public boolean registerNewUser(String name, String surname, String email, String password) {

        if (userRepository.findByEmail(email).isPresent()) {
            return false;
        }
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(encoder.encode(password));
        userEntity.setName(name);
        userEntity.setSurname(surname);

        String token = UUID.randomUUID().toString();
        ConfirmationTokenEntity confirmationTokenEntity = new ConfirmationTokenEntity(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                userEntity
        );
        userRepository.save(userEntity);
        confirmationTokenService.saveConfirmationToken(confirmationTokenEntity);
        mailService.send(email,name, token);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<UserEntity> user = userRepository.findByEmail(username);
        if (user.isEmpty() || !user.get().isValid())
            throw new UsernameNotFoundException(username);
        return User.withUsername(user.get().getEmail()).password(user.get().getPassword()).roles(user.get().getRole()).build();
    }
}
