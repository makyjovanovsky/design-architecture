package com.example.springmicroservice2.service;

import com.example.springmicroservice2.entity.UserEntity;
import com.example.springmicroservice2.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        userRepository.save(userEntity);

        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> user = userRepository.findByEmail(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException(username);
        return User.withUsername(user.get().getEmail()).password(user.get().getPassword()).roles(user.get().getRole()).build();
    }
}
